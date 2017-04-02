package com.alex.store.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

/**
 * 
 * 
 * 
 * @author alexp
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOGGER = LogManager.getLogger(CustomAuthenticationProvider.class);

	private UserDetailsChecker userDetailsChecker;

	// private StoreUserDetailsService storeUserDetailsService;

	private StoreAuthenticationUserDetailsService authDetailsService;

	public CustomAuthenticationProvider(UserDetailsChecker userDetailsChecker,
			StoreAuthenticationUserDetailsService authDetailsService) {
		this.userDetailsChecker = userDetailsChecker;
		// this.storeUserDetailsService = storeUserDetailsService;
		this.authDetailsService = authDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			LOGGER.debug(
					String.format("CustomAuthenticationProvider does not supports type %s", authentication.getClass()));
			return null;
		}

		UserDetails ud = authDetailsService.loadUserDetails((StoreAuthenticationToken) authentication);

		userDetailsChecker.check(ud);

		StoreAuthenticationToken result = new StoreAuthenticationToken(ud, ud.getAuthorities());
		result.setDetails(authentication.getDetails());
		result.setAuthenticated(true);

		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return StoreAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
