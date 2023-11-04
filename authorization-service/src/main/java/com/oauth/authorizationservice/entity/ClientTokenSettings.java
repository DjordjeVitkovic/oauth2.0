package com.oauth.authorizationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_token_settings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientTokenSettings {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "token_lifespan")
  private Integer tokenLifespan;
  @Column(name = "token_type")
  private String tokenType;
  @OneToOne
  private Client client;

}
