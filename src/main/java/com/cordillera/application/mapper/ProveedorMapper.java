package com.cordillera.application.mapper;

import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.dto.ProveedorPostDto;
import com.cordillera.domain.models.Proveedor;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    Proveedor toModel(ProveedorDto proveedorDto);
    ProveedorDto toDto(Proveedor proveedor);
    Proveedor toModel(ProveedorPostDto proveedorPostDto);
}
