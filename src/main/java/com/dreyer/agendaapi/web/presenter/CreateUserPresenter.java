package com.dreyer.agendaapi.web.presenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.dreyer.agendaapi.core.boundary.output.CreateUserOutput;
import com.dreyer.agendaapi.core.boundary.responsemodel.ErrorResponseModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.UserResponseModel;
import com.dreyer.agendaapi.web.dto.UserDTO;
import com.dreyer.agendaapi.web.mapper.UserDTOMapper;

@Component
public class CreateUserPresenter extends BasePresenter<UserResponseModel, UserDTO> implements CreateUserOutput {

	@Autowired private final UserDTOMapper mapper;
	
	public CreateUserPresenter(UserDTOMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	protected ResponseEntity<Object> presentOnError(List<ErrorResponseModel> errors) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.buildErrorResponseBody(errors));
	}

	@Override
	protected UserDTO convert(UserResponseModel responseModel) {	
		return mapper.responseModelToDTO(responseModel);
	}

}
