package com.alex.store.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alex.store.config.ConfigurationBuilder;
import com.alex.store.config.ConfigurationImpl;

@Component
public class XmlSerializer {
	
	private static final Logger LOGGER = LogManager.getLogger(JsonParser.class);
	
	public XmlSerializer() {
		LOGGER.info("YES!!!");
	}

	@SuppressWarnings("unchecked")
	public <T> T deserializeFromResourse(String path, Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller marshaller = context.createUnmarshaller();
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
			return (T) marshaller.unmarshal(is);
		} catch (JAXBException e) {
			LOGGER.error("Error while deserializing from xml", e);
		}
		return null;
	}
	
	public String serializeToXmlString(Object o) {
		try(StringWriter sw = new StringWriter()) {
			JAXBContext context = JAXBContext.newInstance(o.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(o, sw);
			return sw.toString();
		} catch (JAXBException | IOException e) {
			LOGGER.error("Error while deserializing from xml", e);
		}
		return null;
	}
	
	public static void main(String args[]) {
		ConfigurationImpl config = new ConfigurationBuilder()
				.setDomainName("")
				.setProductName("AlexStore")
				.setTokenCookieName("STORE_TOKEN")
				.setVersion("0.0.1").build();
		
		LOGGER.info(new XmlSerializer().serializeToXmlString(config));
	}
	
}
