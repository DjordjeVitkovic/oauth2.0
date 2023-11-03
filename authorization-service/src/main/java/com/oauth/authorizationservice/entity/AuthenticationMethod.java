package com.oauth.authorizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authentication_methods")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationMethod {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "authentication_method")
  private String authenticationMethod;
  @ManyToOne
  private Client client;

}
