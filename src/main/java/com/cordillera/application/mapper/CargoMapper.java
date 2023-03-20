package com.cordillera.application.mapper;

import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.models.Cargo;
import org.mapstruct.Mapper;

// con esta notacion hacemos que le mapper sea un componente springboot Spring IoC
@Mapper(componentModel = "spring")
public interface CargoMapper {

    // Este se usa para traer desde la vista hasta el back
    Cargo cargoDTOToCargoModel(CargoDto cargoDto);

    // Este se usa para traer desde back hasta la vista
    CargoDto cargoModelToCargoDTO(Cargo cargo);
}
