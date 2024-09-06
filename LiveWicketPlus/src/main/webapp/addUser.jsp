<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add User</title>
     <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/png/logo-white.png">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
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
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
        .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            background-color: white;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
            text-align: center;
        }
        .popup.success {
            border-color: green;
            color: green;
        }
        .popup.error {
            border-color: red;
            color: red;
        }
        .popup button {
            margin-top: 10px;
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <h1>Add User</h1>
    <form id="addUserForm" action="UserServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required aria-required="true">
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required aria-required="true">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required aria-required="true">
        
        <label for="favoriteTeams">Favorite Teams (comma-separated):</label>
        <input type="text" id="favoriteTeams" name="favoriteTeams">
        
        <label for="favoritePlayers">Favorite Players (comma-separated):</label>
        <input type="text" id="favoritePlayers" name="favoritePlayers">
        
        <input type="submit" id="sub" value="Add User">
    </form>><br>
    <a href="UserServlet?action=list">Back to List</a>

</body>
</html>
