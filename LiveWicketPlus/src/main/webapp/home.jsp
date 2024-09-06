
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Match and Player Management</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/png/logo-white.png">
  
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Aclonica&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: "Aclonica", sans-serif;
            font-weight: 400;
            color: #E1D9D1;
            text-align: center;
            margin: 0;
            padding: 0;
            color: #333;
            width: 100%;
            height: 100vh;
            background-image: url('${pageContext.request.contextPath}/static/png/logo-color.png');
            background-size: cover;
            background-repeat:no-repeat;
            background-position: center;
        }

        .header {
            color: #fff;
            padding: 10px;
            text-align: right;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logout-button, .user-list-button {
            color: white;
            text-decoration: none;
            background-color: black;
            padding:6px 16px;
            border-radius: 5px;
            margin-left: 10px;
            font-size:14px;
        }

        .logout-button:hover, .user-list-button:hover {
            background-color: white;
            color:black;
            text-decoration:none;
        }

        h1 {
            text-align: center;
            color: black;;
            margin-top: 0px;
        }

        h2 {
            color: #333;
        }

        ul {
            list-style: none;
            padding-left: 0px;
            padding-right: 10px;
            width: 600px;
        }
        li {
            display: inline-block;
        }

        .button {
            text-decoration: none;
            border-radius: 5px;
            font-size: 15px;
            color:white;
            display: inline-block;
            margin-top:30px;
        }

        .button:hover {
           color:black;
        }

  
       

        #content {
            display: flex;
            justify-content: space-around;
            align-items: flex-start;
            flex-wrap: wrap;
            padding: 20px;
        }

        #match, #player {
            padding: 20px;
            border-radius: 8px;
            width: 500px;
            margin: 10px;
        }

        #match h2, #player h2 {
            font-size: 18px; /* Reduced font size for headings */
        }

        #forms {
            margin: 20px;
        }

        .li1 {
            margin-left: 0px;
            margin-right: 90px;
        }

        .li2 {
            margin-right: 70px;
        }
    </style>
</head>
<body>
    <c:if test="${empty sessionScope.loggedInUser}">
        <c:redirect url="login.jsp"/>
    </c:if>

    <div class="header">
        <c:if test="${sessionScope.loggedInUser.username == 'admin'}">
            <a href="UserServlet?action=list" class="user-list-button">View User List</a>
        </c:if>
        <a href="logout" class="logout-button">Logout</a>
    </div>

    <h1>Match and Player Management System</h1>

    <div id="content">
        <div id="match">
            <h2>Manage Matches</h2>
            <ul>
                <li class="li1"><a href="addMatch.jsp" class="button">Add New Match</a></li>
                <li class="li2"><a href="MatchServlet?action=list" class="button">View All Matches</a></li>
            </ul>
        </div>

        <div id="player">
            <h2>Manage Players</h2>
            <ul>
                <li class="li1"><a href="addPlayer.jsp" class="button">Add New Player</a></li>
                <li class="li2"><a href="PlayerServlet?action=list" class="button">View All Players</a></li>
            </ul>
        </div>
    </div>


</body>
</html>
