package org.senai.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.database.Database;
import org.senai.database.Student;

import com.google.gson.Gson;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Lista os estudantes da base de dados fict�cia
		List<Student> students = Database.getStudents();

//		Instancia a biblioteca Gson
		Gson gson = new Gson();

//		Converte a lista de objetos para uma string (em formato JSON)
		String studentsAsJson = gson.toJson(students);

//		Informa que o conte�do retornado � um JSON
		resp.setContentType("application/json");

//		Pega o objeto de escrita do response
		PrintWriter writer = resp.getWriter();

//		Verifica se a listagem de estudantes est� vazia, e em caso positivo, retorna o status HTTP 204
		if (students.isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
			writer.print(studentsAsJson);
			return;
		}

//		Escreve a string na resposta para retornar ao usu�rio
		writer.print(studentsAsJson);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Recupera o estudante como JSON e o converte em uma classe
		Student student = this.convertJsonToClass(req);
		
//		Adiciona-o no banco e retorna o status HTTP 201
		Database.add(student);
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Recupera a matr�cula e converte o JSON em um estudante
		Integer registration = Integer.valueOf(req.getParameter("registration"));
		Student studentUpdated = this.convertJsonToClass(req);

//		Recupera as informa��es atuais do estudante e atualiza as informa��es
		Student currentStudent = Database.getStudent(registration);
		currentStudent.setName(studentUpdated.getName());
		currentStudent.setEmail(studentUpdated.getEmail());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Recupera o estudante
		Integer registration = Integer.valueOf(req.getParameter("registration"));
		Student student = Database.getStudent(registration);
		
//		Caso n�o encontre o estudante, retorna o 404, com uma mensagem
		if (student == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			resp.getWriter().write(String.format("O estudante com identificador %d n�o foi encontrado", registration));
			return;
		}

//		Caso encontre, remove o estudante e retorna o status 200
		Database.remove(registration);
		resp.setStatus(HttpServletResponse.SC_OK);
	}

//	M�todo para receber o estudante e convert�-lo em um objeto
	private Student convertJsonToClass(HttpServletRequest req) throws IOException {
		Gson gson = new Gson();
		BufferedReader reader = req.getReader();
		String studentAsJson = reader.lines().collect(Collectors.joining());
		return gson.fromJson(studentAsJson, Student.class);
	}
}
