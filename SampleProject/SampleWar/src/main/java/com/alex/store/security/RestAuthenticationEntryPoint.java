package com.alex.store.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private static final Logger LOGGER = LogManager.getLogger(RestAuthenticationEntryPoint .class);	
	
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException ) throws IOException, ServletException {
		LOGGER.info("Buffersize = " + response.getBufferSize());
		LOGGER.error(authException.getMessage(), authException);
        response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
    }

}