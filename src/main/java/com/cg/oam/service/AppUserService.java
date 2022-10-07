package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entity.AppUser;

public interface AppUserService {

	public abstract List<AppUser> getAllUsers();

	public abstract AppUser registerUser(AppUser user);

	public abstract AppUser loginUser(AppUser user);

	public abstract String logoutUser(String userName);

	public abstract AppUser updateUser(AppUser user);
}
