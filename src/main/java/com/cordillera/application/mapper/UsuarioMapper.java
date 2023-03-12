package com.cordillera.application.mapper;


import com.cordillera.domain.dto.UsuarioDto;
import com.cordillera.domain.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

  Usuario usuarioDtoToEntity(UsuarioDto usuarioDto);

  UsuarioDto usuarioToDTO(Usuario usuario);


}
