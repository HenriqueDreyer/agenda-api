package com.dreyer.agendaapi.jpa.gatewayimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreyer.agendaapi.core.domain.entities.CreateItem;
import com.dreyer.agendaapi.core.domain.entities.Item;
import com.dreyer.agendaapi.core.domain.gateway.ItemGateway;
import com.dreyer.agendaapi.jpa.entities.ItemEntity;
import com.dreyer.agendaapi.jpa.mapper.ItemEntityMapper;
import com.dreyer.agendaapi.jpa.repositories.ItemEntityRepository;

@Service
public class ItemGatewayImpl implements ItemGateway {
	
	@Autowired
	private ItemEntityRepository itemEntityRepository;
	
	@Autowired
	private ItemEntityMapper mapper;
	
	@Override
	public Item createItem(CreateItem item) {
		ItemEntity nItem = mapper.toItemEntity(item);
		
		var sItem = itemEntityRepository.save(nItem);
		
		return mapper.toItem(sItem);
	}

	@Override
	public List<Item> findItensByUser(Long userId) {
		final var itemEntities = this.itemEntityRepository.findByUserId(userId);
		
		if(itemEntities.isEmpty()) {
			return null;
		}
		
		return itemEntities.stream()
				.map(entity -> mapper.toItem(entity))
				.collect(Collectors.toUnmodifiableList());
	}
}
