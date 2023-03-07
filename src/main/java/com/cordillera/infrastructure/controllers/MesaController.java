package com.cordillera.infrastructure.controllers;

import com.cordillera.application.serviceimpl.MesaService;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.dto.MesaPostDto;
import com.cordillera.domain.excepcion.MesaException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@Tag(name = "mesa")
@RequiredArgsConstructor
@RestController("mesa")
public class MesaController {

    private final MesaService mesaService;


    @PostMapping()
    public ResponseEntity<ControllerResponseDto<MesaDto>> save(@RequestBody @Valid MesaPostDto mesaPostDto) throws MesaException {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(mesaService.save(mesaPostDto)));
        } catch (MesaException me) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(me));
        }
    }

    @PutMapping()
    public ResponseEntity<ControllerResponseDto<MesaDto>> update(@RequestBody MesaDto mesaDto) throws MesaException {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(mesaService.update(mesaDto)));
        } catch (MesaException me) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(me));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<MesaDto>> delete(Long id) throws MesaException {
        try {
            mesaService.delete(id);
            return ResponseEntity.ok(ControllerResponseDto.fromValid(null));
        } catch (MesaException me) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(me));
        }
    }

    @GetMapping()
    public ResponseEntity<ControllerResponseDto<List<MesaDto>>> findAll() {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(mesaService.findAll()));
        } catch (MesaException me) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(me));
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ControllerResponseDto<MesaDto>> findById(Long id) {
        try {
            return ResponseEntity.ok(ControllerResponseDto.fromValid(mesaService.findById(id)));
        } catch (MesaException me) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ControllerResponseDto.fromError(me));
        }
    }
}
