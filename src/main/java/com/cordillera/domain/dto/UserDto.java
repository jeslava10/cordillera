package com.cordillera.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

//data transfer object(dto) - design pattern

@Data
public class UserDto {

	private Long id;

	private String name;
	@NotNull
	private String address;

}
