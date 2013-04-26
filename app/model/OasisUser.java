package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Model;

@Model
public class OasisUser {

	@Id
	private Integer oasisUUID;

	@Attribute
	private String firstName;
	@Attribute
	private String lastName;
	@Attribute
	private String fullName;

	@Attribute
	private String email;

	public OasisUser() {

	}

	public OasisUser(String firstName, String lastName, String fullName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.email = email;
	}


	public Integer getOasisUUID() {
		return oasisUUID;
	}

	public void setOasisUUID(Integer oasisUUID) {
		this.oasisUUID = oasisUUID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
