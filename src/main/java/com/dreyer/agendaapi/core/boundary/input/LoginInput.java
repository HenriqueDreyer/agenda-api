package com.dreyer.agendaapi.core.boundary.input;

import com.dreyer.agendaapi.core.boundary.requestmodel.LoginRequestModel;

public interface LoginInput {
	void execute(LoginRequestModel requestModel);
}
