<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Match</title>
     <link rel="icon" type="image/x-icon" href="../resources/static/png/logo-white.png">
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

<h1>Add New Match</h1>
<form action="MatchServlet" method="post">
    <input type="hidden" name="action" value="add" />
    <label for="teamA">Team A:</label>
    <input type="text" name="teamA" required /><br />
    <label for="teamB">Team B:</label>
    <input type="text" name="teamB" required /><br />
    <label for="scoreTeamA">Score Team A:</label>
    <input type="number" name="scoreTeamA" required /><br />
    <label for="scoreTeamB">Score Team B:</label>
    <input type="number" name="scoreTeamB" required /><br />
    <input type="submit" value="Add Match" />
</form>
<br>
<a style="text-align:center;" href="MatchServlet?action=list">Back to Match List</a>

</body>
</html>
