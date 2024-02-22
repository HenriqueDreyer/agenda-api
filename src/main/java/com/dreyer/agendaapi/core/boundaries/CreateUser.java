package com.dreyer.agendaapi.core.boundaries;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUser {
	private String username;
	private String password;
	private List<Role> roles;
}
