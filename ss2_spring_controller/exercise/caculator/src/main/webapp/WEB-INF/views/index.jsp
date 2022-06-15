
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
    <h1>Simple Calculator</h1>
    <form action="/calculate" method="post">
        <filedset>
            <h3>Calculator</h3>
            <table>
                <tr>
                    <td>First Operand:</td>
                    <td><input type="text" name="number1" value="${number1}"></td>
                </tr>
                <tr>
                    <td>Operator:</td>
                    <td>
                        <select name="operator">
                            <option value="+">Addition</option>
                            <option value="-">subtraction</option>
                            <option value="*">Multiplication</option>
                            <option value="/">Division</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Second Operand:</td>
                    <td><input type="text" name="number2" value="${number2}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Calculate"></td>
                </tr>
            </table>
        </filedset>
    </form>
    Result: <p>${result}</p>
</div>
</body>
</html>
