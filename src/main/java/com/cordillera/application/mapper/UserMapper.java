package com.cordillera.application.mapper;


import com.cordillera.domain.dto.UserDto;
import com.cordillera.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

  User toEntity(UserDto userDto);

  UserDto toDTO(User user);

}
