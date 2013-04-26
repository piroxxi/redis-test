package model;

import lombok.Data;

@Data
public class Scope {
	private String scopeId;
	private String label;

	private String description;
	private VirtualScope virtualScope;
}