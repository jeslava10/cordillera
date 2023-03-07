package com.cordillera.application.serviceimpl;

import com.cordillera.application.mapper.MesaMapper;
import com.cordillera.application.repository.jpa.MesaRepository;
import com.cordillera.application.services.BaseService;
import com.cordillera.domain.dto.MesaDto;
import com.cordillera.domain.dto.MesaPostDto;
import com.cordillera.domain.excepcion.MesaException;
import com.cordillera.domain.models.Mesa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.cordillera.application.resources.MensajesErrores.MESA_NO_EXISTEN_CONSULTAR;
import static com.cordillera.application.resources.MensajesErrores.MESA_NO_EXISTE_CONSULTAR;
import static com.cordillera.application.resources.MensajesErrores.MESA_NO_EXISTE_DELETE;
import static com.cordillera.application.resources.MensajesErrores.MESA_NO_EXISTE_UPDATE;
import static com.cordillera.application.resources.MensajesErrores.MESA_NUMERO_EXISTE;
import static com.cordillera.application.resources.MensajesErrores.MESA_NUMERO_NO_VALIDO;


@Service
@RequiredArgsConstructor
public class MesaService implements BaseService<MesaDto, MesaPostDto> {
    private final MesaMapper mesaMapper;
    @Autowired
    private MesaRepository mesaRepository;
    @Override
    public MesaDto save(MesaPostDto mesaPostDto) {
        if(mesaRepository.findByNumeroMesa(mesaPostDto.getNumeroMesa()).isPresent()){
            throw new MesaException(MESA_NUMERO_EXISTE.getValue());
        }
        if(mesaPostDto.getNumeroMesa() < 0){
            throw new MesaException(MESA_NUMERO_NO_VALIDO.getValue());
        }
        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(mesa.getNumeroMesa());
        return mesaMapper.toDto(mesa);
     }
    @Override
    public void delete(Long id) {
        if(!mesaRepository.findById(id).isPresent()){
            throw new MesaException(MESA_NO_EXISTE_DELETE.getValue());
        }
        mesaRepository.deleteById(id);
    }
    @Override
    public List<MesaDto> findAll() {
        List<Mesa> listMesa = mesaRepository.findAll();
        if(listMesa.isEmpty()){
            throw new MesaException(MESA_NO_EXISTEN_CONSULTAR.getValue());
        }

        return listMesa.stream().map(mesaMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public MesaDto findById(Long id) {
        Optional<Mesa> optMesa = mesaRepository.findById(id);
        if(!optMesa.isPresent()){
            throw new MesaException(MESA_NO_EXISTE_CONSULTAR.getValue());
        }

        return optMesa.map(mesaMapper::toDto).get();
    }
    @Override
    public MesaDto update(MesaDto mesaDto) {
        if(!mesaRepository.findById(mesaDto.getIdMesa()).isPresent()){
            throw new MesaException(MESA_NO_EXISTE_UPDATE.getValue());
        }
        Optional<Mesa> mesa = mesaRepository.findByNumeroMesa(mesaDto.getNumeroMesa());
        if(mesa.isPresent() && mesa.get().getIdMesa() != mesaDto.getIdMesa()) {
            throw new MesaException(MESA_NUMERO_EXISTE.getValue());
        }
        return mesaMapper.toDto(mesaRepository.save(mesaMapper.toModel(mesaDto)));
    }
}
