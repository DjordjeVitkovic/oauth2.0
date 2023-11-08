package com.resource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource")
public class DemoController {

  @GetMapping("/demo")
  public ResponseEntity<String> demo() {
    return ResponseEntity.ok("Demo from resource");
  }
}
