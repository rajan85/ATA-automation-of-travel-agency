package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialsDaoImpl;

public interface User {
		String login(CredentialsBean crendentialsBean);
		boolean logout(String UserId);
		String changePassword(CredentialsBean credentialsBean , String newPassword );
		String register(CredentialsBean credentialsBean , String prefix);
}
