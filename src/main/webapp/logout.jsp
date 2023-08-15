<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout</title>
</head>
<body>
<%

  session = request.getSession(false);
// for checking the session is available or not, if not available it will throw exception, "Session already invalidated."
 if (session!=null) {
   session.invalidate();
   response.sendRedirect("index.html");
 }



%>
</body>
</html>