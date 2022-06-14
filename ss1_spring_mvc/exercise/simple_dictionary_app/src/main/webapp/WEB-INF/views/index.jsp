<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>ỨNG DỤNG TỪ ĐIỂN ĐƠN GIẢN</title>
<style>
    #form {
        border: 2px solid black;
        background: cadetblue;
        width: 400px;
        height: 200px;
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
    <form action="/dictonary" method="post">
        <div style="text-align: center">
            <p>TRA TỪ ĐIỂN</p>
        </div>
        <div style="margin: 40px 40px">
            <div>
                <label>TIẾNG ANH :</label>
                <input type="text" name="english" value="${english}">
            </div>
            <br>
            <label>TIẾNG VIỆT: </label>
            <label> ${result}</label>
            <div>
                <br>
                <input type="submit" value="Translate">
            </div>
        </div>

    </form>
</div>
</body>
</html>
