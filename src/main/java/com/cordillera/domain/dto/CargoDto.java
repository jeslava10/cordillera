package com.cordillera.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CargoDto extends CargoPostDto{
    private Long idCargo;
}
