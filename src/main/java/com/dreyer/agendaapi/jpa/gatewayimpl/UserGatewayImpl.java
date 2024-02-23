package com.dreyer.agendaapi.jpa.gatewayimpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.dreyer.agendaapi.core.domain.entities.CreateUser;
import com.dreyer.agendaapi.core.domain.entities.User;
import com.dreyer.agendaapi.core.domain.gateway.UserGateway;
import com.dreyer.agendaapi.jpa.entities.UserEntity;
import com.dreyer.agendaapi.jpa.mapper.UserEntityMapper;
import com.dreyer.agendaapi.jpa.repositories.RoleEntityRepository;
import com.dreyer.agendaapi.jpa.repositories.UserEntityRepository;

@Repository
public class UserGatewayImpl implements UserGateway {
	
	private final UserEntityRepository userEntityRepository;
	private final UserEntityMapper mapper;
	
	@Autowired		
	public UserGatewayImpl(UserEntityRepository userEntityRepository, UserEntityMapper mapper) {
		super();
		this.userEntityRepository = userEntityRepository;		
		this.mapper = mapper;
	}

	@Override
	public User createUser(CreateUser createUser) {		
		UserEntity nUser = mapper.createUserToUserEntity(createUser);
		
		this.userEntityRepository.save(nUser);
		var savedUser = this.userEntityRepository
				.findUserByUsernameFetchRoles(createUser.getUsername());
				
		return mapper.userEntityToUser(savedUser);
	}

	@Override
	public User findUserByUsernameFetchRoles(String username) {
		UserEntity user = userEntityRepository.findUserByUsernameFetchRoles(username);		
		return !Objects.isNull(user)? mapper.userEntityToUser(user) : null;		
	}
}
