package com.tiremgmt.membersvc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import com.tiremgmt.tiremgmtcommon.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {

	public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$"; 
			//"^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	public static final String MOBILE_NUMBER_REGEX = "(0/91)?[7-9][0-9]{9}";
	public static final String PAN_REGEX = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
	
	public static boolean isValid(String input,String regex) {
//		boolean isValid = false;
//		if(!StringUtils.isEmpty(input))
//			isValid = regex.matches(input);
//		log.info("is valid for input : {} - {} ",input,isValid);
//		return isValid;
		
		boolean isValid = false;
		Pattern pattern = Pattern.compile(regex);
		if(!StringUtils.isEmpty(input))
		{
			Matcher matcher = pattern.matcher(input);
			isValid = matcher.matches();
		}
		    log.info("is valid for input : {} - {} ",input,isValid);
		    return isValid;
	   }
	
	public static void validateMemberDetails(MemberDTO memberDTO) {
		if (memberDTO == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_MEMBER);
		if (!ValidationUtils.isValid(memberDTO.getEmail(), ValidationUtils.EMAIL_REGEX))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_EMAIL_ID + " : " + memberDTO.getEmail());
		if (!ValidationUtils.isValid(memberDTO.getContact(), ValidationUtils.MOBILE_NUMBER_REGEX))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_MOBILE_NUMBER + " : " + memberDTO.getContact());
		if (!ValidationUtils.isValid(memberDTO.getPan(), ValidationUtils.PAN_REGEX))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INVALID_PAN + " : " + memberDTO.getPan());
	}
	
	   public static void main(String[] args) {
	      String email = "john123@gmail.com";
	      System.out.println("The E-mail ID is: " + email);
	      System.out.println("Is the above E-mail ID valid? " + isValid(EMAIL_REGEX,email));
	   }
}
