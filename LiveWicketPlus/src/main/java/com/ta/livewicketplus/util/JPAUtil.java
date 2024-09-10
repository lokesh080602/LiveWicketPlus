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

    private static final Logger logger = LoggerFactory.getLogger(JPAUtil.class);
    private static EntityManagerFactory emf;

    // Static block to initialize EntityManagerFactory once
    static {
        loadConfig();
    }

    // Prevent instantiation
    private JPAUtil() {}

    private static void loadConfig() {
        Properties externalProperties = new Properties();
        try (FileInputStream fileInput = new FileInputStream("D:\\LiveWicketPlus\\config\\db.properties")) {
            externalProperties.load(fileInput);
            emf = Persistence.createEntityManagerFactory("LiveWicketPlus", externalProperties);
            logger.info("EntityManagerFactory created successfully with external properties.");
        } catch (IOException e) {
            logger.error("Error loading external properties file: " + e.getMessage(), e);
        } catch (Exception ex) {
            logger.error("Failed to create EntityManagerFactory: " + ex.getMessage(), ex);
        }
    }

    public static EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            loadConfig();  // Re-load if the EntityManagerFactory is not available
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            logger.info("EntityManagerFactory closed.");
        }
    }
}
