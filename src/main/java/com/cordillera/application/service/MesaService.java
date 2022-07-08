package com.cordillera.application.service;

import com.cordillera.application.mapper.MesaMapper;
import com.cordillera.application.repository.jpa.MesaRepository;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.models.Mesa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final MesaMapper mesaMapper;
    @Autowired
    private MesaRepository mesaRepository;

    public MesaDto saveMesa(MesaDto mesaDto) throws Exception {
        Optional<Mesa> mesaval = mesaRepository.findById(mesaDto.getIdMesa());
        if(!mesaval.isEmpty()){
            throw new Exception("La mesa ya existe en el sistema");
        }else{
            return mesaMapper.mesaModeloToMesaDTO(mesaRepository.save(mesaMapper.mesaDTOToMesaModel(mesaDto)));
        }
    }

    public void borrarMesa(@PathVariable Long idmesa) throws Exception {
        Optional<Mesa> mesaval = mesaRepository.findById(idmesa);
        if(mesaval.isEmpty()){
            throw new Exception("Debe seleccionar al menos una mesa");
        }else{
            mesaRepository.deleteAllById(Collections.singleton(idmesa));
        }
    }

    public MesaDto actulizarMesa(MesaDto mesaDto) throws Exception {
        Optional<Mesa> mesaval = mesaRepository.findById(mesaDto.getIdMesa());
        if(mesaval.isEmpty()){
            throw new Exception("La mesa no existe en el sistema");
        }else{
            return mesaMapper.mesaModeloToMesaDTO(mesaRepository.save(mesaMapper.mesaDTOToMesaModel(mesaDto)));
        }
    }
}
