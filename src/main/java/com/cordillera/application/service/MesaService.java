package com.cordillera.application.service;

import com.cordillera.application.services.BaseService;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.dto.MesaPostDto;

import java.util.List;

public interface MesaService extends BaseService<MesaDto, MesaPostDto> {
    MesaDto save(MesaPostDto mesaPostDto);
    void delete(Long id);
    List<MesaDto> findAll();
    MesaDto findById(Long id);

}
