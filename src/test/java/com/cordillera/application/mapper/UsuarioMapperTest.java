package com.cordillera.application.mapper;

import com.cordillera.domain.dto.UsuarioDto;
import com.cordillera.domain.models.Usuario;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class UsuarioMapperTest {

    private Usuario usuario;

    private UsuarioDto usuarioDto;

    @InjectMocks
    UsuarioMapper usuarioMapper;

    @Test
    public void testEntityToDto() {
//        usuario = new UsuarioFactory().newInstance();
//        UsuarioDto usuarioDto = usuarioMapper.usuarioToDTO( usuario );
//        assertThat( usuario.getId() ).isEqualTo( usuarioDto.getId() );
//        assertThat( usuario.getUsuario() ).isEqualTo( usuarioDto.getUsuario());
//        assertThat( usuario.getPassWord() ).isEqualTo( usuarioDto.getPassWord());
//        assertThat( usuario.getIdRol() ).isEqualTo( usuarioDto.getIdRol());
    }

}
