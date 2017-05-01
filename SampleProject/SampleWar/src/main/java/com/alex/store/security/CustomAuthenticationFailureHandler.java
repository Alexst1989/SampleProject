package com.alex.store.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alex.store.rest.ResponseBody;
import com.alex.store.utils.JsonParser;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomAuthenticationFailureHandler.class);	
	
	private JsonParser jsonParser = new JsonParser();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		AuthentificationFailedResponseBody body = new AuthentificationFailedResponseBody();
		body.setStatus("ERROR");
		body.setMessage(exception.getMessage());
		LOGGER.info("Buffersize = " + response.getBufferSize());
		try(Writer writer = response.getWriter()) {
			writer.write(jsonParser.toJsonString(body, AuthentificationFailedResponseBody.class));
		}
	}

}

class AuthentificationFailedResponseBody extends ResponseBody {
	
	private String Status;
	
	private String Message;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
	
}
