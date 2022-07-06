package com.cordillera.application.service;

import com.cordillera.application.mapper.MesaMapper;
import com.cordillera.domain.dto.MesaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final MesaMapper mesaMapper;

    public MesaDto saveMesa(MesaDto toEntity){
        return toEntity;
    }

}
