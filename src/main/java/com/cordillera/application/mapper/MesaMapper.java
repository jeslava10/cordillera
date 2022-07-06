package com.cordillera.application.mapper;

import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.models.Mesa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MesaMapper {
    MesaMapper INTERFASE = Mappers.getMapper(MesaMapper.class);

    Mesa toEntity(MesaDto mesaDto);

    MesaDto toDTO(Mesa mesa);

}
