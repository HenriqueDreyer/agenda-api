package com.dreyer.agendaapi.core.boundary.responsemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponseModel {
	private String message;
}
