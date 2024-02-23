package com.dreyer.agendaapi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreyer.agendaapi.core.boundary.input.CreateUserInput;
import com.dreyer.agendaapi.web.common.PasswordEncoderUtil;
import com.dreyer.agendaapi.web.dto.CreateUserDTO;
import com.dreyer.agendaapi.web.mapper.UserDTOMapper;

@Service
@Transactional
public class CreateUserService {
	
	private final CreateUserInput input;
	private final UserDTOMapper mapper;

	@Autowired
	public CreateUserService(CreateUserInput input, UserDTOMapper mapper) {
		super();
		this.input = input;
		this.mapper = mapper;
	}
	
	public void execute(CreateUserDTO dto) {
		var encryptPwd = PasswordEncoderUtil.passwordEncoder()
				.encode(dto.getPassword());
		dto.setPassword(encryptPwd);
		
		var requestModel = mapper.dtoToRequestModel(dto);
		input.execute(requestModel);
	}
}
