<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        #cal {
            border: 1px solid black;
            margin: 0 auto;
            padding: 0 20px 20px;
            background: antiquewhite;
            width: 300px;
        }
    </style>
</head>
<body>
<div id="cal">
    <h2>SETTINGS</h2>
    <form:form modelAttribute="emailBox" action="/create" method="post">
        <label>Languages: </label>
        <form:select path="languages">
            <form:options items="${listLanguages}"></form:options>
        </form:select>
        <br>
        <label>Page Size: </label>
        <span>Show</span>
        <form:select path="pageSize">
            <form:options items="${listPageSize}"></form:options>
        </form:select>
        <span>emails per page</span>
        <br>
        <label>Spams Filter: </label>
        <form:checkbox path="spamsFilter" title="Enable spams filter"/>
        <br>
        <label>Signature: </label>
        <form:input type="text" path="signature"/>
        <br>
        <input type="submit" value="Update">
        <input type="submit" value="Cancel">
    </form:form>
</div>
</body>
</html>
