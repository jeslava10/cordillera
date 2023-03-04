package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.CargoService;
import com.cordillera.domain.dto.CargoDto;
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
    public ResponseEntity<CargoDto> guardarCargo(@RequestBody CargoDto cargoDto){
        return new ResponseEntity<>(cargoService.saveCargo(cargoDto), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> borrarCargo(@PathVariable Long id){
        cargoService.deleteCargo(id);
        return ResponseEntity.ok().build();
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
