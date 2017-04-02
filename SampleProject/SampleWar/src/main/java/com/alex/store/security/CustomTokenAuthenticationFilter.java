package com.alex.store.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.alex.store.config.Environment;
import com.alex.store.user.UserTokenDto;

public class CustomTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomTokenAuthenticationFilter.class);	

	@Autowired
	private Environment env;

	@Autowired
	private JwtTokenCryptService cryptService;
	
	@Autowired
	private UserInfoConverter userInfoConverter;

	public CustomTokenAuthenticationFilter(String defaultFilterProcessesUrl,
			AuthenticationManager authenticationManager) {
		super(defaultFilterProcessesUrl);
		setAuthenticationManager(authenticationManager);
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(defaultFilterProcessesUrl));
		this.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
		this.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String token = getJwtTokenFromCookie(request);
		UserTokenDto dto = cryptService.verifyAndGetUserDetails(token);
		Authentication userAuthenticationToken = new StoreAuthenticationToken(userInfoConverter.getUserDetails(dto));
		return this.getAuthenticationManager().authenticate(userAuthenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
	
	
	private String getJwtTokenFromCookie(HttpServletRequest request) {
		Cookie[] cookieArray = request.getCookies();
		if (cookieArray != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(env.getTokenCookieName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

}
