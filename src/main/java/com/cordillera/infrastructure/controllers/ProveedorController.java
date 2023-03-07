package com.cordillera.infrastructure.controllers;

import com.cordillera.application.serviceimpl.ProveedorService;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.dto.ProveedorPostDto;
import com.cordillera.domain.excepcion.ProveedorException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/")
@Tag(name="proveedor")
public class ProveedorController {
    private final ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<ControllerResponseDto<ProveedorDto>> save(@RequestBody @Valid ProveedorPostDto proveedorPostDto){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(proveedorService.save(proveedorPostDto)));
        }catch (ProveedorException pe){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(pe));
        }
    }

    @PutMapping
    public ResponseEntity<ControllerResponseDto<ProveedorDto>> update(@RequestBody ProveedorDto proveedorDto){
        try{
            return ResponseEntity.ok(ControllerResponseDto.fromValid(proveedorService.update(proveedorDto)));
        }catch (ProveedorException pe){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(pe));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<ProveedorDto>> delete(Long id){
        try{
            proveedorService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ProveedorException pe) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(pe));
        }
    }

}
