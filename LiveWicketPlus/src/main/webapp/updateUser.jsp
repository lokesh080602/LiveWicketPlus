<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
      <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/png/logo-white.png">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<c:if test="${empty sessionScope.loggedInUser}">
    <c:redirect url="login.jsp"/>
</c:if>
    <div class="container">
        <h1>Add/Update User</h1>
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="${action}">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user.password}" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
            
            <label for="favoriteTeams">Favorite Teams (comma separated):</label>
            <input type="text" id="favoriteTeams" name="favoriteTeams" value="${user.favoriteTeams.join(',')}" required>
            
            <label for="favoritePlayers">Favorite Players (comma separated):</label>
            <input type="text" id="favoritePlayers" name="favoritePlayers" value="${user.favoritePlayers.join(',')}" required>
            
            <input type="submit" value="Save">
        </form>
        <br>
        <a class="button" href="UserServlet?action=list">Back to User List</a>
    </div>
</body>
</html>
