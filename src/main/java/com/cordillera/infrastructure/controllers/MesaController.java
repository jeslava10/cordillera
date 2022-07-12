package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.MesaService;
import com.cordillera.domain.dto.MesaDto;
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
@Tag(name="mesa")
public class MesaController {
    private final MesaService mesaService;

    @PostMapping("mesa")
    public ResponseEntity<?> grabaMesa(@RequestBody @Valid MesaDto mesaDto) throws Exception {
        try{
            return new ResponseEntity<>(mesaService.saveMesa(mesaDto),
                    HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }

    @PutMapping("mesa")
    public ResponseEntity<?> actalizaMesa(@RequestBody MesaDto mesaDto) throws Exception {
        try{
            return new ResponseEntity<>(mesaService.actulizarMesa(mesaDto), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }

    @DeleteMapping(path = "mesa/{numeromesa}")
    public ResponseEntity<?> deleteMesa(BigDecimal numeromesa) throws Exception {
        try{
            mesaService.borrarMesa(numeromesa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }
}
