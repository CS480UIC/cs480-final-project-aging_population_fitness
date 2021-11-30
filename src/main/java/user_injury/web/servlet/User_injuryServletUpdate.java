package user_injury.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_injury.dao.User_injuryDao;
import user_injury.domain.User_injury;

/**
 * Servlet implementation class UserServlet
 */

public class User_injuryServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User_injuryServletUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		User_injuryDao user_injurydao = new User_injuryDao();
		User_injury user_injury = null;

		if(method.equals("search"))
		{
			try {
				user_injury = user_injurydao.findByInjuryID(request.getParameter("injury_id")); /* here */
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(user_injury.getInjuryID()!=null){ /* here */
				request.setAttribute("user_injury", user_injury);
				request.getRequestDispatcher("/jsps/user_injury/user_injury_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "User Injury not found");
				request.getRequestDispatcher("/jsps/user_injury/user_injury_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			User_injury form = new User_injury();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				
			}
			
			/* here */
			
			form.setUserID(info.get(2));
			form.setUserInjuryName(info.get(3));
			form.setUserInjuryDescription(info.get(4));
			form.setUserInjurySeverity(info.get(5));
			form.setUserInjuryDate(info.get(6));
			form.setInjuryID(request.getParameter("injury_id"));
			System.out.println("In ServletUdpate");
			System.out.println( form.toString() );
			try {
				user_injurydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "User Injury Updated");
			request.getRequestDispatcher("/jsps/user_injury/user_injury_read_output.jsp").forward(request, response);
		}
	}
}



