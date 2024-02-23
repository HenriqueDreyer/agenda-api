package com.dreyer.agendaapi.web.mapper;

import org.mapstruct.Mapper;

import com.dreyer.agendaapi.core.boundary.requestmodel.CreateUserRequestModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.UserResponseModel;
import com.dreyer.agendaapi.web.dto.CreateUserDTO;
import com.dreyer.agendaapi.web.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
	UserDTO responseModelToDTO(UserResponseModel responseModel);
	CreateUserRequestModel dtoToRequestModel(CreateUserDTO dto);
}
