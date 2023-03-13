package com.cordillera.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    @Test
    void setAndGetIdMesaTest() {
        Mesa mesa = new Mesa();
        mesa.setIdMesa(1L);
        assertEquals(1L, mesa.getIdMesa());
    }
    @Test
    void setAndGetNumeroMesaTest() {
        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(14);
        assertEquals(14, mesa.getNumeroMesa());
    }
    @Test
    void constructorAllParamsMesaTest(){
        Mesa mesa = new Mesa(1L,14);
        assertEquals(1L, mesa.getIdMesa());
        assertEquals(14, mesa.getNumeroMesa());
    }


}