package org.example.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public UserDto getUserById(@PathVariable("id") Integer userId) {
    return userService.getUserById(userId);
  }
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto addUser(@RequestBody UserDto userDto) {
    return userService.addUser(userDto);
  }

  @PutMapping("/{id}")
  public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable("id") Integer userId) {
    return userService.updateUser(userDto, userId);
  }

  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable("id") Integer userId) {
    userService.deleteUserById(userId);
    ResponseEntity.ok();
  }

}
