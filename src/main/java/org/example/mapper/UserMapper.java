package org.example.mapper;

import org.example.dto.UserDto;
import org.example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "userId", ignore = true)
  User UserDtoToUser(UserDto userDto);

  @Mapping(target = "userId", ignore = true)
  UserDto UserToUserDto(User user);

}
