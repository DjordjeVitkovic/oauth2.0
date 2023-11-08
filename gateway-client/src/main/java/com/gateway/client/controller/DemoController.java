package com.gateway.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping
  public ResponseEntity<String> getDemo() {
    return ResponseEntity.ok("Demo demo.");
  }

}
