package model;

public class OasisUser {
	private String oasisUUID;

	private String firstName;
	private String lastName;
	private String fullName;

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
