package org.sid.dto;

import lombok.Data;

@Data
public class DoctorRequest {
	private Long id;
	private String name;
    private String specialty;
    private String email;
    private String phone;
    private String city;
    private String country;
    private String address;
}
