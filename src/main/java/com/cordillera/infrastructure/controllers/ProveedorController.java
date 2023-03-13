package com.cordillera.infrastructure.controllers;

import com.cordillera.application.serviceimpl.ProveedorServiceImpl;
import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.dto.ProveedorPostDto;
import com.cordillera.domain.excepcion.ProveedorException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/proveedor/")
@Tag(name="proveedor")
public class ProveedorController {
    private final ProveedorServiceImpl proveedorService;

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

    @GetMapping()
    public ResponseEntity<ControllerResponseDto<List<ProveedorDto>>> findAll() {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(proveedorService.findAll()));
        } catch (ProveedorException pe) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(pe));
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<ProveedorDto>> findById(Long id) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(proveedorService.findById(id)));
        } catch (ProveedorException pe) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(pe));
        }
    }

    public ProveedorController(ProveedorServiceImpl proveedorService) {
        this.proveedorService = proveedorService;
    }
}
