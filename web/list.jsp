<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List, model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Student</title>
        <style>
            table, th, td {
                border:1px solid black;
            }
        </style>
        <script>
            function confirmDelete(studentId) {
                if (confirm("Are you sure you want to delete this student?")) {
                    window.location.href = "list?action=delete&id=" + studentId;
                }
            }
        </script>
    </head>
    <body>
        <center>
            <a href="addStudent.jsp"><h3>Add a student</h3></a>
            <h1>List Student</h1>
            <table style="width: 25%; text-align: center">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Score</th>
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach var="student" items="${requestScope.data}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.add}</td>
                    <td>${student.score}</td>
                    <td><a href="editStudent.jsp?id=${student.id}">Edit</a></td>
                    <td><a href="javascript:void(0)" onclick="confirmDelete(${student.id})">Delete</a></td>
                </tr>
                </c:forEach>
                <c:if test="${empty data}">
                <tr>
                    <td colspan="6">No students found.</td>
                </tr>
                </c:if>
            </table>
        </center>
    </body>
</html>
