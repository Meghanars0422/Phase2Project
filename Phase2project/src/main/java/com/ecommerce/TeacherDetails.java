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
 * Servlet implementation class TeacherDetails
 */
@WebServlet("/TeacherDetails")
public class TeacherDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDetails() {
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
			
			List<Teacher> list = session.createQuery("from Teacher").list();
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>List of teachers assigned to different classes for different subjects</b><br><br>");
			for(Teacher te: list) {
				out.println("<table border='1' bordercolor='black'>" + "<tr>" + 
						"<th> Teacher ID </th>" + 
						"<th> Teacher Name </th>" + 
						"<th> Class Name </th>" +
						"<th> Subject Name </th>" +
						"</tr>" );
				Subject sub = te.getSubjects();
				ClassTable cl = sub.getClasses(); 
				out.println(
						"<tr>" + 
						"<td>" + String.valueOf(te.getTeacherID()) + "</td>" +
						"<td>" + String.valueOf(te.getTeachername()) + "</td>" +
						"<td>" + String.valueOf(cl.getClassname()) + "</td>" +
						"<td>" + String.valueOf(sub.getSubjectname()) + "</td>" +
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
