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
  @Column(name = "authentication")
  private String authentication;

  @OneToMany(mappedBy = "client")
  private List<GrantType> grantTypes;

}
