package com.dreyer.agendaapi.core.domain.gateway;

import com.dreyer.agendaapi.core.domain.entities.Role;

public interface RoleGateway {
	Role findRoleById(Long id);
}
