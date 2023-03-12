package com.cordillera.application.service;

import com.cordillera.application.mapper.UsuarioMapper;
import com.cordillera.application.repository.jpa.UsuarioRepository;
import com.cordillera.application.resources.MensajesErrores;
import com.cordillera.domain.dto.UsuarioDto;
import com.cordillera.domain.excepcion.UsuarioException;
import com.cordillera.domain.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    
   private final UsuarioMapper usuarioMapper;
   
   private  final UsuarioRepository usuarioRepository;

   @Autowired
    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto saveUsuario(UsuarioDto usuarioDto){
        validateUser(usuarioDto);
        try {
            Usuario usuario =  usuarioMapper.usuarioDtoToEntity(usuarioDto);
            UsuarioDto usuarioReponse =  usuarioMapper.usuarioToDTO(usuarioRepository.save(usuario));
            return usuarioReponse;
        }catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

    public static void validateUser(UsuarioDto usuarioDto) throws UsuarioException {
        if (usuarioDto.getUsuario().isBlank()) {
            throw new UsuarioException(MensajesErrores.NOMBRE_DEL_USUARIO_NULL.getValue());
        }
    }


    public UsuarioDto updateUser(UsuarioDto usuarioDto) throws UsuarioException {
        try {
            validateUser(usuarioDto);
            Usuario usuario =  usuarioMapper.usuarioDtoToEntity(usuarioDto);
            return usuarioMapper.usuarioToDTO(usuarioRepository.save(usuario));
        } catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

    public void deleteUser(Long userId) throws UsuarioException {
        try {
            usuarioRepository.deleteById(userId);
        } catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

    public List<UsuarioDto> listUser() throws UsuarioException {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        try {
            List<UsuarioDto> usuarioDtoList = listaUsuarios.stream().map(usuarioMapper::usuarioToDTO).collect(Collectors.toList());
            return usuarioDtoList;
        }catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

}
