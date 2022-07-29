package com.cordillera.infrastructure.controllers;

import com.cordillera.application.service.MesaService;
import com.cordillera.application.service.ProveedorService;
import com.cordillera.domain.dto.ProveedorDto;
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
@Tag(name="proveedor")
public class ProveedorController {
    private final ProveedorService proveedorService;

    @PostMapping("provvedor")
    public ResponseEntity<?> saveProveedor(@RequestBody @Valid ProveedorDto proveedorDto){
        try{
            return new ResponseEntity<>(proveedorService.saveProveedor(proveedorDto),
                    HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }

    @PutMapping("proveedor")
    public ResponseEntity<?> updateProveedor(@RequestBody ProveedorDto proveedorDto){
        try{
            return new ResponseEntity<>(proveedorService.updateProveedor(proveedorDto), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }

    @DeleteMapping(path = "mesa/{numeromesa}")
    public ResponseEntity<?> deleteProveedor(BigDecimal idproveedor){
        try{
            proveedorService.deleteProveedor(idproveedor);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() +"\"}");
        }
    }

}
