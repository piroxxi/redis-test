package model;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class Token {
	@Id
	public Long _johm_id;

	@Attribute
	@Indexed
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
