package user_exercise.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_exercise.dao.User_exerciseDao;
import user_exercise.domain.User_exercise;


/**
 * Servlet implementation class UserServlet
 */

public class User_exerciseServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_exerciseServletRead() {
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
		User_exercise user_exercise = null;
		User_exerciseDao user_exerciseDao = new User_exerciseDao();
		
		try {
			user_exercise = user_exerciseDao.findByUserIDExerciseID(request.getParameter("user_id"), request.getParameter("exercise_id"));
			System.out.println(user_exercise);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(user_exercise.getUserID()!=null && user_exercise.getExerciseID()!=null){
					System.out.println(user_exercise);
					request.setAttribute("user exercise", user_exercise);
					request.getRequestDispatcher("/jsps/user_exercise/user_exercise_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "User exercise not found");
			request.getRequestDispatcher("/jsps/user_exercise/user_exercise_read_output.jsp").forward(request, response);
		}
	}
}



