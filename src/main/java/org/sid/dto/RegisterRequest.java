package org.sid.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String roles;
	  private double latitude;  
	  
	  private double longitude;

	  private String address;

	  private String city;

	  private String phone;
	  
	
	  private String specialty;
	  private boolean available;
}