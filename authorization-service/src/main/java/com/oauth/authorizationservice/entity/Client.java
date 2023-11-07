package com.oauth.authorizationservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

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

  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private List<AuthenticationMethod> authenticationMethods;

  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private List<GrantType> grantTypes;

  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private List<RedirectUrl> redirectUrls;

  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private List<Scope> scopes;

  @OneToOne(mappedBy = "client")
  private ClientTokenSettings clientTokenSettings;

  public static RegisteredClient fromClient(Client client) {
    return RegisteredClient
      .withId(String.valueOf(client.getId()))
      .clientId(client.getClientId())
      .clientSecret(client.getClientSecret())
      .clientAuthenticationMethods(clientAuthenticationMethods(client.getAuthenticationMethods()))
      .authorizationGrantTypes(authorizationGrantTypes(client.getGrantTypes()))
      .scopes(scopes(client.getScopes()))
      .redirectUris(redirectUrls(client.getRedirectUrls()))
      .tokenSettings(TokenSettings.builder()
        .accessTokenTimeToLive(Duration.ofHours(client.clientTokenSettings.getTokenLifespan()))
        .accessTokenFormat(new OAuth2TokenFormat(client.clientTokenSettings.getTokenType()))
        .build())
      .build();
  }

  private static Consumer<Set<AuthorizationGrantType>> authorizationGrantTypes(List<GrantType> grantTypes) {
    return s -> {
      for (GrantType grantType : grantTypes) {
        s.add(new AuthorizationGrantType(grantType.getGrantType()));
      }
    };
  }

  private static Consumer<Set<ClientAuthenticationMethod>> clientAuthenticationMethods(List<AuthenticationMethod> authenticationMethods) {
    return m -> {
      for (AuthenticationMethod authenticationMethod : authenticationMethods) {
        m.add(new ClientAuthenticationMethod(authenticationMethod.getAuthenticationMethod()));
      }
    };
  }

  private static Consumer<Set<String>> scopes(List<Scope> scopes) {
    return s -> {
      for (Scope scope : scopes) {
        s.add(scope.getScope());
      }
    };
  }

  private static Consumer<Set<String>> redirectUrls(List<RedirectUrl> redirectUrls) {
    return s -> {
      for (RedirectUrl redirectUrl : redirectUrls) {
        s.add(redirectUrl.getUrl());
      }
    };
  }
}
