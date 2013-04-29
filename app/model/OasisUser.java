package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class OasisUser {
	@Id
	private String oasisUUID;

	@Attribute
	private String firstName;
	@Attribute
	private String lastName;
	@Attribute
	private String fullName;

	@Attribute
	private String email;

	public OasisUser() {
		super();
	}

	public OasisUser(String oasisUUID, String firstName, String lastName, String fullName,
	    String email) {
		super();
		this.oasisUUID = oasisUUID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.email = email;
	}

	public String getOasisUUID() {
		return oasisUUID;
	}

	public void setOasisUUID(String oasisUUID) {
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
