package com.cordillera.application.service;

import com.cordillera.application.mapper.UsuarioMapper;
import com.cordillera.application.repository.jpa.UsuarioRepository;
import com.cordillera.application.resources.MensajesErrores;
import com.cordillera.domain.dto.UsuarioDto;
import com.cordillera.domain.excepcion.UsuarioException;
import com.cordillera.domain.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            return usuarioMapper.usuarioToDTO(usuarioRepository.save(usuario));
        }catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

    private static void validateUser(UsuarioDto usuarioDto) throws UsuarioException {
        if (usuarioDto.getUsuario().isBlank() || usuarioDto.getUsuario().isEmpty()) {
            throw new UsuarioException(MensajesErrores.NOMBRE_DEL_USUARIO_NULL.getValue());
        }
    }


    public UsuarioDto updateUser(UsuarioDto usuarioDto) throws UsuarioException {
        try {
            Usuario usuario =  usuarioMapper.usuarioDtoToEntity(usuarioDto);
            return usuarioMapper.usuarioToDTO(usuarioRepository.save(usuario));
        } catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

    public void deleteUser(Long UserId) throws UsuarioException {
        if (UserId <= 0){
            StringBuilder sb = new StringBuilder();
            throw new UsuarioException(sb.toString());
        } else if(!UsuarioRepository.findById(UserId).isPresent()){
            throw new UsuarioException(MensajesErrores.User_NO_EXISTE.getValue());
        }

        try {
            UsuarioRepository.deleteById(UserId);
        } catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

    //Metodo para listar un User
    public List<UsuarioDto> listUser() throws UsuarioException {
        List<Usuario> listaUsuarios = UsuarioRepository.findAll();

        if(listaUsuarios.isEmpty()){
            throw new UsuarioException(MensajesErrores.UserS_LISTA_VACIA.getValue());
        }

        List<UsuarioDto> UsersDTO = new ArrayList<>();
        try {
            for(Usuario lUsuario : listaUsuarios){
                UsersDTO.add(UsuarioMapper.UserModelToUserDTO(lUsuario));
            }
            return UsersDTO;
        }catch (Exception e){
            throw new UsuarioException(e.getMessage());
        }
    }

}
