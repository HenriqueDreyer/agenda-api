package com.dreyer.agendaapi.jpa.mappers;

import org.mapstruct.Mapper;

import com.dreyer.agendaapi.core.boundaries.CreateUser;
import com.dreyer.agendaapi.core.boundaries.User;
import com.dreyer.agendaapi.jpa.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
	UserEntity userToUserEntity(User user);
	User userEntityToUser(UserEntity entity);
	UserEntity createUserToUserEntity(CreateUser user);
}
