package model;

import lombok.Data;

@Data
public enum GrantState {
	Granted, GrantedOnlineOnly, Denied, Postponed, Revoked
}
