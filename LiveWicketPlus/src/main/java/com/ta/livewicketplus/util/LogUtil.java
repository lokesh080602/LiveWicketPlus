package com.ta.livewicketplus.util;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ta.livewicketplus.controller.LoginServlet;
import com.ta.livewicketplus.controller.LogoutServlet;
import com.ta.livewicketplus.controller.MatchServlet;
import com.ta.livewicketplus.controller.PlayerDetailsServlet;
import com.ta.livewicketplus.controller.UserServlet;

public class LogUtil {

	static {
		Logger logger = LogManager.getLogger(LogUtil.class);
		File logConfigFile = new File("C:/Users/lokesh.v/LiveWicketPlus/config/log4j2.xml");
		if (!logConfigFile.exists()) {
			logger.info("Log4j2 configuration file not found at: {}", logConfigFile.getPath());
		} else {

			System.setProperty("log4j.configurationFile", logConfigFile.getPath());
			logger.info("Log4j configuration file set to: {}", logConfigFile.getPath());
		}
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
		return LogManager.getLogger(LoginServlet.class);
	}

	public static Logger getLogoutServletLogger() {
		return LogManager.getLogger(LogoutServlet.class);
	}

	public static Logger getJPAUtilLogger() {
		return LogManager.getLogger(JPAUtil.class);
	}
}
