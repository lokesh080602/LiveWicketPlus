package com.ta.livewicketplus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JPAUtil {
	private JPAUtil(){}
	private static final Logger logger = LoggerFactory.getLogger(JPAUtil.class);
	private static EntityManagerFactory emf;

	protected static Properties externalProperties = new Properties();
	
	public static void loadConfig(){
		
		try {
			String externalFilePath = "D:\\LiveWicketPlus\\config\\db.properties";
			FileInputStream fileInput= new FileInputStream(externalFilePath);
			externalProperties.load(fileInput);
			emf = Persistence.createEntityManagerFactory("LiveWicketPlus", externalProperties);
			logger.info("EntityManagerFactory created successfully with external properties.");
			fileInput.close();
		} catch (IOException e) {
			logger.error("Error loading external properties file: " + e.getMessage(), e);
		} catch (Exception ex) {
			logger.error("Failed to create EntityManagerFactory: " + ex.getMessage(), ex);
		}
		
	}

	public static EntityManager getEntityManager(){
		loadConfig();
		return emf.createEntityManager();
	}

	public static void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
