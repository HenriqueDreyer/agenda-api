package com.dreyer.agendaapi.core.domain.gateway;

import java.util.List;

import com.dreyer.agendaapi.core.domain.entities.CreateItem;
import com.dreyer.agendaapi.core.domain.entities.Item;

public interface ItemGateway {
	Item createItem(CreateItem item);
	List<Item> findItensByUser(Long userId);
}
