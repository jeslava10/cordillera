package com.cordillera.domain.dto;

import lombok.Data;

@Data
public class UsuarioDto {

	private Long id;

	private String usuario;

	private String passWord;

	private Long idRol;

}
