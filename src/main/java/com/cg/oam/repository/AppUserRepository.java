package com.cg.oam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String>{

}
