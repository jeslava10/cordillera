package com.cordillera.application.service;

import com.cordillera.application.mapper.ProveedorMapper;
import com.cordillera.application.repository.jpa.ProveedorRepository;
import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.excepcion.NoFoundException;
import com.cordillera.domain.excepcion.ProveedorException;
import com.cordillera.domain.models.Proveedor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorMapper proveedorMapper;

    private final ProveedorRepository proveedorRepository;

    public ProveedorDto saveProveedor(ProveedorDto proveedorDto) throws ProveedorException {
        Proveedor proveedorVal = proveedorRepository.findByIdentificacion(proveedorDto.getIdentificacion()).orElse(null);

        if(proveedorVal!=null){
            throw new ProveedorException("proveedor ya existe en el sistema");
        }
        return proveedorMapper.provewedorModeloToProveedorDTO(proveedorRepository.save(proveedorMapper.proveedorDTOToproveedorModel(proveedorDto)));
    }

    public void deleteProveedor(@PathVariable BigDecimal idproveedor) throws NoFoundException {
        Proveedor proveedorVal = proveedorRepository.findByIdentificacion(idproveedor).orElse(null);
        if(proveedorVal==null){
            throw new NoFoundException("Debe seleccionar almenos un proveedor");
        }
        proveedorRepository.deleteAllById(Collections.singleton(proveedorVal.getIdProveedor()));
    }

    public ProveedorDto updateProveedor(ProveedorDto proveedorDto) throws ProveedorException  , NoFoundException {
        Proveedor proveedorValId = proveedorRepository.findById(proveedorDto.getIdProveedor()).orElse(null);
        if(proveedorValId==null){
            throw new NoFoundException("El proveedor no existe en el sistema");
        }
        Proveedor proveedorVal = proveedorRepository.findByIdentificacion(proveedorDto.getIdentificacion()).orElse(null);
        if(proveedorVal!=null){
            throw new ProveedorException("El identificaicon de proveedor ya esta aosiciado a " + proveedorDto.getNombre() + " " +proveedorDto.getApellido());
        }
        return proveedorMapper.provewedorModeloToProveedorDTO(proveedorRepository.save(proveedorMapper.proveedorDTOToproveedorModel(proveedorDto)));
    }
}
