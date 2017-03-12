package com.alex.store.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.alex.store.config.Environment;

public class CustomTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	private Environment env;

	@Autowired
	private JwtTokenCryptService cryptService; 

	public CustomTokenAuthenticationFilter(String defaultFilterProcessesUrl,
			AuthenticationManager authenticationManager) {
		super(defaultFilterProcessesUrl);
		setAuthenticationManager(authenticationManager);
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(defaultFilterProcessesUrl));
		setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
		// setAuthenticationSuccessHandler(new
		// TokenSimpleUrlAuthenticationSuccessHandler());
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String token = null;
		Cookie[] cookieArray = request.getCookies();
		if (cookieArray != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(env.getTokenCookieName())) {
					token = cookie.getValue();
				}
			}
		}
		Authentication userAuthenticationToken = parseToken(token);
		if (userAuthenticationToken == null) {
			throw new AuthenticationServiceException("here we throw some exception or text");
		}
		return userAuthenticationToken;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

	// This method makes some validation depend on your application logic
	private Authentication parseToken(String tokenString) {
		try {
			if (cryptService.verifyToken(tokenString)) {
				
			}
			// Token token = new ObjectMapper().readValue(encryptedToken,
			// Token.class);
			// return authenticationManager.authenticate(
			// new UsernamePasswordAuthenticationToken(token.getUsername(),
			// token.getPassword()));
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
