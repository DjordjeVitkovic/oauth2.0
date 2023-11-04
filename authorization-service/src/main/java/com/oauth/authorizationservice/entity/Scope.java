package com.oauth.authorizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scopes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scope {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "scope")
  private String scope;
  @ManyToOne
  private Client client;
}
