package com.alex.store.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfigurationImpl implements Configuration {

	
	private String productName;
	
	
	private String version;
	
	
	private String domainName;
	
	
	private String tokenCookieName;

	@Override
	public String getProductName() {
		return productName;
	}
	
	@XmlElement
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@XmlElement
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String getDomainName() {
		return domainName;
	}

	@XmlElement
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Override
	public String getTokenCookieName() {
		return tokenCookieName;
	}
	
	@XmlElement
	public void setTokenCookieName(String tokenCookieName) {
		this.tokenCookieName = tokenCookieName;
	}
	
}
