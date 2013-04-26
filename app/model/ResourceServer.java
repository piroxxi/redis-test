package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class ResourceServer {
	@Id
	public Long _johm_id;

	@Attribute
	@Indexed
	private String serverId;
	@Attribute
	private String name;

	@Attribute
	private String URI;

	@Attribute
	private String client_secret;

	public ResourceServer() {
		super();
	}

	public ResourceServer(String serverId, String name, String URI, String client_secret) {
		super();
		this.serverId = serverId;
		this.name = name;
		this.URI = URI;
		this.client_secret = client_secret;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
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

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
}
