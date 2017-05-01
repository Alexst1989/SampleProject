package com.alex.store.user;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alex.store.utils.JsonParser;

@Component
@Qualifier("inMemoryUserStorage")
public class InMemoryUserStorage implements UserDao {
	
	private static final Logger LOGGER = LogManager.getLogger(InMemoryUserStorage.class);
	
	private static final String RESOURCE_PATH = "stubs/user-info.json";
	
	private ConcurrentHashMap<String, UserInfo> userMap = new ConcurrentHashMap<>();
	
	private AtomicInteger id = new AtomicInteger(0);
	
	@Autowired
	private JsonParser jsonParser;
	
	@PostConstruct
	public void postConstruct() {
		Map<String, UserInfo> map = null;
		try {
			map = (Map<String, UserInfo>) jsonParser.parseJson(RESOURCE_PATH, String.class, UserInfo.class);
		} catch (IOException e) {
			LOGGER.error("Error while creating InMemoryUserStorage", e);
		}
		for (String key : map.keySet()) {
			map.get(key).setId(Integer.valueOf(key));
		}
		userMap.putAll(map);
	}

	@Override
	public UserInfo getUserById(int id) {
		return userMap.get(String.valueOf(id));
	}

	@Override
	public synchronized void addUser(UserInfo userInfo) {
		userMap.put(String.valueOf(id.getAndIncrement()), userInfo);
	}

	@Override
	public UserInfo getUserByLogin(String login) {
		for (String key : userMap.keySet()) {
			UserInfo ui = userMap.get(key);
			if (ui.getLogin().equals(login)) {
				return ui;
			}
		}
		return null;
	}

}
