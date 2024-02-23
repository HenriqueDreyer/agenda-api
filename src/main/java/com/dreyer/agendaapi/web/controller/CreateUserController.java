package com.dreyer.agendaapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreyer.agendaapi.web.dto.CreateUserDTO;
import com.dreyer.agendaapi.web.presenter.CreateUserPresenter;
import com.dreyer.agendaapi.web.service.CreateUserService;

@RestController
@RequestMapping("/user")
public class CreateUserController {
	private final CreateUserService createUserService;
	private final CreateUserPresenter createUserPresenter;
	
	@Autowired	
	public CreateUserController(CreateUserService createUserService, CreateUserPresenter createUserPresenter) {
		super();
		this.createUserService = createUserService;
		this.createUserPresenter = createUserPresenter;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody CreateUserDTO user) {
		this.createUserService.execute(user);
		return this.createUserPresenter.present();
	}
}
