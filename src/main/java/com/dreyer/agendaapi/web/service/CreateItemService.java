package com.dreyer.agendaapi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreyer.agendaapi.core.boundary.input.CreateItemInput;
import com.dreyer.agendaapi.web.dto.CreateItemDTO;
import com.dreyer.agendaapi.web.mapper.ItemDTOMapper;

@Service
@Transactional
public class CreateItemService {
	private final CreateItemInput createItemInput;
	private final ItemDTOMapper mapper;
	
	@Autowired
	public CreateItemService(CreateItemInput createItemInput, ItemDTOMapper mapper) {
		super();
		this.createItemInput = createItemInput;
		this.mapper = mapper;
	}
	
	public void execute(CreateItemDTO dto) {
		final var mockUserId = 12L;
		this.createItemInput.execute(mapper.toRequestModel(dto, mockUserId));
	}	
}
