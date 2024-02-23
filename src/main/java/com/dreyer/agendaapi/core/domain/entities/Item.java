package com.dreyer.agendaapi.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
	private Long id;
	private String name;
	private String email;
	private String phone;
	private User user;
}
