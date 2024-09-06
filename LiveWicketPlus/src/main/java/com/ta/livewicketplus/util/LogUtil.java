package com.ta.livewicketplus.util;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.ta.livewicketplus.controller.LoginServlet;
import com.ta.livewicketplus.controller.LogoutServlet;
import com.ta.livewicketplus.controller.MatchServlet;
import com.ta.livewicketplus.controller.PlayerDetailsServlet;
import com.ta.livewicketplus.controller.UserServlet;

public class LogUtil {

	public static void getLog(){
		System.setProperty("log4j.configurationFile", "D:\\LiveWicketPlus\\config\\log4j2.xml");
		Configurator.initialize(null, System.getProperty("log4j.configurationFile"));
		
//		File logConfigFile = new File("C:\\Users\\lokesh.v\\LiveWicketPlus\\config\\log4j2.xml");
//		if (!logConfigFile.exists()) {
//		    System.out.println("Log4j2 configuration file not found at: " + logConfigFile.getPath());
//		} else {
//			
//			System.setProperty("log4j.configurationFile", logConfigFile.getAbsolutePath());
//			Configurator.initialize(null, System.getProperty("log4j.configurationFile"));
//			
//		    Logger logger = LogManager.getLogger(LogUtil.class);
//		    logger.info("Log4j configuration file set to: {}", logConfigFile.getPath());
//		}
	}
	private LogUtil() {
	}

	public static Logger getPlayerServletLogger() {
		return LogManager.getLogger(PlayerDetailsServlet.class);
	}

	public static Logger getMatchServletLogger() {
		return LogManager.getLogger(MatchServlet.class);
	}

	public static Logger getUserServletLogger() {
		return LogManager.getLogger(UserServlet.class);
	}

	public static Logger getLoginServletLogger() {
		getLog();
		return LogManager.getLogger(LoginServlet.class);
	}

	public static Logger getLogoutServletLogger() {
		return LogManager.getLogger(LogoutServlet.class);
	}

	public static Logger getJPAUtilLogger() {
		return LogManager.getLogger(JPAUtil.class);
	}
}
