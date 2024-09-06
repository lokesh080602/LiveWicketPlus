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

	static {
		try {
			Properties externalProperties = new Properties();
			String externalFilePath = "C:/Users/lokesh.v/LiveWicketPlus/config/db.properties";
			externalProperties.load(new FileInputStream(externalFilePath));

			emf = Persistence.createEntityManagerFactory("LiveWicketPlus", externalProperties);
			logger.info("EntityManagerFactory created successfully with external properties.");
		} catch (IOException e) {
			logger.error("Error loading external properties file: " + e.getMessage(), e);
		} catch (Exception ex) {
			logger.error("Failed to create EntityManagerFactory: " + ex.getMessage(), ex);
		}
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
