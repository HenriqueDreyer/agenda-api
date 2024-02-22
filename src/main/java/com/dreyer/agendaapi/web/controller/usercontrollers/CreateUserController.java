package com.dreyer.agendaapi.web.controller.usercontrollers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreyer.agendaapi.web.dto.CreateUserDTO;

@RestController
@RequestMapping("/user")
public class CreateUserController {
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody CreateUserDTO user) {
		return ResponseEntity.ok(user);
	}
}
