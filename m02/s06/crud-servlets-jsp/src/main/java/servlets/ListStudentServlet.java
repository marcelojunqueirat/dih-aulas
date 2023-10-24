package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import database.Student;

@WebServlet("/students")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Boolean isRegister = Boolean.valueOf(req.getParameter("registered"));
		req.setAttribute("isRegisterRequest", isRegister);
		
		List<Student> students = Database.listAll();
		req.setAttribute("students", students);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(req, resp);
	}

}
