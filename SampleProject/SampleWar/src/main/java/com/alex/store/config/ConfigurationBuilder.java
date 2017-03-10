package com.alex.store.config;

public class ConfigurationBuilder {
	
	private ConfigurationImpl config;
	
	public ConfigurationBuilder() {
		config = new ConfigurationImpl();
	}
	
	public ConfigurationBuilder setProductName(String productName) {
		config.setProductName(productName);
		return this;
	}

	public ConfigurationBuilder setVersion(String version) {
		config.setVersion(version);
		return this;
	}

	public ConfigurationBuilder setDomainName(String domainName) {
		config.setDomainName(domainName);
		return this;
	}
	
	public ConfigurationBuilder setTokenCookieName(String tokenCookieName) {
		config.setTokenCookieName(tokenCookieName);
		return this;
	}
	
	public ConfigurationImpl build() {
		return config;
	}

}
