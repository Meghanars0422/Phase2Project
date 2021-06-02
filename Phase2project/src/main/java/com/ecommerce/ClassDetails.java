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
 * Servlet implementation class ClassDetails
 */
@WebServlet("/ClassDetails")
public class ClassDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			
			List<ClassTable> list = session.createQuery("from ClassTable").list();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>List of classes assigned for various subjects</b><br><br>");
			for(ClassTable c: list) {
				out.println("<table border='1' bordercolor='black'>" + "<tr>" + 
						"<th> ClassID </th>" + 
						"<th> Classname </th>" +
						"<th> Subjectname </th>" +
						"</tr>" );
				Teacher teacher = c.getTeachers();
				Subject subject = teacher.getSubjects();
				out.println(
						"<tr>" + 
						"<td>" + String.valueOf(c.getClassID()) + "</td>" +
						"<td>" + String.valueOf(c.getClassname()) + "</td>" +
						"<td>" + String.valueOf(subject.getSubjectname()) + "</td>" +
						"</tr>" +
						"</table>");
						
			}
			out.println("</body></html>");
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
