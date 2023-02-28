package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.CargoService;
import com.cordillera.domain.dto.CargoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/cargos")
public class CargoController {

    private final CargoService cargoService;

    @PostMapping()
    public ResponseEntity<?> guardarCargo(@RequestBody CargoDto cargoDto){
        return new ResponseEntity<>(cargoService.saveCargo(cargoDto), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> borrarCargo(@PathVariable Long id){
        cargoService.deleteCargo(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping()
    public ResponseEntity<?> actualizarCargo(@RequestBody CargoDto cargoDto){
        return new ResponseEntity<>(cargoService.updateCargo(cargoDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> listarCargos(){
        return ResponseEntity.ok(cargoService.listCargo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> porId(@PathVariable Long id){
        return ResponseEntity.ok(cargoService.findById(id));
    }

    @GetMapping(path = "/{nombre}")
    public ResponseEntity<?> porNombre(@PathVariable String nombre){
        return ResponseEntity.ok(cargoService.findByNombre(nombre));
    }

}
