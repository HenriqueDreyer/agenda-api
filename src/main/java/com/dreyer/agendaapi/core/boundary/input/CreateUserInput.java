package com.dreyer.agendaapi.core.boundary.input;

import com.dreyer.agendaapi.core.boundary.requestmodel.CreateUserRequestModel;

public interface CreateUserInput {
	void execute(CreateUserRequestModel requestModel);
}
