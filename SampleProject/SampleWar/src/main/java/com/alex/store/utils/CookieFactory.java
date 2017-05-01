package com.alex.store.utils;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Component;

@Component
public class CookieFactory {
	
	private static final String TOKEN_COOKIE_NAME = "STORE_TOKEN";
	
	public Cookie getTokenCookie(String token) {
		Cookie cookie = new Cookie(TOKEN_COOKIE_NAME, token);
		//cookie.setDomain(domain);
		return cookie;
	}

}
