package com.alex.store.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApi extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}
	
}