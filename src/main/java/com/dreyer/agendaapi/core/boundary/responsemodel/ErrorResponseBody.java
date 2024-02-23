package com.dreyer.agendaapi.core.boundary.responsemodel;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ErrorResponseBody {
    List<String> errors;
}
