package com.cg.oam.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.entity.AppUser;
import com.cg.oam.service.AppUserService;
@RestController
@RequestMapping("/user")
public class AppUserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AppUserService appUserService;

/*****************************************************************************************************
	 * Get Method: get-all-users 
	 * Description: It is used to view all users from app_users table
******************************************************************************************************/

	@GetMapping("/getallusers")
	public ResponseEntity<List<AppUser>> getAllAppUsers() {
		LOG.info("get-all-appUsers");
		return new ResponseEntity<List<AppUser>>(appUserService.getAllUsers(), HttpStatus.OK);
	}
	
/*****************************************************************************************************
	 * Post Method: sign-up
	 * Description: It is used to register a user or admin
******************************************************************************************************/
	
	@PostMapping("/signup")
	public ResponseEntity<AppUser> signUp(@RequestBody AppUser appUser) {
		LOG.info(appUser.toString());
		return new ResponseEntity<AppUser>(appUserService.signUpUser(appUser), HttpStatus.CREATED);
	}
	
/*****************************************************************************************************
	 * Post Method: sign-in
	 * Description: It is used to login as a user or admin
******************************************************************************************************/	

	@PostMapping("/signin")
	public ResponseEntity<AppUser> signIn(@RequestBody AppUser appUser) {
		LOG.info(appUser.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User " + appUser.getUserName() + " signed in successfully.");
		return new ResponseEntity<AppUser>(appUserService.signInUser(appUser), headers, HttpStatus.OK);
	}

/*****************************************************************************************************
	 * Put Method: update-user
	 * Description: It is used to update the information
******************************************************************************************************/	

	@PutMapping("/updateuser")
	public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser) {
		LOG.info(appUser.toString());
		return new ResponseEntity<AppUser>(appUserService.updateUser(appUser), HttpStatus.OK);
	}
}	
