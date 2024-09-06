<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User Profile</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/png/logo-white.png">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .form-container {
            max-width: 640px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h1>Update User Profile</h1>
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${user.userId}">

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user.password}" required>

            <label for="favoriteTeams">Favorite Teams (comma-separated):</label>
            <input type="text" id="favoriteTeams" name="favoriteTeams" value="${user.favoriteTeams.get(0)}">

            <label for="favoritePlayers">Favorite Players (comma-separated):</label>
            <input type="text" id="favoritePlayers" name="favoritePlayers" value="${user.favoritePlayers.get(0)}">

            <input type="submit" value="Update Profile">
        </form>
        <a href="profile.jsp">Back to Profile</a>
    </div>

</body>
</html>
