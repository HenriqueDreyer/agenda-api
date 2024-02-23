package com.dreyer.agendaapi.core.boundary.requestmodel;

import com.dreyer.agendaapi.core.common.requestmodel.BaseRequestModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class CreateItemRequestModel extends BaseRequestModel {
	private String name;
	private String email;
	private String phone;
}
