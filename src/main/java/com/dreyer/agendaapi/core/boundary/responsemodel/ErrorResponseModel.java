package com.dreyer.agendaapi.core.boundary.responsemodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponseModel {
	private String code;
    private List<String> params;
    private String message;
}
