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

import user_injury.domain.User_injury;
import user_injury.service.User_injuryException;
import user_injury.service.User_injuryService;


/**
 * Servlet implementation class UserServlet
 */

public class User_injuryServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_injuryServletCreate() {
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
		User_injuryService user_injuryservice = new User_injuryService();
		Map<String,String[]> paramMap = request.getParameterMap();
		User_injury form = new User_injury();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		/* here */

		form.setUserID(info.get(0));
		form.setUserInjuryName(info.get(1));
		form.setUserInjuryDescription(info.get(2));
		form.setUserInjurySeverity(info.get(3));
		form.setUserInjuryDate(info.get(4));

		
		try {
			user_injuryservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | User_injuryException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
