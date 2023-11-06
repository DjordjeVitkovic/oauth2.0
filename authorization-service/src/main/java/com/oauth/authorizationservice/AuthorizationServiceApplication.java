package com.oauth.authorizationservice;

import com.oauth.authorizationservice.entity.User;
import com.oauth.authorizationservice.repository.RoleRepository;
import com.oauth.authorizationservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;
import java.util.Set;

@SpringBootApplication
public class AuthorizationServiceApplication {


  public static void main(String[] args) {
    SpringApplication.run(AuthorizationServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) {
    return args -> {
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

    };
  }

}
