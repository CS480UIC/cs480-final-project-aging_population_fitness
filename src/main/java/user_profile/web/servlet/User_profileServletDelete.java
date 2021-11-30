package user_profile.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_profile.dao.User_profileDao;
import user_profile.domain.User_profile;


/**
 * Servlet implementation class UserServlet
 */

public class User_profileServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_profileServletDelete() {
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
		User_profileDao user_profileDao = new User_profileDao();
		User_profile user_profile = null;
		if(method.equals("search"))
		{
			try {
				user_profile = user_profileDao.findByUserID(request.getParameter("user_id"));
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(user_profile.getUserID()!=null){
						System.out.println(user_profile);
						request.setAttribute("user_profile", user_profile);
						request.getRequestDispatcher("/jsps/user_profile/user_profile_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/user_profile/user_profile_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.print("user_id before delete call: ");
				System.out.println(user_profile);	//test line
				user_profileDao.delete(request.getParameter("user_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "User Profile Deleted");
			request.getRequestDispatcher("/jsps/user_profile/user_profile_read_output.jsp").forward(request, response);
		}
	}
}



