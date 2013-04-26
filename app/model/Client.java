package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class Client {
	@Id
	public Long _johm_id;

	@Attribute
	@Indexed
	private String clientId;
	@Attribute
	private String name;

	@Attribute
	private String URI;
	@Attribute
	private String redirectURI;

	@Attribute
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
