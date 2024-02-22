package com.dreyer.agendaapi.core.boundary.responsemodel;

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
public class UserResponseModel {
	private Long id;
	private String username;
	private List<RoleResponseModel> roles;
}
