package model;

public class Grant {
	private String grantId;

	/*
	 * TODO Only one Grant can exist per triplet.
	 */
	private Client client;
	private Scope scope;
	private OasisUser user;

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
