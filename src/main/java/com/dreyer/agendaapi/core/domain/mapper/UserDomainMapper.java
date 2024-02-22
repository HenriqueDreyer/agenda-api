package com.dreyer.agendaapi.core.domain.mapper;

import org.mapstruct.Mapper;

import com.dreyer.agendaapi.core.boundary.requestmodel.CreateUserRequestModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.UserResponseModel;
import com.dreyer.agendaapi.core.domain.entities.CreateUser;
import com.dreyer.agendaapi.core.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {
	UserResponseModel userDomainToUserResponseModel(User user);
	CreateUser createUserRequestModelToCreateUserDomain(CreateUserRequestModel user);
}
