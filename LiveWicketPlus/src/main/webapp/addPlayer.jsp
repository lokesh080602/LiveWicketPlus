<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Player</title>
     <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/png/logo-white.png">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
    input[type="number"]{
    width: calc(100% - 16px);
    padding: 8px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
}
    </style>
</head>
<body>
<c:if test="${empty sessionScope.loggedInUser}">
    <c:redirect url="login.jsp"/>
</c:if>

<h1>Add New Player</h1>
<form action="PlayerServlet" method="post">
    <input type="hidden" name="action" value="add">
    
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" required><br><br>
    
    <label for="age">Age:</label><br>
    <input type="number" id="age" name="age" required><br><br>
    
    <label for="nationality">Nationality:</label><br>
    <input type="text" id="nationality" name="nationality" required><br><br>
    
    <label for="team">Team:</label><br>
    <input type="text" id="team" name="team" required><br><br>
    
    <label for="role">Role:</label><br>
    <input type="text" id="role" name="role" required><br><br>
    
    <label for="battingStyle">Batting Style:</label><br>
    <input type="text" id="battingStyle" name="battingStyle"><br><br>
    
    <label for="bowlingStyle">Bowling Style:</label><br>
    <input type="text" id="bowlingStyle" name="bowlingStyle"><br><br>
    
    <label for="currentMatchStatus">Current Match Status:</label><br>
    <input type="text" id="currentMatchStatus" name="currentMatchStatus"><br><br>
    
    <input type="submit" value="Add Player">
</form>
<br>
<a style="text-align:center;"  href="home.jsp">Back to Home</a>

</body>
</html>
