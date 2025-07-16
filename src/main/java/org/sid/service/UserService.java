package org.sid.service;

import java.util.List;

import org.sid.dto.UserRequest;
import org.sid.entity.User;
import org.sid.interfaces.UserServiceInterface;
import org.sid.repository.UserRepository;
import org.sid.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public User registerUser(String username, String rawPassword, String roles) {
	        User user = new User();
	        user.setUsername(username);
	        user.setPassword(passwordEncoder.encode(rawPassword));  // hash password
	        user.setRoles(roles);  // default role

	        return userRepository.save(user);
	    }

		@Override
		public String getProfile(CustomUserDetails userDetails) {
			return "Hello, " + userDetails.getUsername() + "! Your roles: " + userDetails.getAuthorities();
		}

		@Override
		public List<UserRequest> getAllUsers() {
			return userRepository.findAll().stream().map(this::mapToDTO).toList();
		}

		@Override
		public UserRequest getUserById(Long id) {
			 User user = userRepository.findById(id)
			            .orElseThrow(() -> new RuntimeException("User not found"));
			    return mapToDTO(user);
		}

		@Override
		public UserRequest updateUser(Long id, UserRequest userDTO) {
			 User user = userRepository.findById(id)
			            .orElseThrow(() -> new RuntimeException("User not found"));
			    user.setUsername(userDTO.getUsername());
			    user.setRoles(userDTO.getRoles());
			    return mapToDTO(userRepository.save(user));
		}

		@Override
		public void deleteUser(Long id) {
			if (!userRepository.existsById(id)) {
		        throw new RuntimeException("User not found");
		    }
		    userRepository.deleteById(id);
			
		}
	    
		// Utility
		private UserRequest mapToDTO(User user) {
			UserRequest dto = new UserRequest();
		    dto.setId(user.getId());
		    dto.setUsername(user.getUsername());
		    dto.setRoles(user.getRoles());
		    return dto;
		}
}
