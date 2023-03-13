package com.cordillera.domain.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProveedorTest {

    @Test
    void setAndGetIdProveedorTest() {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(1L);
        assertEquals(1L, proveedor.getIdProveedor());
    }
    @Test
    void setAndGetNombreProveedorTest() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Oscar Andres");
        assertEquals("Oscar Andres", proveedor.getNombre());
    }

    @Test
    void setAndGetApellidoProveedorTest() {
        Proveedor proveedor = new Proveedor();
        proveedor.setApellido("Ramos Lopez");
        assertEquals("Ramos Lopez", proveedor.getApellido());
    }


    @Test
    void setAndGetIdentificacionProveedorTest() {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdentificacion(new BigDecimal("94041436"));
        assertEquals(94041436, proveedor.getIdentificacion().intValue());
    }
    @Test
    void setAndGetTelefonoProveedorTest() {
        Proveedor proveedor = new Proveedor();
        proveedor.setTelefono(3128609774L);
        assertEquals(3128609774L, proveedor.getTelefono());
    }
    @Test
    void setAndGetCorreoProveedorTest() {
        Proveedor proveedor = new Proveedor();
        proveedor.setCorreo("oscar1940_1@hotmail.com");
        assertEquals("oscar1940_1@hotmail.com", proveedor.getCorreo());
    }

    @Test
    void constructorAllParamsProveedorTest(){
        Proveedor proveedor = new Proveedor(1L,"Oscar Andres","Ramos Lopez",new BigDecimal("94041436"),3128609774L,"oscar1940_1@hotmail.com");
        assertEquals(1L, proveedor.getIdProveedor());
        assertEquals("Oscar Andres", proveedor.getNombre());
        assertEquals("Ramos Lopez", proveedor.getApellido());
        assertEquals(94041436, proveedor.getIdentificacion().intValue());
        assertEquals(3128609774L, proveedor.getTelefono());
        assertEquals("oscar1940_1@hotmail.com", proveedor.getCorreo());
    }


}