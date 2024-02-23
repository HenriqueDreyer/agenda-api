package com.dreyer.agendaapi.web.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {
	
	public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
