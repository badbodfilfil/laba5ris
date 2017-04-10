<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Converter</title>
    </head>
    <body>
        <h3>Enter an amount to convert:</h3>
        <form action="submit" method="GET">
            <p><input title="Amount" type="text" name="amount" size="25"></p>
            <br/>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
       ${context}
    </body>
</html>