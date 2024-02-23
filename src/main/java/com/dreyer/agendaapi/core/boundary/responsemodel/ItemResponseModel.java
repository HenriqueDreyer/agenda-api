package com.dreyer.agendaapi.core.boundary.responsemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseModel {
	private Long id;
	private String name;
	private String email;
	private String phone;
}
