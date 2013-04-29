package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Model;
import redis.clients.johm.Reference;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class Grant {
	@Id
	private String grantId;

	/*
	 * TODO Only one Grant can exist per triplet.
	 */
	@Reference
	private Client client;
	@Reference
	private Scope scope;
	@Reference
	private OasisUser user;

	@Attribute
	private GrantState state;

	public Grant() {
		super();
	}

	public Grant(String grantId, Client client, Scope scope, OasisUser user, GrantState state) {
		super();
		this.grantId = grantId;
		this.client = client;
		this.scope = scope;
		this.user = user;
		this.state = state;
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public OasisUser getUser() {
		return user;
	}

	public void setUser(OasisUser user) {
		this.user = user;
	}

	public GrantState getState() {
		return state;
	}

	public void setState(GrantState state) {
		this.state = state;
	}
}
