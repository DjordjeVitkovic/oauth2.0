package com.oauth.authorizationservice.service;

import com.oauth.authorizationservice.entity.*;
import com.oauth.authorizationservice.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ClientService implements RegisteredClientRepository {

  private final ClientRepository clientRepository;

  @Override
  @Transactional
  public void save(RegisteredClient registeredClient) {
    Client client = Client.builder()
      .clientId(registeredClient.getClientId())
      .clientSecret(registeredClient.getClientSecret())
      .build();

    client.setAuthenticationMethods(registeredClient.getClientAuthenticationMethods()
      .stream()
      .map(clients -> AuthenticationMethod.builder()
        .authenticationMethod(clients.getValue())
        .client(client)
        .build()).collect(Collectors.toList())
    );

    client.setGrantTypes(
      registeredClient.getAuthorizationGrantTypes()
        .stream()
        .map(element ->
          GrantType.builder()
            .grantType(element.getValue())
            .client(client)
            .build()
        )
        .collect(Collectors.toList())
    );

    client.setRedirectUrls(
      registeredClient.getRedirectUris()
        .stream()
        .map(element ->
          RedirectUrl.builder()
            .url(element)
            .client(client)
            .build()
        )
        .collect(Collectors.toList())
    );

    client.setScopes(
      registeredClient.getScopes()
        .stream()
        .map(element ->
          Scope.builder()
            .scope(element)
            .client(client)
            .build()
        )
        .collect(Collectors.toList())
    );

    clientRepository.save(client);
  }

  @Override
  public RegisteredClient findById(String id) {
    var client = clientRepository.findById(Integer.parseInt(id));

    return client.map(Client::fromClient)
      .orElseThrow(() -> new RuntimeException("Error while mapping clients."));
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    var client = clientRepository.findByClientId(clientId);

    return client.map(Client::fromClient)
      .orElseThrow(() -> new RuntimeException("Error while mapping clients."));
  }
}
