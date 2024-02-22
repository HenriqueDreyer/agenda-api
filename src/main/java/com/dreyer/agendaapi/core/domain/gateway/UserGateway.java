package com.dreyer.agendaapi.core.domain.gateway;

import com.dreyer.agendaapi.core.domain.entities.CreateUser;
import com.dreyer.agendaapi.core.domain.entities.User;

public interface UserGateway {
	
	User createUser(CreateUser createUser);
	User findUserByUsernameFetchRoles(String username);
}
