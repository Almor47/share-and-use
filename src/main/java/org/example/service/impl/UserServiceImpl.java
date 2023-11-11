package org.example.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.FieldUpdater;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.exception.NotFoundException;
import org.example.mapper.UserMapper;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper mapper;


  @Override
  public List<UserDto> getAllUsers() {
    return userRepository.findAll().stream().map(mapper::UserToUserDto).toList();
  }

  @Override
  public UserDto getUserById(Integer userId) {
    return mapper.UserToUserDto(userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("Пользователь с " + userId + " не найден")));
  }

  @Override
  @Transactional
  public UserDto addUser(UserDto userDto) {
    User userToSave = mapper.UserDtoToUser(userDto);
    userToSave.setRegistrationDate(LocalDateTime.now());
    return mapper.UserToUserDto(userRepository.save(userToSave));
  }

  @Override
  @Transactional
  public UserDto updateUser(UserDto userDto, Integer userId) {
    User userDb = mapper.UserDtoToUser(getUserById(userId));
    FieldUpdater.updateField(userDb::setUserName, userDto.getUserName());
    FieldUpdater.updateField(userDb::setUserSurname, userDto.getUserSurname());
    FieldUpdater.updateField(userDb::setUserGender, userDto.getUserGender());
    FieldUpdater.updateField(userDb::setCity,userDto.getCity());
    FieldUpdater.updateField(userDb::setRegistrationDate, userDto.getRegistrationDate());
    return mapper.UserToUserDto(userRepository.save(userDb));
  }

  @Override
  @Transactional
  public void deleteUserById(Integer userId) {
    getUserById(userId);
    userRepository.deleteById(userId);
  }

}
