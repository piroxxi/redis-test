package model;

import lombok.Data;

@Data
public class Grant{
  private String grantId;
  
  /*
   * Only one Grant can exist per triplet.
   */
  private Client client;
  private Scope scope;
  private OasisUser user;
  
  private GrantState state;
}
