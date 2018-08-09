package com.ata.util;

import javax.crypto.*;
import javax.crypto.spec.*;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class Encryption {
	private String characterEncoding; // for a fix charachter encoding scheme
	private Cipher encryptCipher; 
	private Cipher decryptCipher; 
	private BASE64Encoder base64Encoder = new BASE64Encoder(); 
	private BASE64Decoder base64Decoder = new BASE64Decoder(); 

	static public class EncryptionException extends Exception {
		private EncryptionException(String text, Exception chain) {
			super(text, chain);
		}
	}

	public Encryption(byte[] keyBytes, byte[] ivBytes) throws EncryptionException {
		assert (keyBytes != null) && (keyBytes.length == 24); // ???
		assert (ivBytes != null) && (ivBytes.length == 8); // ????
		assert (characterEncoding != null);

		try {
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			IvParameterSpec iv = new IvParameterSpec(ivBytes);
			this.characterEncoding = "UTF-8";
			this.encryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding", "SunJCE");
			this.encryptCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key, iv);
			this.decryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding", "SunJCE");
			this.decryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv); // ???
		} catch (Exception e) {
			throw new EncryptionException("Problem constructing " + this.getClass().getName(), e);
		}
	}

	synchronized public String encrypt(String dataString) throws EncryptionException {
		assert dataString != null;

		try {
			byte[] dataStringBytes = dataString.getBytes(characterEncoding);
			byte[] encryptedDataStringBytes = this.encryptCipher.doFinal(dataStringBytes);
			String encodedEncryptedDataString = this.base64Encoder.encode(encryptedDataStringBytes);
			return encodedEncryptedDataString;
		} catch (Exception e) {
			throw new EncryptionException("Problem encrypting string", e);
		}
	}

	synchronized public String decrypt(String encodedEncryptedDataString) throws EncryptionException {
		assert encodedEncryptedDataString != null;

		try {
			byte[] encryptedDataStringBytes = this.base64Decoder.decodeBuffer(encodedEncryptedDataString);
			byte[] dataStringBytes = this.decryptCipher.doFinal(encryptedDataStringBytes);
			String dataString = new String(dataStringBytes, characterEncoding);
			return dataString;
		} catch (Exception e) {
			throw new EncryptionException("Problem decrypting string", e);
		}
	}
	
	

	public static void main(String[] args) {
		try {
			// Make sure SUN JCE are a provider
			Security.addProvider(new com.sun.crypto.provider.SunJCE());

			// The DES EDE Key - any 24 bytes will do though beware of weak
			// keys.
			// This could be read from a file.
			final byte[] keyBytes = "0123456789ABCDEF01234567".getBytes("ASCII");

			// IV For CBC mode
			// Again, could be read from a file.
			final byte[] IVBytes = "ABCDEFGH".getBytes("ASCII");

			// Change character encoding as required.
			Encryption dataStringEncryptAgent = new Encryption(keyBytes, IVBytes);

			// Get the data string to encrypt from the command line
			String dataString = "meghaischui";
			System.out.println("Data string ....................[" + dataString + "]");

			String encodedEncryptedDataString = dataStringEncryptAgent.encrypt(dataString);
			System.out.println("Encoded encrypted data string ..[" + encodedEncryptedDataString + "]");

			String recoveredDataString = dataStringEncryptAgent.decrypt(encodedEncryptedDataString);
			System.out.println("Recovered data string ..........[" + recoveredDataString + "]");
			
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
