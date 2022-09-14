/*
 * package com.cg.oam.service;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory;
 * 
 * import com.cg.oam.entity.AppUser; import
 * com.cg.oam.exception.AppUserAlreadyExistsException; import
 * com.cg.oam.exception.AppUserNotFoundException; import
 * com.cg.oam.repository.UserRepository;
 * 
 * public class UserServiceImpl implements UserService { private final Logger
 * LOG = LoggerFactory.getLogger(this.getClass());
 * 
 * @Override public List<AppUser> getAllUsers() { List<AppUser> userList =
 * UserRepository.findAll(); if (userList.isEmpty()) { String exceptionMessage =
 * "AppUsers don't exist in the database."; LOG.warn(exceptionMessage); throw
 * new AppUserNotFoundException(exceptionMessage); } else {
 * LOG.info("List returned successfully."); return userList; } }
 * 
 * @Override public AppUser signUpUser(AppUser appUser) {
 * 
 * LOG.info(appUser.toString()); Optional<AppUser> userOptional =
 * UserRepository.findById(appUser.getUserName()); if (userOptional.isEmpty()) {
 * return UserRepository.save(appUser); } else { String exceptionMessage =
 * "User with userName " + appUser.getUserName() + " already exists."; throw new
 * AppUserAlreadyExistsException(exceptionMessage); } }
 * 
 * @Override public AppUser signInUser(AppUser appUser) {
 * LOG.info(appUser.toString()); Optional<AppUser> userOptional =
 * UserRepository.findById(appUser.getUserName()); if (userOptional.isPresent())
 * { if (appUser.equals(userOptional.get())) {
 * LOG.info(userOptional.get().toString()); AppUser signedInUser = appUser;
 * return appUser; } else { String exceptionMessage = "Wrong password!";
 * LOG.warn(exceptionMessage); throw new
 * AppUserNotFoundException(exceptionMessage); } } else { String
 * exceptionMessage = "Wrong userName!"; LOG.warn(exceptionMessage); throw new
 * AppUserNotFoundException(exceptionMessage); } }
 * 
 * @Override public AppUser updateUser(AppUser appUser) { Optional<AppUser>
 * userOptional = UserRepository.findById(appUser.getUserName()); if
 * (userOptional.isPresent()) { LOG.info(userOptional.get().toString()); return
 * UserRepository.save(appUser); } else { String exceptionMessage =
 * "AppUser with userName " + appUser.getUserName() + " not found!";
 * LOG.warn(exceptionMessage); throw new
 * AppUserNotFoundException(exceptionMessage); } } }
 * 
 * }
 */