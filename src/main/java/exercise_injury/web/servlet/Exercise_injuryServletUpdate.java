package exercise_injury.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise_injury.dao.Exercise_injuryDao;
import exercise_injury.domain.Exercise_injury;

/**
 * Servlet implementation class UserServlet
 */

public class Exercise_injuryServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Exercise_injuryServletUpdate() {
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
		Exercise_injuryDao exercise_injurydao = new Exercise_injuryDao();
		Exercise_injury exercise_injury = null;

		if(method.equals("search"))
		{
			try {
				exercise_injury = exercise_injurydao.findByInjuryID(request.getParameter("injury_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(exercise_injury.getInjuryID()!=null){
				request.setAttribute("exercise_injury", exercise_injury);
				request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Exercise Injury not found");
				request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Exercise_injury form = new Exercise_injury();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				
			}
			
			System.out.println( info.get(1));
			System.out.println( info.get(2));
			System.out.println( info.get(3));
			form.setExerciseID(info.get(2));
			form.setExerciseInjuryName(info.get(3));
			form.setExerciseInjuryDescription(info.get(4));
			form.setInjuryID(request.getParameter("injury_id"));

			try {
				exercise_injurydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Exercise injury Updated");
			request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_read_output.jsp").forward(request, response);
		}
	}
}



