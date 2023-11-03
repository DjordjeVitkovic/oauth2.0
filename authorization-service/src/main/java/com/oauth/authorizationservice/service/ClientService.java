package com.oauth.authorizationservice.service;

import com.oauth.authorizationservice.entity.AuthenticationMethod;
import com.oauth.authorizationservice.entity.Client;
import com.oauth.authorizationservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements RegisteredClientRepository {

  private final ClientRepository clientRepository;

  @Override
  public void save(RegisteredClient registeredClient) {
    Client client = Client.builder()
      .clientId(registeredClient.getClientId())
      .clientSecret(registeredClient.getClientSecret())
      .build();

    client.setAuthentication(registeredClient.getClientAuthenticationMethods()
      .stream()
      .map(clients -> AuthenticationMethod.builder()
        .authenticationMethod(clients.getValue())
        .client(client)
        .build()).collect(Collectors.toList())
    );

    clientRepository.save(client);
  }

  @Override
  public RegisteredClient findById(String id) {
    return null;
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    return null;
  }
}
