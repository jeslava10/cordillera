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
    public ResponseEntity<CargoDto> actualizarCargo(@RequestBody CargoDto cargoDto){
        return new ResponseEntity<>(cargoService.updateCargo(cargoDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CargoDto>> listarCargos(){
        return ResponseEntity.ok(cargoService.listCargo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CargoDto> porId(@PathVariable Long id){
        return ResponseEntity.ok(cargoService.findById(id));
    }

    @GetMapping(path = "/{nombre}")
    public ResponseEntity<CargoDto> porNombre(@PathVariable String nombre){
        return ResponseEntity.ok(cargoService.findByNombre(nombre));
    }

}
