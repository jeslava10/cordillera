package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.MesaService;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.excepcion.MesaException;
import com.cordillera.domain.excepcion.NoFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;



@Tag(name="mesa")
@RequiredArgsConstructor
@RestController()
@RequestMapping(value = "/mesa")
public class MesaController {

    private final MesaService mesaService;


    @PostMapping()
    public ResponseEntity<?> grabarMesa(@RequestBody @Valid MesaDto mesaDto) throws MesaException , NoFoundException {
        try{
            return new ResponseEntity<>(mesaService.saveMesa(mesaDto),
                    HttpStatus.CREATED);
        }catch (MesaException me){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(me.getMessage());
        }catch (NoFoundException nfe){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nfe.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> actalizarMesa(@RequestBody MesaDto mesaDto) throws  MesaException  , NoFoundException {
        try{
            return new ResponseEntity<>(mesaService.actulizarMesa(mesaDto), HttpStatus.OK);
        }catch (MesaException me){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(me.getMessage());
        }catch (NoFoundException nfe){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nfe.getMessage());
        }
    }

    @DeleteMapping(path = "/{numeromesa}")
    public ResponseEntity<?> deleteMesa(BigDecimal numeromesa) throws Exception {
        try{
            mesaService.deleteMesa(numeromesa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }
}
