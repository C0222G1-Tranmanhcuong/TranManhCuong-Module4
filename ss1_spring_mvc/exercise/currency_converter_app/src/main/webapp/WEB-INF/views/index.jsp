<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/14/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CHUYỂN ĐỔI TIỀN TỆ</title>
    <style>
        #form {
            border: 2px solid black;
            background: cadetblue;
            width: 180px;
            margin: 50px auto;
            padding: 0 20px 20px;
        }

        #data label {
            float: left;
            width: 160px;
            padding-right: 10px;
        }

        #data input {
            display: flex;
            width: 260px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div id="form">
    <form action="/current" method="post">
        <div>
            <p>CHUYỂN ĐỔI TIỀN TỆ</p>
        </div>
        <div>
            <label>USD :</label>
            <input type="text" name="usd" value="${usd}">
        </div>
        <br>
        <label>Result: </label>
        <label> ${result}</label>
        <div>
            <br>
            <input type="submit" value="Converter">
        </div>
    </form>
</div>
</body>
</html>
