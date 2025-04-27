<%-- 
    Document   : index
    Created on : 27 Apr, 2025, 9:56:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Simple Interest Calculator</title></head>
<body>
    <h2>Simple Interest Calculator</h2>
    <form action="SimpleInterestServlet" method="post">
        Principal: <input type="text" name="principal"><br><br>
        Rate: <input type="text" name="rate"><br><br>
        Time: <input type="text" name="time"><br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
