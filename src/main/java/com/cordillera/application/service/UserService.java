package com.cordillera.application.service;

import com.cordillera.application.mapper.UserMapper;
import com.cordillera.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserDto saveUser(UserDto toEntity) {
        return toEntity;
    }
}
