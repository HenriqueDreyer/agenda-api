package com.dreyer.agendaapi.jpa.gatewayimpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreyer.agendaapi.core.boundaries.CreateUser;
import com.dreyer.agendaapi.core.boundaries.User;
import com.dreyer.agendaapi.core.gateway.UserGateway;
import com.dreyer.agendaapi.jpa.entities.UserEntity;
import com.dreyer.agendaapi.jpa.mappers.UserEntityMapper;
import com.dreyer.agendaapi.jpa.repositories.UserEntityRepository;

@Repository
public class UserGatewayImpl implements UserGateway {
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private UserEntityMapper mapper;
	
	
	@Override
	public User createUser(CreateUser createUser) {		
		UserEntity nUser = mapper.createUserToUserEntity(createUser);
		
		Long id = userEntityRepository.save(nUser).getId();
		nUser.setId(id);
		
		return mapper.userEntityToUser(nUser);
	}

	@Override
	public User findUserByUsernameFetchRoles(String username) {
		UserEntity user = userEntityRepository.findUserByUsernameFetchRoles(username);		
		return !Objects.isNull(user)? mapper.userEntityToUser(user) : null;		
	}
}
