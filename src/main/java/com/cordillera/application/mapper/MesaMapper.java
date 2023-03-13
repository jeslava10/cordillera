package com.cordillera.application.mapper;

import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.models.Mesa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesaMapper {
    Mesa toModel(MesaDto mesaDto);
    MesaDto toDto(Mesa mesa);

}
