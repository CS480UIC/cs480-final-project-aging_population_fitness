package user_injury.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_injury.dao.User_injuryDao;
import user_injury.domain.User_injury;


/**
 * Servlet implementation class UserServlet
 */

public class User_injuryServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_injuryServletRead() {
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
		User_injury user_injury = null;
		User_injuryDao user_injuryDao = new User_injuryDao();
		
		try {
			user_injury = user_injuryDao.findByInjuryID(request.getParameter("injury_id")); /* here */
			System.out.println(user_injury);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(user_injury.getInjuryID()!=null){ /* here */
					System.out.println(user_injury);
					request.setAttribute("user injury", user_injury);
					request.getRequestDispatcher("/jsps/user_injury/user_injury_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "User injury not found");
			request.getRequestDispatcher("/jsps/user_injury/user_injury_read_output.jsp").forward(request, response);
		}
	}
}



