<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/16/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #cal {
            border: 1px solid black;
            margin: 0 auto;
            padding: 0 20px 20px;
            background: darkcyan;
            width: 300px;
        }
    </style>
</head>
<body>
<div id="cal">
    <h2>EMAIL BOX</h2>
    <p>Languages: ${emailBox.languages}</p>
    <p>Page Size: ${emailBox.pageSize}</p>
    <p>Spams Filter: ${emailBox.spamsFilter}</p>
    <p>Signature: ${emailBox.signature}</p>
</div>
</body>
</html>
