<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <center>
            <h1>Add a student</h1>
            <form action="list" method="post">
                <input type="hidden" name="action" value="add">
                ID: <input type="text" name="id"><br>
                Name: <input type="text" name="name"><br>
                Address: <input type="text" name="address"><br>
                Score: <input type="text" name="score"><br>
                <input type="submit" value="Add student">
            </form>
        </center>
    </body>
</html>
