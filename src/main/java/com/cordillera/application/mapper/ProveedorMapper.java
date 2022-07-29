package com.cordillera.application.mapper;

import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.models.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProveedorMapper {
    ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

    Proveedor proveedorDTOToproveedorModel(ProveedorDto proveedorDto);

    ProveedorDto provewedorModeloToProveedorDTO(Proveedor proveedor);


}
