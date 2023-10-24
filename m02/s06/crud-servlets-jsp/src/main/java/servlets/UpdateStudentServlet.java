package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import database.Student;

@WebServlet("/update-student")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer registration = Integer.valueOf(req.getParameter("registration"));
		Student student = Database.get(registration);
		
		req.setAttribute("student", student);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/update-student.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer registration = Integer.valueOf(req.getParameter("registration"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		Student student = Database.get(registration);
		
		if(student != null) {
			student.setName(name);
			student.setEmail(email);
		}
		
		resp.sendRedirect("students");
	}
}
