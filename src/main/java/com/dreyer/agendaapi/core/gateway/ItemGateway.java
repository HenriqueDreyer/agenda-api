package com.dreyer.agendaapi.core.gateway;

import com.dreyer.agendaapi.core.boundaries.CreateItem;
import com.dreyer.agendaapi.core.boundaries.Item;

public interface ItemGateway {
	Item createItem(CreateItem item);
}
