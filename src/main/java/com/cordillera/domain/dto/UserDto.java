package com.cordillera.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class UserDto {
	private Long id;
	private String name;
	@NotNull
	private String address;
}
