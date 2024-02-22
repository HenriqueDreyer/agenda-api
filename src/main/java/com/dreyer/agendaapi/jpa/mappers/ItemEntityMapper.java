package com.dreyer.agendaapi.jpa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dreyer.agendaapi.core.domain.entities.CreateItem;
import com.dreyer.agendaapi.core.domain.entities.Item;
import com.dreyer.agendaapi.jpa.entities.ItemEntity;

@Mapper(componentModel = "spring")
public interface ItemEntityMapper {
	
	@Mapping(target = "user.id", source = "item.userId")
	ItemEntity createItemToItemEntity(CreateItem item);
	
	ItemEntity itemToItemEntity(Item item);
	
	Item itemEntityToItem(ItemEntity entity);
}
