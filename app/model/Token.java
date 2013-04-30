package model;

import java.util.ArrayList;
import java.util.List;

import redis.clients.johm.Attribute;
import redis.clients.johm.CollectionList;
import redis.clients.johm.Id;
import redis.clients.johm.Model;
import redis.clients.johm.SupportAll;

@Model
@SupportAll
public class Token {
	@Id
	private String tokenId;

	@Attribute
	private TokenType type;

	/*
	 * Only for refresh Tokens
	 */
	@CollectionList(of = Grant.class)
	private List<Grant> grants = new ArrayList<>();

	public Token() {
		super();
	}

	public Token(String tokenId, TokenType type, List<Grant> grants) {
		super();
		this.tokenId = tokenId;
		this.type = type;
		this.grants = grants;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public List<Grant> getGrants() {
		return grants;
	}

	public void setGrants(List<Grant> grants) {
		this.grants = grants;
	}
}
