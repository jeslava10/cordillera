package com.cordillera.application.service;

import com.cordillera.application.mapper.ProveedorMapper;
import com.cordillera.application.repository.jpa.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorMapper proveedorMapper;
    @Autowired
    private ProveedorRepository proveedorRepository;



}
