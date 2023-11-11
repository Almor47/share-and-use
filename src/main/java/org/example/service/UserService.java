package org.example.service;

import java.util.List;
import org.example.dto.UserDto;
import org.mapstruct.control.MappingControl.Use;

public interface UserService {

  List<UserDto> getAllUsers();

  UserDto getUserById(Integer userId);

  UserDto addUser(UserDto userDto);

  UserDto updateUser(UserDto userDto, Integer userId);

  void deleteUserById(Integer userId);
}
