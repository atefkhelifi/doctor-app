package org.sid.dto;

import lombok.Data;

@Data
public class UserRequest {
	private Long id;
    private String username;
    private String roles;
}
