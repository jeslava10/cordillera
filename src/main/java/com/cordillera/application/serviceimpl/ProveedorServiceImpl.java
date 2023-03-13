package com.cordillera.application.serviceimpl;

import com.cordillera.application.mapper.ProveedorMapper;
import com.cordillera.application.repository.jpa.ProveedorRepository;
import com.cordillera.application.service.ProveedorService;
import com.cordillera.application.services.BaseService;
import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.dto.ProveedorPostDto;
import com.cordillera.domain.excepcion.ProveedorException;
import com.cordillera.domain.models.Proveedor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.cordillera.application.resources.MensajesErrores.PROVEEDORES_NO_EXISTEN;
import static com.cordillera.application.resources.MensajesErrores.PROVEEDOR_NO_EXISTE_CONSULTAR;
import static com.cordillera.application.resources.MensajesErrores.PROVEEDOR_NO_EXISTE_DELETE;
import static com.cordillera.application.resources.MensajesErrores.PROVEEDOR_NO_EXISTE_UPDATE;
import static com.cordillera.application.resources.MensajesErrores.PRPVEEDOR_IDENTIFICACION_DUPLICADO;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    private final ProveedorMapper proveedorMapper;
    private final ProveedorRepository proveedorRepository;
    @Override
    public ProveedorDto save(ProveedorPostDto proveedorPostDto) {
        if(proveedorRepository.findByIdentificacion(proveedorPostDto.getIdentificacion()).isPresent()){
            throw new ProveedorException(PRPVEEDOR_IDENTIFICACION_DUPLICADO.getValue());
        }

        return proveedorMapper.toDto(proveedorRepository.save(proveedorMapper.toModel(proveedorPostDto)));
    }
    @Override
    public void delete(Long id) {
        if(!proveedorRepository.findById(id).isPresent()){
            throw new ProveedorException(PROVEEDOR_NO_EXISTE_DELETE.getValue());
        }
        proveedorRepository.deleteById(id);
    }
    @Override
    public List<ProveedorDto> findAll() {
        List<Proveedor> listProveedor = proveedorRepository.findAll();
        if (listProveedor.isEmpty()) {
            throw new ProveedorException(PROVEEDORES_NO_EXISTEN.getValue());
        }
        return listProveedor.stream().map(proveedorMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProveedorDto findById(Long id) {
        Optional<Proveedor> optProveedor = proveedorRepository.findById(id);
        if(!optProveedor.isPresent()){
            throw new ProveedorException(PROVEEDOR_NO_EXISTE_CONSULTAR.getValue());
        }
        return optProveedor.map(proveedorMapper::toDto).get();
    }

    @Override
    public ProveedorDto update(ProveedorDto proveedorDto) {
        if(!proveedorRepository.findById(proveedorDto.getIdProveedor()).isPresent()){
            throw new ProveedorException(PROVEEDOR_NO_EXISTE_UPDATE.getValue());
        }
        Optional<Proveedor> optProveedor = proveedorRepository.findByIdentificacion(proveedorDto.getIdentificacion());
        if(optProveedor.isPresent() && !optProveedor.get().getIdProveedor().equals(proveedorDto.getIdProveedor())){
            throw new ProveedorException(PRPVEEDOR_IDENTIFICACION_DUPLICADO.getValue());
        }

        return proveedorMapper.toDto(proveedorRepository.save(proveedorMapper.toModel(proveedorDto)));
    }
    @Autowired
    public ProveedorServiceImpl(ProveedorMapper proveedorMapper, ProveedorRepository proveedorRepository) {
        this.proveedorMapper = proveedorMapper;
        this.proveedorRepository = proveedorRepository;
    }
}
