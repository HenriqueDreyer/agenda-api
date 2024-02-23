package com.dreyer.agendaapi.web.mapper;

import org.mapstruct.Mapper;

import com.dreyer.agendaapi.core.boundary.requestmodel.LoginRequestModel;
import com.dreyer.agendaapi.web.dto.LoginDTO;

@Mapper(componentModel = "spring")
public interface LoginDTOMapper {
	LoginRequestModel dtoTORequestModel(LoginDTO dto);
}
