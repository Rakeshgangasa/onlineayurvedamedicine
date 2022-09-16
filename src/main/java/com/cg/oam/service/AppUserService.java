package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.AppUser;

public interface AppUserService {

	List<AppUser> getAllUsers();

	AppUser signUpUser(AppUser appUser);

	AppUser signInUser(AppUser appUser);

	AppUser updateUser(AppUser appUser);

}
