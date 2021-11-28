package exercise_injury.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise_injury.dao.Exercise_injuryDao;
import exercise_injury.domain.Exercise_injury;


/**
 * Servlet implementation class UserServlet
 */

public class Exercise_injuryServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise_injuryServletRead() {
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
		Exercise_injury exercise_injury = null;
		Exercise_injuryDao exercise_injuryDao = new Exercise_injuryDao();
		
		try {
			exercise_injury = exercise_injuryDao.findByInjuryID(request.getParameter("injury_id"));
			System.out.println(exercise_injury);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(exercise_injury.getInjuryID()!=null){
					System.out.println(exercise_injury);
					request.setAttribute("exercise_injury", exercise_injury);
					request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Exercise Injury not found");
			request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_read_output.jsp").forward(request, response);
		}
	}
}



