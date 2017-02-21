package com.alex.store.rest.security.token;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TokenServlet extends HttpServlet {

	private static final Logger LOGGER = LogManager.getLogger(TokenServlet.class);

	private static final long serialVersionUID = -5586474035085394570L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Credentials cred = null;
		try (InputStream is = req.getInputStream()) {
			ObjectMapper om = new ObjectMapper();
			cred = om.readValue(is, Credentials.class);
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		if (cred != null) {
			LOGGER.info("Hello!");
			LOGGER.info("Login = " + cred.getLogin());
			LOGGER.info("Password = " + cred.getPassword());
		}
	}
}
