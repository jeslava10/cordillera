package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.CargoService;
import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.dto.CargoPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/cargos")
public class CargoController {
    private final CargoService cargoService;

    @PostMapping()
    public ResponseEntity<ControllerResponseDto<CargoDto>> guardarCargo(@RequestBody CargoPostDto cargoPostDto) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(cargoService.saveCargo(cargoPostDto)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<CargoDto>> borrarCargo(@PathVariable Long id){
        try {
            cargoService.deleteCargo(id);
            return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }

    }

    @PutMapping()
    public ResponseEntity<ControllerResponseDto<CargoDto>> actualizarCargo(@RequestBody CargoDto cargoDto){
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(cargoService.updateCargo(cargoDto)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

    @GetMapping()
    public ResponseEntity<ControllerResponseDto<List<CargoDto>>> listarCargos(){
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(cargoService.listCargo()));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<CargoDto>> porId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(cargoService.findById(id)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

    @GetMapping(path = "/{nombre}")
    public ResponseEntity<ControllerResponseDto<CargoDto>> porNombre(@PathVariable String nombre){
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(cargoService.findByNombre(nombre)));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(e));
        }
    }

}
