package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class VirtualScope {
	@Id
	private String virtualScopeId;
	@Attribute
	private String label;
	@Attribute
	private String description;

	public VirtualScope() {
		super();
	}

	public VirtualScope(String virtualScopeId, String label, String description) {
		super();
		this.virtualScopeId = virtualScopeId;
		this.label = label;
		this.description = description;
	}

	public String getVirtualScopeId() {
		return virtualScopeId;
	}

	public void setVirtualScopeId(String virtualScopeId) {
		this.virtualScopeId = virtualScopeId;
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
}
