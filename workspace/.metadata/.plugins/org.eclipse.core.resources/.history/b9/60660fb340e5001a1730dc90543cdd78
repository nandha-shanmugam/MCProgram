/**
 * 
 */
package com.tiremgmt.membersvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiremgmt.membersvc.service.UserService;
import com.tiremgmt.tiremgmtcommon.entity.User;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author javacloudmc275
 *
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation(value="Create user.",response=Boolean.class)
	@PostMapping(value = "/create")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		log.info("Controller - create user.");
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
}
