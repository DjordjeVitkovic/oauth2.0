package com.oauth.authorizationservice;

import com.oauth.authorizationservice.repository.ClientRepository;
import com.oauth.authorizationservice.repository.RoleRepository;
import com.oauth.authorizationservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthorizationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthorizationServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository, ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
    return args -> {
//      Client client = clientRepository.findByClientId("resource-service")
//        .orElseThrow(() -> new IllegalArgumentException("Client does not exist"));
//      client.setClientSecret(passwordEncoder.encode("secret"));
//      clientRepository.save(client);
//
//      User user = userRepository.findByUsernameOrEmail("djordje")
//        .orElseThrow(() -> new IllegalArgumentException("Client does not exist"));
//      user.setPassword(passwordEncoder.encode("password"));
//      userRepository.save(user);
      /*
      User user = User.builder()
        .username("djordje")
        .password("password")
        .email("djordje@djordje.com")
        .authorities(Set.of(roleRepository.findByAuthority("USER").get()))
        .firstname("Djordje")
        .lastName("Vitkovic")
        .enabled(true)
        .created(ZonedDateTime.now())
        .build();
      userRepository.save(user);
       */
    };
  }

}
