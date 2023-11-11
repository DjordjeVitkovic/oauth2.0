package com.resource.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("resource")
public class DemoController {

  @GetMapping("/demo")
  public ResponseEntity<String> demo() {
    return ResponseEntity.ok("Demo from resource");
  }

  @PostMapping("/demo")
  public ResponseEntity<Map<String, String>> postDemo() {
    return ResponseEntity.ok((Map<String, String>) new HashMap<>().put("demo", "demo"));
  }
}
