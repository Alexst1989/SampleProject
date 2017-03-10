package com.alex.store.user.endpoints;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;


@Component
public class CryptoService {
	
	private static final Logger LOGGER = LogManager.getLogger(CryptoService.class);
	
	public String constructToken() {
		try {
		    String token = JWT.create()
		        .withIssuer("auth0")
		        .sign(Algorithm.HMAC256("secret"));
		    return token;
		} catch (JWTCreationException | IllegalArgumentException | UnsupportedEncodingException e){
			LOGGER.error("Error creating JWT");
		}
		return null;
	}
	
	public 
	
}
