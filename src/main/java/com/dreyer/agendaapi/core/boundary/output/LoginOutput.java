package com.dreyer.agendaapi.core.boundary.output;

import java.util.List;

import com.dreyer.agendaapi.core.boundary.responsemodel.ErrorResponseModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.UserResponseModel;

public interface LoginOutput {
	void success(UserResponseModel responseModel);
    void error(List<ErrorResponseModel> errors);
}
