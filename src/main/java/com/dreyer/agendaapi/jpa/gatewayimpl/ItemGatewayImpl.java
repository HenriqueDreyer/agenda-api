package com.dreyer.agendaapi.jpa.gatewayimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreyer.agendaapi.core.boundaries.CreateItem;
import com.dreyer.agendaapi.core.boundaries.Item;
import com.dreyer.agendaapi.core.gateway.ItemGateway;
import com.dreyer.agendaapi.jpa.entities.ItemEntity;
import com.dreyer.agendaapi.jpa.mappers.ItemEntityMapper;
import com.dreyer.agendaapi.jpa.repositories.ItemEntityRepository;

@Service
public class ItemGatewayImpl implements ItemGateway {
	
	@Autowired
	private ItemEntityRepository itemEntityRepository;
	
	@Autowired
	private ItemEntityMapper mapper;
	
	@Override
	public Item createItem(CreateItem item) {
		ItemEntity nItem = mapper.createItemToItemEntity(item);
		
		Long id = itemEntityRepository.save(nItem).getId();				
		nItem.setId(id);
		
		return mapper.itemEntityToItem(nItem);
	}
}
