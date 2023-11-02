package com.oauth.authorizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "redirect_urls")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedirectUrl {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "url")
  private String url;
  @Column(name = "client_id")
  private Integer clientId;

}
