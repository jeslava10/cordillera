package com.cordillera.application.mapper;

import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.models.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CargoMapper {
    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    // Este se usa para traer desde la vista hasta el back
    Cargo cargoDTOToCargoModel(CargoDto cargoDto);

    // Este se usa para traer desde back hasta la vista
    CargoDto cargoModelToCargoDTO(Cargo cargo);
}
