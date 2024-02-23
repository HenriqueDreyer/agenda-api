package com.dreyer.agendaapi.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dreyer.agendaapi.core.boundary.requestmodel.CreateItemRequestModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.ItemResponseModel;
import com.dreyer.agendaapi.web.dto.CreateItemDTO;
import com.dreyer.agendaapi.web.dto.ItemDTO;

@Mapper(componentModel = "spring")
public interface ItemDTOMapper {
	ItemDTO toDTO(ItemResponseModel responseModel);		
	
	@Mapping(target = "userId", source = "userId")
	CreateItemRequestModel toRequestModel(CreateItemDTO dto, Long userId);
}
