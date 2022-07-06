package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.MesaService;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/mesa")
public class MesaController {
    private final MesaService mesaService;

    @PostMapping("mesa")
    public ResponseEntity<MesaDto> saveMesa(@RequestBody MesaDto mesaDto){
        return new ResponseEntity<>(mesaService.saveMesa(mesaDto),
                HttpStatus.CREATED);
    }


}
