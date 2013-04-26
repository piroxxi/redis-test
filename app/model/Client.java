package model;

import lombok.Data;

@Data
public class Client{
  private String clientId;
  private String name;

  private String URI;
  private String redirectURI;

  private String client_secret;
}
