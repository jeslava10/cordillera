package com.cordillera.application.service;

import com.cordillera.application.services.BaseService;
import com.cordillera.domain.dto.ProveedorDto;
import com.cordillera.domain.dto.ProveedorPostDto;

import java.util.List;

public interface ProveedorService extends BaseService<ProveedorDto, ProveedorPostDto> {
    ProveedorDto save(ProveedorPostDto proveedorPostDto);
    void delete(Long id);
    List<ProveedorDto> findAll();
    ProveedorDto findById(Long id);
    ProveedorDto update(ProveedorDto proveedorDto);
}
