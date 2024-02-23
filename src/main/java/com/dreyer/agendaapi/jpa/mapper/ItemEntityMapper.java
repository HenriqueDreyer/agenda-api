package com.dreyer.agendaapi.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dreyer.agendaapi.core.domain.entities.CreateItem;
import com.dreyer.agendaapi.core.domain.entities.Item;
import com.dreyer.agendaapi.jpa.entities.ItemEntity;

@Mapper(componentModel = "spring")
public interface ItemEntityMapper {
	
	@Mapping(target = "user.id", source = "item.userId")
	ItemEntity toItemEntity(CreateItem item);
	
	ItemEntity toItemEntity(Item item);
	
	Item toItem(ItemEntity entity);
}
