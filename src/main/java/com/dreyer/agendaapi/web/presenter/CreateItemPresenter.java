package com.dreyer.agendaapi.web.presenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.dreyer.agendaapi.core.boundary.output.CreateItemOutput;
import com.dreyer.agendaapi.core.boundary.responsemodel.ErrorResponseModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.ItemResponseModel;
import com.dreyer.agendaapi.web.dto.ItemDTO;
import com.dreyer.agendaapi.web.mapper.ItemDTOMapper;

@Component
public class CreateItemPresenter extends BasePresenter<ItemResponseModel, ItemDTO> implements CreateItemOutput {
	private final ItemDTOMapper mapper;

	@Autowired
	public CreateItemPresenter(ItemDTOMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	protected ResponseEntity<Object> presentOnError(List<ErrorResponseModel> errors) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.buildErrorResponseBody(errors));
	}

	@Override
	protected ItemDTO convert(ItemResponseModel responseModel) {
		return mapper.toDTO(responseModel);
	}
}
