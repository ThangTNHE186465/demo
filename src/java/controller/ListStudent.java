package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import model.Student;

public class ListStudent extends HttpServlet {
    
    private List<Student> students;

    @Override
    public void init() throws ServletException {
        students = new ArrayList<>();
        students.add(new Student(1, "A", "NA", 10));
        students.add(new Student(2, "B", "NA", 9));
        students.add(new Student(3, "C", "NA", 8));
        students.add(new Student(4, "D", "NA", 7));
        students.add(new Student(5, "E", "NA", 6));
        getServletContext().setAttribute("data", students);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            deleteStudent(id);
            response.sendRedirect("list");
        } else {
            request.setAttribute("data", students);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addStudent(request);
        } else if ("edit".equals(action)) {
            editStudent(request);
        } 

        response.sendRedirect("list");
    }
    
    private void addStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int score = Integer.parseInt(request.getParameter("score"));

        students.add(new Student(id, name, address, score));
    }

    private void editStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int score = Integer.parseInt(request.getParameter("score"));

        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAdd(address);
                student.setScore(score);
                break;
            }
        }
    }

    private void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        getServletContext().setAttribute("data", students);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
