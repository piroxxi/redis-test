package model;

import lombok.Data;

@Data
public class OasisUser {
	private String oasisUUID;

	private String firstName;
	private String lastName;
	private String fullName;

	private String email;
}
