package com.dreyer.agendaapi.core.boundaries;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {	
	private Long id;
	private String username;
	private String password;
	private List<Role> roles;
}
