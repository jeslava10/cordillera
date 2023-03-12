package com.cordillera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class UsuarioDto {

	private Long id;

	private String usuario;

	private String passWord;

	private Long idRol;

}
