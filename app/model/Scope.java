package model;

public class Scope {
	private String scopeId;
	private String label;

	private VirtualScope virtualScope;
	private String description;

	public Scope() {
		super();
	}

	public Scope(String scopeId, String label, VirtualScope virtualScope, String description) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.virtualScope = virtualScope;
		this.description = description;
	}

	public Scope(String scopeId, String label, VirtualScope virtualScope) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.virtualScope = virtualScope;
	}

	public Scope(String scopeId, String label, String description) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.description = description;
	}


	public Scope(String scopeId, String label) {
		super();
		this.scopeId = scopeId;
		this.label = label;
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
}
