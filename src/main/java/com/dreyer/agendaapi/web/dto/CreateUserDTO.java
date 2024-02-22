package com.dreyer.agendaapi.web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CreateUserDTO {
	private String username;
	private String password;
	private List<RoleDTO> roles;
}
