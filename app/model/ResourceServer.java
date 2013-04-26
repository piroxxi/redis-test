package model;

public class ResourceServer {
	private String serverId;
	private String name;

	private String URI;

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