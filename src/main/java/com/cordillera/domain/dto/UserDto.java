package com.cordillera.domain.dto;

import lombok.Data;

//data transfer object(dto) - design pattern
@Data
public class UserDto {

	private Long id;

	private String name;

	private String address;

}
