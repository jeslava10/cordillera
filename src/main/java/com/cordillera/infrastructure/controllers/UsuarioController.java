package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.UsuarioService;
import com.cordillera.domain.dto.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
@Tag(name="usuario")
@RequestMapping(value = "/usuario")
public class UsuarioController {

  private final UsuarioService usuarioService;

  @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Operation(
          summary = "Metodo para guardar un usuario",
          operationId = "saveUser"
  )
    @PostMapping()
     public ResponseEntity<ControllerResponseDto<UsuarioDto>> saveUser(@RequestBody UsuarioDto usuarioDto) {
      try {
          return ResponseEntity.ok(ControllerResponseDto.fromValid(usuarioService.saveUsuario(usuarioDto)));
      } catch (Exception e){
          return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
      }
  }

    @PutMapping()
    public ResponseEntity<ControllerResponseDto<UsuarioDto>> updateUser(@RequestBody UsuarioDto UsuarioDto){
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(usuarioService.updateUser(UsuarioDto)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<UsuarioDto>> deleteUser(@PathVariable Long id){
        try {
            usuarioService.deleteUser(id);
            return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

    @GetMapping()
    public ResponseEntity<ControllerResponseDto<List<UsuarioDto>>> listUser(){
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(usuarioService.listUser()));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }
    

}
