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

public class User_injuryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_injuryServletDelete() {
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
		User_injuryDao user_injuryDao = new User_injuryDao();
		User_injury user_injury = null;
		if(method.equals("search"))
		{
			try {
				user_injury = user_injuryDao.findByUserID(request.getParameter("user_id")); /* here */
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(user_injury.getUserID()!=null){ /* here */
						System.out.println(user_injury);
						request.setAttribute("user injury", user_injury);
						request.getRequestDispatcher("/jsps/user_injury/user_injury_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/user_injury/user_injury_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.print("user_id before delete call: "); /* here */
				System.out.println(user_injury);	//test line
				user_injuryDao.delete(request.getParameter("user_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/user_injury/user_injury_read_output.jsp").forward(request, response);
		}
	}
}



