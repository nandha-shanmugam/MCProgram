/**
 * 
 */
package com.tiremgmt.membersvc.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author javacloudmc275
 *
 */
@Slf4j
public class BCryptUtils {

	public static String bcryptPasswordEncoder(String password) {
		log.info("password : {}",password);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
//		log.info("Encoded Password is : {}",encodedPassword);
//		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
//		log.info("Password : {} -  isPasswordMatch : {}",password,isPasswordMatch);
		return encodedPassword;
	}
	
	public static void main(String args[]) {
		log.info("Password - Encrypt using Bcrypt");
		String password = "passowrd";
		bcryptPasswordEncoder(password);
	}
}
