package com.alex.store.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonParser {
	
	private static final Logger LOGGER = LogManager.getLogger(JsonParser.class);

	public static <T> T parseJson(InputStream is, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		return om.readValue(is, clazz);
	}
	
	public static <T> String toJsonString(Object o, Class<T> clazz) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		ObjectWriter writer = om.writerFor(clazz);
		return writer.writeValueAsString(o);
	}
	
}
