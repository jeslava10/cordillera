package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.MesaService;
import com.cordillera.domain.dto.MesaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/")
public class MesaController {
    private final MesaService mesaService;

    @PostMapping("mesa")
    public ResponseEntity<MesaDto> grabaMesa(@RequestBody MesaDto mesaDto) throws Exception {
        return new ResponseEntity<>(mesaService.saveMesa(mesaDto),
                HttpStatus.CREATED);
    }

    @PutMapping("mesa")
    public ResponseEntity<MesaDto> actalizaMesa(@RequestBody MesaDto mesaDto) throws Exception {
        return new ResponseEntity<>(mesaService.actulizarMesa(mesaDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTRM(@PathVariable Long idmesa) throws Exception {

        try{
            mesaService.borrarMesa(idmesa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Does not exist for delete\"}");
        }
    }
}
