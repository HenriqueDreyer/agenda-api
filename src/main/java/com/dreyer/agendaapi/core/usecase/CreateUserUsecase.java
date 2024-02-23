package com.dreyer.agendaapi.core.usecase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreyer.agendaapi.core.boundary.input.CreateUserInput;
import com.dreyer.agendaapi.core.boundary.output.CreateUserOutput;
import com.dreyer.agendaapi.core.boundary.requestmodel.CreateUserRequestModel;
import com.dreyer.agendaapi.core.boundary.requestmodel.RoleRequestModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.ErrorResponseModel;
import com.dreyer.agendaapi.core.domain.gateway.RoleGateway;
import com.dreyer.agendaapi.core.domain.gateway.UserGateway;
import com.dreyer.agendaapi.core.domain.mapper.UserDomainMapper;

@Component
public class CreateUserUsecase implements CreateUserInput {
	
	@Autowired private final CreateUserOutput output;
	@Autowired private final UserGateway gateway;
	@Autowired private final RoleGateway roleGateway;
	@Autowired private final UserDomainMapper mapper;
		
	public CreateUserUsecase(CreateUserOutput output, UserGateway gateway, UserDomainMapper mapper,
			RoleGateway roleGateway) {
		super();
		this.output = output;
		this.gateway = gateway;
		this.roleGateway = roleGateway;
		this.mapper = mapper;
	}

	@Override
	public void execute(CreateUserRequestModel requestModel) {
		var errors = new ArrayList<ErrorResponseModel>();
		
		if(isNullOrBlank(requestModel.getUsername())) {
			errors.add(ErrorResponseModel.builder()
					.code("ERR01")
					.message("Username is required.")
					.build());
		}
		
		if(isNullOrBlank(requestModel.getPassword())) {
			errors.add(ErrorResponseModel.builder()
					.code("ERR02")
					.message("Password is required.")
					.build());
		}
		
		if(isNullOrBlank(requestModel.getRoles())) {
			errors.add(ErrorResponseModel.builder()
					.code("ERR03")
					.message("User Roles is required.")
					.build());
		}
		
		requestModel.getRoles().forEach(role -> {
			if(!isValidRole(role)) {
				errors.add(ErrorResponseModel.builder()
						.code("ERR04")
						.message(String.format("Role ID: %d invalid.", role.getId()))
						.build());
			}
		});
		
		final var existUser = this.gateway.findUserByUsernameFetchRoles(requestModel.getUsername());
		if(!Objects.isNull(existUser)) {
			errors.add(ErrorResponseModel.builder()
					.code("ERR05")
					.message(String.format("Username %s already exist.", requestModel.getUsername()))
					.build());
		}
		
		if(!errors.isEmpty()) {
			this.output.error(errors);
			return;
		}		
					
		var createUser = mapper.createUserRequestModelToCreateUserDomain(requestModel); 
		var user = this.gateway.createUser(createUser);
		
		var response = mapper.userDomainToUserResponseModel(user);
		this.output.success(response);
		
	}
	
	private boolean isNullOrBlank(String value) {
		return Objects.isNull(value) || value.isEmpty() || value.isBlank() || value.trim().isEmpty();
 	}
	
	private boolean isNullOrBlank(Collection<?> value) {
		return Objects.isNull(value);
 	}
	
	private boolean isValidRole(RoleRequestModel request) {
		var role = roleGateway.findRoleById(request.getId());		
		return !Objects.isNull(role);
	}
}
