package com.oauth.authorizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grant_types")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrantType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "grant_type")
  private String grantType;
  @ManyToOne
  private Client client;

}
