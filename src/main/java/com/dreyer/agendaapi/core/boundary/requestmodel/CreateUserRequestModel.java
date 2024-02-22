package com.dreyer.agendaapi.core.boundary.requestmodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel {
	private String username;
	private String password;
	private List<RoleRequestModel> roles;
}
