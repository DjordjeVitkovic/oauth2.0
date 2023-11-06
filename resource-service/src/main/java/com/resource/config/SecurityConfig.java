package com.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    // TODO: 11/6/2023 This should be in propery file
    /*
     This is not good if we want to support revocation because this will never again call token introspection
     http.oauth2ResourceServer(
     c -> c.jwt(
     jwt -> jwt.jwkSetUri("http://localhost:8080/oauth2/jwks")
     )
     );
     */

    http.oauth2ResourceServer(
      c -> c.opaqueToken(
        o -> o.introspectionUri("http://localhost:8080/oauth2/introspect")
          // Here we are registering our app as a client because resorce service calling auth-service as a client
          .introspectionClientCredentials("resource-service", "secret")
      )
    );

    http.authorizeHttpRequests(
      request -> request.anyRequest().authenticated()
    );

    return http.build();
  }
}
