package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @Value("${phrase:nothing}")
  private String phrase;

  @GetMapping
  public String sayHello() {
    return phrase + " from test controller.";
  }

}
