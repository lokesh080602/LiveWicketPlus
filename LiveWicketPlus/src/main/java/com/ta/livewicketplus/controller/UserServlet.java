package com.ta.livewicketplus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;

import com.ta.livewicketplus.dto.User;
import com.ta.livewicketplus.service.UserService;
import com.ta.livewicketplus.util.LogUtil;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogUtil.getUserServletLogger();
	private final UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		logger.info("Action received: {}", action);

		if (action == null || action.isEmpty() || "list".equals(action)) {
			listUsers(request, response);
		} else if ("view".equals(action)) {
			viewUser(request, response);
		} else if ("delete".equals(action)) {
			deleteUser(request, response);
		} else if ("update".equals(action)) {
			showUpdateForm(request, response);
		} else {
			logger.warn("Unknown action: {}", action);
			listUsers(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		logger.info("Action received: {}", action);
		if ("add".equals(action)) {
			addUser(request, response);
		} else if ("update".equals(action)) {
			updateUser(request, response);
		} else {
			logger.warn("Unknown action: {}", action);
			listUsers(request, response);
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = userService.getAllUsers();
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listUsers.jsp");
		dispatcher.forward(request, response);
		logger.info("Listed all users");
	}

	private void viewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				long id = Long.parseLong(idParam);
				User user = userService.getUserById(id);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewUser.jsp");
				dispatcher.forward(request, response);
				logger.info("Viewed user details for ID: {}", id);
			} catch (NumberFormatException e) {
				logger.error("Invalid user ID format: {}", idParam, e);
				request.setAttribute("error", "Invalid user ID format.");
				listUsers(request, response);
			}
		} else {
			logger.error("Invalid user ID format: {}", idParam);
			listUsers(request, response);
		}
	}

	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				long id = Long.parseLong(idParam);
				User user = userService.getUserById(id);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
				dispatcher.forward(request, response);
				logger.info("Preparing update form for user ID: {}", id);
			} catch (NumberFormatException e) {
				logger.error("Invalid user ID format: {}", idParam, e);
				request.setAttribute("error", "Invalid user ID format.");
				listUsers(request, response);
			}
		} else {
			logger.error("User ID not provided for update.");
			listUsers(request, response);
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			List<String> favoriteTeams = List.of(request.getParameter("favoriteTeams").split(","));
			List<String> favoritePlayers = List.of(request.getParameter("favoritePlayers").split(","));
			user.setFavoriteTeams(favoriteTeams);
			user.setFavoritePlayers(favoritePlayers);
			boolean userExist = userService.alreadExitUser(user);
			logger.info("User Existing or Not: {}", userExist);
			if (!userExist) {
				userService.saveUser(user);
				logger.info("Added new user: {}", user.getUsername());
				response.sendRedirect("registerHappens.jsp?pass=pass");
			} else {
				response.sendRedirect("registerHappens.jsp?pass=fail");
			}
		} catch (NumberFormatException e) {
			logger.error("Invalid input format", e);
			request.setAttribute("error", "Invalid input format. Please check your data.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/addUser.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("userId"));
			User user = userService.getUserById(id);
			if (user != null) {
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setEmail(request.getParameter("email"));
				List<String> favoriteTeams = List.of(request.getParameter("favoriteTeams").split(","));
				List<String> favoritePlayers = List.of(request.getParameter("favoritePlayers").split(","));
				user.setFavoriteTeams(favoriteTeams);
				user.setFavoritePlayers(favoritePlayers);

				userService.updateUser(user);
				logger.info("Updated user with ID: {}", id);
				response.sendRedirect("UserServlet?action=list");
			} else {
				logger.warn("User not found for update with ID: {}", id);
				listUsers(request, response);
			}
		} catch (NumberFormatException e) {
			logger.error("Invalid input format", e);
			request.setAttribute("error", "Invalid input format. Please check your data.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/updateUser.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			userService.deleteUser(id);
			logger.info("Deleted user with ID: {}", id);
			response.sendRedirect("UserServlet?action=list");
		} catch (NumberFormatException e) {
			logger.error("Invalid user ID format", e);
			request.setAttribute("error", "Invalid user ID format. Please check your data.");
			listUsers(request, response);
		}
	}
}
