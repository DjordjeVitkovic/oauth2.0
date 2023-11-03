package com.oauth.authorizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clients")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "client_id")
  private String clientId;
  @Column(name = "client_secret")
  private String clientSecret;

  @OneToMany(mappedBy = "client")
  private List<AuthenticationMethod> authentication;

  @OneToMany(mappedBy = "client")
  private List<GrantType> grantTypes;

  @OneToMany(mappedBy = "client")
  private List<RedirectUrl> redirectUrls;

  @OneToMany(mappedBy = "client")
  private List<Scope> scopes;

}
