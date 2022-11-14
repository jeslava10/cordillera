package com.cordillera.application.service;

import com.cordillera.application.mapper.MesaMapper;
import com.cordillera.application.repository.jpa.MesaRepository;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.excepcion.MesaException;
import com.cordillera.domain.excepcion.NoFoundException;
import com.cordillera.domain.models.Mesa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final MesaMapper mesaMapper;
    @Autowired
    private MesaRepository mesaRepository;

    public MesaDto saveMesa(MesaDto mesaDto) throws MesaException {

        Mesa mesaval = mesaRepository.findByNumeroMesa(mesaDto.getNumeroMesa()).orElse(null);

        if(mesaval!=null){
            throw new MesaException("La mesa ya existe en el sistema");
        }
        return mesaMapper.mesaModeloToMesaDTO(mesaRepository.save(mesaMapper.mesaDTOToMesaModel(mesaDto)));
    }

    public void deleteMesa(@PathVariable BigDecimal numeromesa) throws NoFoundException {
        Mesa mesaval = mesaRepository.findByNumeroMesa(numeromesa).orElse(null);
        if(mesaval==null){
            throw new NoFoundException("Debe seleccionar al menos una mesa");
        }
        mesaRepository.deleteAllById(Collections.singleton(mesaval.getIdMesa()));
    }


    public MesaDto actulizarMesa(MesaDto mesaDto) throws MesaException  , NoFoundException {
        Mesa mesaValId = mesaRepository.findById(mesaDto.getIdMesa()).orElse(null);
        if(mesaValId==null){
            throw new NoFoundException("La mesa no existe en el sistema");
        }
        Mesa mesaValMesa = mesaRepository.findByNumeroMesa(mesaDto.getNumeroMesa()).orElse(null);
        if(mesaValMesa!=null){
            throw new MesaException("La mesa YA existe en el sistema");
        }
        return mesaMapper.mesaModeloToMesaDTO(mesaRepository.save(mesaMapper.mesaDTOToMesaModel(mesaDto)));
    }
}
