package model;

import redis.clients.johm.Id;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class Token {
	@Id
	private String tokenId;

	/*
	 * TODO
	 */

	public Token() {
		super();
	}

	public String getTokenId() {
		return tokenId;
	}

	public Token(String tokenId) {
		super();
		this.tokenId = tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
}
