package com.alex.store.config;

public interface Configuration {
	
	/**
	 * Returns product name
	 * 
	 * @return String with product name
	 */
	String getProductName();

	/**
	 * Product version
	 * 
	 * @return String with product name
	 */
	String getVersion();

	/**
	 * Domain name that sees cookie. Used for creating cookie
	 * 
	 * @return domain name
	 */
	String getDomainName();
	
	/**
	 * Cookie key to store JWT Token
	 * 
	 * @return cookie string value
	 */
	String getTokenCookieName();
	

}