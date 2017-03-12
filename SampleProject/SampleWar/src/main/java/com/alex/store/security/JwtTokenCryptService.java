package com.alex.store.security;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alex.store.config.Environment;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;


@Component
public class JwtTokenCryptService {
	
	@Autowired
	private Environment env;
	
	private static final Logger LOGGER = LogManager.getLogger(JwtTokenCryptService.class);
	
	private static final String SECRET = "mamamia";
	
	public String constructToken(Credentials cred) {
		try {
		    String token = JWT.create()
		        .withIssuer(env.getProductName())
		        .withClaim("user", cred.getUserName())
		        .sign(Algorithm.HMAC256(SECRET));
		    return token;
		} catch (JWTCreationException | IllegalArgumentException | UnsupportedEncodingException ex){
			LOGGER.error("Error while creating JWT", ex);
		}
		return null;
	}
	
	public boolean verifyToken(String token) {
		try {
			JWTVerifier verificiation = JWT.require(Algorithm.HMAC256(SECRET)).build();
			DecodedJWT decodedJWT = verificiation.verify(token);
			return true;
		} catch (IllegalArgumentException | UnsupportedEncodingException ex) {
			LOGGER.error("Exception while verifying token", ex);
		} 
		return false;
		
	}
	
}
