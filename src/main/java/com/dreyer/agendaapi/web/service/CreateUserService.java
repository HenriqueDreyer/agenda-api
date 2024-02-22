package com.dreyer.agendaapi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreyer.agendaapi.core.boundary.input.CreateUserInput;
import com.dreyer.agendaapi.web.dto.CreateUserDTO;

@Service
@Transactional
public class CreateUserService {
	
	private final CreateUserInput input;

	@Autowired
	public CreateUserService(CreateUserInput input) {
		super();
		this.input = input;
	}
	
	public void execute(CreateUserDTO dto) {
		
	}
}
