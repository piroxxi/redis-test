package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Model;
import redis.clients.johm.Reference;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class Scope {
	@Id
	private String scopeId;
	@Attribute
	private String label;

	@Reference
	private VirtualScope virtualScope;
	@Attribute
	private String description;
	@Reference
	private ResourceServer resourceServer;

	public Scope() {
		super();
	}

	public Scope(String scopeId, String label, ResourceServer resourceServer,
	    VirtualScope virtualScope, String description) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.virtualScope = virtualScope;
		this.description = description;
		this.setResourceServer(resourceServer);
	}

	public Scope(String scopeId, String label, ResourceServer resourceServer,
	    VirtualScope virtualScope) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.virtualScope = virtualScope;
		this.setResourceServer(resourceServer);
	}

	public Scope(String scopeId, String label, ResourceServer resourceServer, String description) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.description = description;
		this.setResourceServer(resourceServer);
	}


	public Scope(String scopeId, String label, ResourceServer resourceServer) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.setResourceServer(resourceServer);
	}

	public String getScopeId() {
		return scopeId;
	}

	public void setScopeId(String scopeId) {
		this.scopeId = scopeId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VirtualScope getVirtualScope() {
		return virtualScope;
	}

	public void setVirtualScope(VirtualScope virtualScope) {
		this.virtualScope = virtualScope;
	}

	public ResourceServer getResourceServer() {
	  return resourceServer;
  }

	public void setResourceServer(ResourceServer resourceServer) {
	  this.resourceServer = resourceServer;
  }
}
