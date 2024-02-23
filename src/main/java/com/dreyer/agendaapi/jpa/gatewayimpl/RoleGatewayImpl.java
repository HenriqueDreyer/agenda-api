package com.dreyer.agendaapi.jpa.gatewayimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreyer.agendaapi.core.domain.entities.Role;
import com.dreyer.agendaapi.core.domain.gateway.RoleGateway;
import com.dreyer.agendaapi.jpa.repositories.RoleEntityRepository;

@Service
public class RoleGatewayImpl implements RoleGateway {
	private final RoleEntityRepository roleEntityRepository;
	
	@Autowired
	public RoleGatewayImpl(RoleEntityRepository roleEntityRepository) {
		super();
		this.roleEntityRepository = roleEntityRepository;
	}

	@Override
	public Role findRoleById(Long id) {
		var role = roleEntityRepository.findById(id).orElse(null);
		
		if(role == null) {
			return null;
		}
		
		return Role.builder()
				.id(role.getId())
				.name(role.getName())
				.build();
	}

}
