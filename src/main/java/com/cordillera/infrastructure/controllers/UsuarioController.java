package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.UserService;
import com.cordillera.domain.dto.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Tag(name="User")
public class UsuarioController {

  private final UserService userService;

  @Operation(
          summary = "Metodo para guardar un usuario",
          operationId = "saveUser"
  )
    @PostMapping("users")
     public ResponseEntity<UsuarioDto> saveUser(@RequestBody UsuarioDto usuarioDto) {
   return new ResponseEntity<>(userService.saveUser(usuarioDto),
       HttpStatus.CREATED);
  }

}
