package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class StudentsDetails
 */
@WebServlet("/StudentsDetails")
public class StudentsDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();

			List<Student> list = session.createQuery("from Student").list();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>List of students assigned to a class with different subjects and teachers</b><br><br>");
			for (Student s : list) {
				out.println("<table border='1' bordercolor='black'>" + "<tr>" + "<th> StudentID </th>"
						+ "<th> Stundent Name </th>" + "<th> Stundent Age </th>" + "<th> Student Address </th>" + "<th> Student Gender </th>" + "<th> Class Name </th>"
						+ "<th> Teacher Name </th>" + "<th> Subject Name </th>" + "</tr>");
				ClassTable classlist = s.getClasses();
				Teacher teacher = classlist.getTeachers();
				Subject subject = teacher.getSubjects();

				out.println("<tr>" + "<td>" + String.valueOf(s.getStudentID()) + "</td>" + "<td>"
						+ String.valueOf(s.getName()) + "</td>" + "<td>" + String.valueOf(s.getAge()) + "</td>" + "<td>"
						+ String.valueOf(s.getAddress()) + "</td>" + "<td>"
						+ String.valueOf(s.getGender()) + "</td>" + "<td>"
						+ String.valueOf(classlist.getClassname()) + "</td>" + "<td>"
						+ String.valueOf(teacher.getTeachername()) + "</td>" + "<td>"
						+ String.valueOf(subject.getSubjectname()) + "</td>" + "</tr>" + "</table>");

			}
			out.println("</body></html>");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
