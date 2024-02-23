package com.dreyer.agendaapi.core.boundary.output;

import java.util.List;

import com.dreyer.agendaapi.core.boundary.responsemodel.ErrorResponseModel;
import com.dreyer.agendaapi.core.boundary.responsemodel.ItemResponseModel;

public interface CreateItemOutput {
	void success(ItemResponseModel responseModel);
    void error(List<ErrorResponseModel> errors);
}
