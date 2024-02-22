package com.dreyer.agendaapi.core.gateway;

import com.dreyer.agendaapi.core.boundaries.CreateUser;
import com.dreyer.agendaapi.core.boundaries.User;

public interface UserGateway {
	
	User createUser(CreateUser createUser);
	User findUserByUsernameFetchRoles(String username);
}
