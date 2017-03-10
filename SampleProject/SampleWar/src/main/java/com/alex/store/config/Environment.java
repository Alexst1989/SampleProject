package com.alex.store.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alex.store.utils.XmlSerializer;

@Component
public class Environment implements Configuration {
	
	@Autowired
	private XmlSerializer serializer;
	
	private Configuration config;

	@PostConstruct
	public void postConstruct() {
		Configuration configFromFile = serializer.deserializeFromResourse("envConfig/envConfig.xml", ConfigurationImpl.class);
		this.config = configFromFile;
	}
	
	public String getVersion() {
		return config.getVersion();
	}

	@Override
	public String getProductName() {
		return config.getProductName();
	}

	@Override
	public String getDomainName() {
		return config.getDomainName();
	}

	@Override
	public String getTokenCookieName() {
		return config.getTokenCookieName();
	}
	
	
	
	
	
}
