/**
 * 
 */
package com.tiremgmt.membersvc.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.tiremgmt.membersvc.service.UserService;
import com.tiremgmt.membersvc.utils.BCryptUtils;
import com.tiremgmt.membersvc.utils.Constants;
import com.tiremgmt.tiremgmtcommon.entity.User;
import com.tiremgmt.tiremgmtcommon.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author javacloudmc275
 *
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo  userRepo;
	
	@Override
	public String createUser(User user) {
		Optional<User> existingUser = userRepo.findByUsername(user.getUsername());
		boolean isExistsUserName = existingUser.isPresent();
		log.info("is Exists user name : {} - {}",user.getUsername(),isExistsUserName);
		if(!isExistsUserName) {
			String encodedPassword = BCryptUtils.bcryptPasswordEncoder(user.getPassword());
			user.setPassword(encodedPassword);
			userRepo.save(user);
			log.info("user created successfully : {}",user.getUsername());
			return Constants.CREATE_USER_SUCCESS;
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,Constants.USER_ALREADY_EXISTS);
	}

}
