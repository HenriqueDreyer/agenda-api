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
import com.dreyer.agendaapi.core.domain.gateway.UserGateway;
import com.dreyer.agendaapi.core.domain.mapper.UserDomainMapper;

@Component
public class CreateUserUsecase implements CreateUserInput {
	
	@Autowired private final CreateUserOutput output;
	@Autowired private final UserGateway gateway;
	@Autowired private final UserDomainMapper mapper;
		
	public CreateUserUsecase(CreateUserOutput output, UserGateway gateway, UserDomainMapper mapper) {
		super();
		this.output = output;
		this.gateway = gateway;
		this.mapper = mapper;
	}

	@Override
	public void execute(CreateUserRequestModel requestModel) {
		var errors = new ArrayList<ErrorResponseModel>();
		
		if(isNullOrBlank(requestModel.getUsername())) {
			errors.add(ErrorResponseModel.builder()
					.message("Username is required.")
					.build());
		}
		
		if(isNullOrBlank(requestModel.getPassword())) {
			errors.add(ErrorResponseModel.builder()
					.message("Password is required.")
					.build());
		}
		
		if(isNullOrBlank(requestModel.getUsername())) {
			errors.add(ErrorResponseModel.builder()
					.message("Username is required.")
					.build());
		}
		
		if(isNullOrBlank(requestModel.getRoles())) {
			errors.add(ErrorResponseModel.builder()
					.message("User Roles is required.")
					.build());
		}
		
		requestModel.getRoles().forEach(role -> {
			if(!isValidRole(role)) {
				errors.add(ErrorResponseModel.builder()
						.message(String.format("Role ID: %d invalid.", role.getId()))
						.build());
			}
		});
		
		if(!errors.isEmpty())
			this.output.error(errors);
		
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
	
	private boolean isValidRole(RoleRequestModel role) {
		return false;
	}
}
