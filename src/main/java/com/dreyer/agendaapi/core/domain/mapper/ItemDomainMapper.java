package com.dreyer.agendaapi.core.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dreyer.agendaapi.core.boundary.requestmodel.CreateItemRequestModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.ItemResponseModel;
import com.dreyer.agendaapi.core.domain.entities.CreateItem;
import com.dreyer.agendaapi.core.domain.entities.Item;

@Mapper(componentModel = "spring")
public interface ItemDomainMapper {
	
	@Mapping(target = "userId", source = "requestModel.userId")
	CreateItem requestModelToDomain(CreateItemRequestModel requestModel); 
	ItemResponseModel domainToResponseModel(Item item);
	
}
