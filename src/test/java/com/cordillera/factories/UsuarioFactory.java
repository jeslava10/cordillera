package com.cordillera.factories;

import com.cordillera.domain.dto.UsuarioDto;
import com.cordillera.domain.models.Usuario;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

public class UsuarioFactory {

    private static final DataFactory dataFactory = new DataFactory();

    private Long id;

    private final String usuario;

    private final String passWord;

    private final Long idRol;


    public UsuarioFactory() {
        this.id = (long) dataFactory.getNumberBetween(1, 10);
        this.usuario = dataFactory.getName();
        this.passWord = dataFactory.getRandomText(8);
        this.idRol = (long) dataFactory.getNumberBetween(0, 1);
    }

    public Usuario newInstance() {
        return new Usuario(this.id,this.usuario,this.passWord,this.idRol);
    }

    public UsuarioDto newInstanceDTO() {
        return new UsuarioDto(this.id,this.usuario,this.passWord,this.idRol);
    }

    public UsuarioDto newInstanceDTOByUsuario(Usuario usuario) {
        return new UsuarioDto(usuario.getId(),usuario.getUsuario(),usuario.getPassWord(),usuario.getIdRol());
    }

    public static Long getRandomLong() {
        return (long) new Random().ints(1, 10).findFirst().getAsInt();
    }

}
