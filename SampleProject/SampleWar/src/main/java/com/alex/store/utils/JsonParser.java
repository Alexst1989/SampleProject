package com.alex.store.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alex.store.user.UserInfo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.MapType;

@Component
public class JsonParser {
	
	private static final Logger LOGGER = LogManager.getLogger(JsonParser.class);

	public <T> T parseJson(InputStream is, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		return om.readValue(is, clazz);
	}
	
	public <K, V> Map<K, V> parseJson(InputStream is, Class<K> keyClazz, Class<V> valueClazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		final MapType type = om.getTypeFactory().constructMapType(
			    HashMap.class, keyClazz, valueClazz);
		return om.readValue(is, type);
	}
	
	public <K, V> Map<K, V> parseJson(String resourcePath, Class<K> keyClazz, Class<V> valueClazz) throws JsonParseException, JsonMappingException, IOException {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath);

		ObjectMapper om = new ObjectMapper();
		final MapType type = om.getTypeFactory().constructMapType(
			    HashMap.class, keyClazz, valueClazz);
		return om.readValue(is, type);
	}
	
	
	
	public <T> T parseJson(String resoursePath, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		InputStream is = JsonParser.class.getClassLoader().getResourceAsStream(resoursePath);
		return parseJson(is, clazz);
		
	}
	
	//TODO get static resource and get instance resource class
	
	public <T> String toJsonString(Object o, Class<T> clazz) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		ObjectWriter writer = om.writerFor(clazz);
		return writer.writeValueAsString(o);
	}
	
	public static void main(String args[]) {
		Map<String, UserInfo> map = new ConcurrentHashMap<>();
		UserInfo ui1 = new UserInfo();
		ui1.setAge("18");
		//ui1.setName("Alex");
		UserInfo ui2 = new UserInfo();
		ui2.setAge("22");
		//ui2.setName("Vova");
		map.put("user1", ui1);
		map.put("user2", ui2);
		JsonParser parser = new JsonParser();
		try {
			System.out.print(parser.toJsonString(map, Map.class));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
