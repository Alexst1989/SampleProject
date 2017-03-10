package com.alex.store.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alex.store.config.Environment;
import com.alex.store.rest.RequestBody;

@Component
public class ServletUtils {
	
	@Autowired
	private Environment env;

	private static final Logger LOGGER = LogManager.getLogger(ServletUtils.class);
	
	public  <T extends RequestBody> T parseRequestBody(HttpServletRequest request, Class<T> clazz) {
		try(InputStream is = request.getInputStream()) {
			return JsonParser.parseJson(is, clazz);	
		} catch (IOException e) {
			LOGGER.error("Request does not contains body", e);
			return null;
		}
	}
	
	public void addTokenCookie(HttpServletResponse response, String cookieVal) {
		Cookie cookie = new Cookie(env.getTokenCookieName(), cookieVal);
		cookie.setComment(String.format("Authoriazation cookie for %s", env.getDomainName()));
		cookie.setDomain(env.getDomainName());
		cookie.setMaxAge(60*60); //one hour
		cookie.setPath("/");
		cookie.setSecure(true);
		response.addCookie(cookie);
	}

}

