package com.cordillera.application.mapper;

import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.models.Mesa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MesaMapper {
    MesaMapper INSTANCE = Mappers.getMapper(MesaMapper.class);

    Mesa mesaDTOToMesaModel(MesaDto mesaDto);

    MesaDto mesaModeloToMesaDTO(Mesa mesa);

}
