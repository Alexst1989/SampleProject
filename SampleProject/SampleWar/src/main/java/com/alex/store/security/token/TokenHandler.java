package com.alex.store.security.token;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.alex.store.security.Credentials;
import com.alex.store.security.JwtTokenCryptService;
import com.alex.store.utils.ServletUtils;

@Component("TokenServlet")
public class TokenHandler implements HttpRequestHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(TokenHandler.class);

	@Autowired
	private ServletUtils utils;
	
	@Autowired
	private JwtTokenCryptService cryptoService;

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Credentials cred = utils.parseRequestBody(req, Credentials.class);
		utils.addTokenCookie(resp, cryptoService.constructToken(cred));
		if (cred != null) {
			LOGGER.info("Hello!");
			LOGGER.info("Login = " + cred.getUserName());
			LOGGER.info("Password = " + cred.getPassword());
		}
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
