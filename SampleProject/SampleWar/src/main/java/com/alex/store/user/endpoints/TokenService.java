package com.alex.store.user.endpoints;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;


@Path("/token")
public class TokenService {
	
	private static final Logger LOGGER = LogManager.getLogger(TokenService.class);
	
	public String constructToken() {
		try {
		    String token = JWT.create()
		        .withIssuer("auth0")
		        .sign(Algorithm.HMAC256("secret"));
		    return token;
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
