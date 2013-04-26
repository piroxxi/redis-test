package model;

import lombok.Data;

@Data
public class ResourceServer {
	private String serverId;
	private String name;

	private String URI;

	private String client_secret;
}