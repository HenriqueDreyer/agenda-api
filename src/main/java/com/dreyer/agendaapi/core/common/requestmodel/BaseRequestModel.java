package com.dreyer.agendaapi.core.common.requestmodel;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseRequestModel {
	private Long userId;
}
