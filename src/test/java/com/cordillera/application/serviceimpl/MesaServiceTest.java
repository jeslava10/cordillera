package com.cordillera.application.serviceimpl;

import com.cordillera.application.repository.jpa.MesaRepository;
import com.cordillera.domain.dto.MesaPostDto;
import com.cordillera.domain.models.Mesa;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.when;

class MesaServiceTest {
    @Mock
    MesaRepository mesaRepository;

    @InjectMocks
    MesaServiceImpl mesaService;

    @Test
    void saveMesaTest() {

    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }
}