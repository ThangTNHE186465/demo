<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List, model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    List<Student> s = (List<Student>) getServletContext().getAttribute("data");
    Student student = null;
    if (s != null) {
        for (Student x : s) {
            if (x.getId() == id) {
                student = x;
                break;
            }
        }
    }
    request.setAttribute("student", student);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Student</title>
    </head>
    <body>
        <center>
            <h1>Edit a student</h1>
            <form action="list" method="post">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="${student.id}">
                Name: <input type="text" name="name"><br>
                Address: <input type="text" name="address"><br>
                Score: <input type="text" name="score"><br>
                <input type="submit" value="Edit Student">
            </form>
        </center>
    </body>
</html>
