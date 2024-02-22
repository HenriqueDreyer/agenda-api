package com.dreyer.agendaapi.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dreyer.agendaapi.jpa.gatewayimpl")
public class GatewayConfig {

}
