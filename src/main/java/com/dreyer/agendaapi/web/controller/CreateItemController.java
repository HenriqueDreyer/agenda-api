package com.dreyer.agendaapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreyer.agendaapi.web.dto.CreateItemDTO;
import com.dreyer.agendaapi.web.presenter.CreateItemPresenter;
import com.dreyer.agendaapi.web.service.CreateItemService;

@RestController
@RequestMapping("/item")
public class CreateItemController {
	private final CreateItemPresenter itemPresenter;
	private final CreateItemService createItemService;
	
	@Autowired	
	public CreateItemController(CreateItemPresenter itemPresenter, CreateItemService createItemService) {
		super();
		this.itemPresenter = itemPresenter;
		this.createItemService = createItemService;
	}

	@PreAuthorize("hasRole('ITEM_INSERT')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createItem(@RequestBody CreateItemDTO dto) {
		this.createItemService.execute(dto);
		
		return this.itemPresenter.present();
	}
}
