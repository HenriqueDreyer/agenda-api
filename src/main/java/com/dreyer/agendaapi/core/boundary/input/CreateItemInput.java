package com.dreyer.agendaapi.core.boundary.input;

import com.dreyer.agendaapi.core.boundary.requestmodel.CreateItemRequestModel;

public interface CreateItemInput {
	void execute(CreateItemRequestModel requestModel);
}
