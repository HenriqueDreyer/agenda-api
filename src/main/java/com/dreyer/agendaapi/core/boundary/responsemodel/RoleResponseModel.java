package com.dreyer.agendaapi.core.boundary.responsemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class RoleResponseModel {
	private Long id;
	private String name;
}
