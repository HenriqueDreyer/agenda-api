package com.dreyer.agendaapi.core.usecase;

import java.util.ArrayList;
import java.util.Objects;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.dreyer.agendaapi.core.boundary.input.CreateItemInput;
import com.dreyer.agendaapi.core.boundary.output.CreateItemOutput;
import com.dreyer.agendaapi.core.boundary.requestmodel.CreateItemRequestModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.ErrorResponseModel;
import com.dreyer.agendaapi.core.domain.gateway.ItemGateway;
import com.dreyer.agendaapi.core.domain.mapper.ItemDomainMapper;

@Component
public class CreateItemUsecase implements CreateItemInput {
	private final CreateItemOutput createItemOutput;
	private final ItemGateway itemGateway;
	private final ItemDomainMapper mapper;
	
	@Autowired
	public CreateItemUsecase(CreateItemOutput createItemOutput, ItemGateway itemGateway, ItemDomainMapper mapper) {
		super();
		this.createItemOutput = createItemOutput;
		this.itemGateway = itemGateway;
		this.mapper = mapper;
	}

	@Override
	public void execute(CreateItemRequestModel requestModel) {
		var errors = new ArrayList<ErrorResponseModel>();
		
		if(Objects.isNull(requestModel.getUserId())) {
			errors.add(ErrorResponseModel.builder()
					.code("USER01")
					.message("User ID nullable")
					.build());
		}
		
		if(!StringUtils.hasText(requestModel.getName())) {
			errors.add(ErrorResponseModel.builder()
					.code("IRR01")
					.message("Name is required")
					.build());
		}
		
		if(!StringUtils.hasText(requestModel.getPhone())) {
			errors.add(ErrorResponseModel.builder()
					.code("IRR02")
					.message("Phone is required")
					.build());
		}
		
		if(StringUtils.hasText(requestModel.getEmail()) &&
				!EmailValidator.getInstance().isValid(requestModel.getEmail())) {
			errors.add(ErrorResponseModel.builder()
					.code("IRR03")
					.message("Email is invalid.")
					.build());
		}
				
		if(!errors.isEmpty()) {
			this.createItemOutput.error(errors);
			return;
		}
		
		final var item = this.itemGateway.createItem(
				this.mapper.requestModelToDomain(requestModel));
		
		this.createItemOutput.success(
				this.mapper.domainToResponseModel(item));
		return;
	}
	
}
