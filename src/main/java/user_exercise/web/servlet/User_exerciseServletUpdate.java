package user_exercise.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_exercise.dao.User_exerciseDao;
import user_exercise.domain.User_exercise;

/**
 * Servlet implementation class UserServlet
 */

public class User_exerciseServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User_exerciseServletUpdate() {
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
		User_exerciseDao user_exercisedao = new User_exerciseDao();
		User_exercise user_exercise = null;

		if(method.equals("search"))
		{
			try {
				user_exercise = user_exercisedao.findByUserIDExerciseID(request.getParameter("user_id"), request.getParameter("exercise_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(user_exercise.getUserID()!=null && user_exercise.getExerciseID()!=null){
				request.setAttribute("user_exercise", user_exercise);
				request.getRequestDispatcher("/jsps/user_exercise/user_exercise_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "User Exercise not found");
				request.getRequestDispatcher("/jsps/user_exercise/user_exercise_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			User_exercise form = new User_exercise();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				
			}
			
			form.setExerciseID(info.get(2));
			form.setUserID(request.getParameter("user_id"));
			form.setNewExerciseID(request.getParameter("new_exercise_id"));
			System.out.println(form.toString());
			try {
				user_exercisedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "User Exercsie Updated");
			request.getRequestDispatcher("/jsps/user_exercise/user_exercise_read_output.jsp").forward(request, response);
		}
	}
}



