package org.sid.interfaces;

import java.util.List;

import org.sid.dto.UserRequest;
import org.sid.entity.User;
import org.sid.security.CustomUserDetails;

public interface UserServiceInterface {
	public User registerUser(String username, String rawPassword);
	String getProfile(CustomUserDetails userDetails);
	List<UserRequest> getAllUsers();
	UserRequest getUserById(Long id);
	UserRequest updateUser(Long id, UserRequest userDTO);
	void deleteUser(Long id);
}
