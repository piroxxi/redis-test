package model;

public class Scope {
	private String scopeId;
	private String label;

	private String description;
	private VirtualScope virtualScope;

	public Scope() {
		super();
	}

	public Scope(String scopeId, String label, String description, VirtualScope virtualScope) {
		super();
		this.scopeId = scopeId;
		this.label = label;
		this.description = description;
		this.virtualScope = virtualScope;
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