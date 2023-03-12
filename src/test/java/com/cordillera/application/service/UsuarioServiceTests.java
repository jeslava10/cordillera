package com.cordillera.application.service;

import com.cordillera.application.mapper.UsuarioMapper;
import com.cordillera.application.repository.jpa.UsuarioRepository;
import com.cordillera.application.resources.MensajesErrores;
import com.cordillera.domain.dto.UsuarioDto;
import com.cordillera.domain.excepcion.UsuarioException;
import com.cordillera.domain.models.Usuario;
import com.cordillera.factories.UsuarioFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.cordillera.factories.UsuarioFactory.getRandomLong;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UsuarioServiceTests {

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    UsuarioMapper usuarioMapper;

    @InjectMocks
    UsuarioService usuarioService;

    private Usuario usuario;

    private UsuarioDto usuarioDto;

    private List<Usuario> userList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        usuario = new UsuarioFactory().newInstance();
        usuarioDto = new UsuarioFactory().newInstanceDTOByUsuario(usuario);
        userList.add(usuario);
    }

    @Test()
    public void when_save_user_it_should_return_user(){
        usuarioDto.setId(null);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        when(usuarioMapper.usuarioDtoToEntity(any(UsuarioDto.class))).thenReturn(usuario);
        when(usuarioMapper.usuarioToDTO(any(Usuario.class))).thenReturn(usuarioDto);
        UsuarioDto usuarioDto1 = usuarioService.saveUsuario(usuarioDto);
        assertThat(usuario.getUsuario()).isSameAs(usuarioDto1.getUsuario());
    }

    @Test
    public void when_update_user_it_should_return_user(){
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        when(usuarioMapper.usuarioDtoToEntity(any(UsuarioDto.class))).thenReturn(usuario);
        when(usuarioMapper.usuarioToDTO(any(Usuario.class))).thenReturn(usuarioDto);
        usuarioDto.setPassWord("admin112");
        UsuarioDto usuarioDto1 = usuarioService.updateUser(usuarioDto);
        assertThat(usuarioDto.getPassWord()).isSameAs(usuarioDto1.getPassWord());
    }

    @Test
    public void when_save_user_name_blank_it_should_return_error(){
        usuarioDto.setId(null);
        usuarioDto.setUsuario("");
        UsuarioException usuarioException = assertThrows(UsuarioException.class,
                () -> usuarioService.saveUsuario(usuarioDto));
        assertEquals(MensajesErrores.NOMBRE_DEL_USUARIO_NULL.getValue(), usuarioException.getMessage());
    }

    @Test
    public void when_update_user_name_blank_it_should_return_error(){
        usuarioDto.setUsuario(" ");
        UsuarioException usuarioException = assertThrows(UsuarioException.class,
                () -> usuarioService.updateUser(usuarioDto));
        assertEquals(MensajesErrores.NOMBRE_DEL_USUARIO_NULL.getValue(), usuarioException.getMessage());
    }

    @Test
    void should_delete_one_user() {
        doNothing().when(usuarioRepository).deleteById(any(Long.class));
        usuarioService.deleteUser(getRandomLong());
        verify(usuarioRepository, times(1)).deleteById(any(Long.class));
        verifyNoMoreInteractions(usuarioRepository);
    }

    @Test
    void should_find_and_return_all_user() {
        when(usuarioRepository.findAll()).thenReturn(userList);
        assertThat(usuarioService.listUser()).hasSize(1);
        verify(usuarioRepository, times(1)).findAll();
        verifyNoMoreInteractions(usuarioRepository);
    }

}
