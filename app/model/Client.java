package model;

public class Client {
	private String clientId;
	private String name;

	private String URI;
	private String redirectURI;

	private String client_secret;

	public Client() {
		super();
	}

	public Client(String clientId, String name, String URI, String redirectURI, String client_secret) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.URI = URI;
		this.redirectURI = redirectURI;
		this.client_secret = client_secret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}

	public String getRedirectURI() {
		return redirectURI;
	}

	public void setRedirectURI(String redirectURI) {
		this.redirectURI = redirectURI;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
}
