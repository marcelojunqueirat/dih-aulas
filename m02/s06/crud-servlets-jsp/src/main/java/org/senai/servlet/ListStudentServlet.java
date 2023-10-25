package org.senai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.database.Database;
import org.senai.model.Student;

@WebServlet("/student")
public class ListStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Verifica se algum par�metro de requisi��o com nome "registered" foi enviado.
		 * Caso sim, recupera o valor como um booleano, dessa forma identificando que
		 * esta � uma requisi��o de cadastro de estudante.
		 */

		boolean isRegisterRequest = Boolean.valueOf(request.getParameter("registered"));
		request.setAttribute("isRegisterRequest", isRegisterRequest);

		/**
		 * Listando os estudantes do banco de dados fict�cio em mem�ria e adicionando-os
		 * como um atributo da requisi��o para que possam ser recuperados dentro do JSP
		 */
		List<Student> students = Database.listAll();
		request.setAttribute("students", students);

		/**
		 * O RequestDispatcher serve para encaminhar ou incluir a requisi��o atual em um
		 * novo recurso, como um JSP, controlando assim as requisi��es e tornando as
		 * p�ginas din�micas.
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}
}
