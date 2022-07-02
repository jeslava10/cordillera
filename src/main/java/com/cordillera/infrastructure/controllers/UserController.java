package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.UserService;
import com.cordillera.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @PostMapping("users")
  public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {

    return new ResponseEntity<>(userService.saveUser(userDto),
        HttpStatus.CREATED);

  }

}
