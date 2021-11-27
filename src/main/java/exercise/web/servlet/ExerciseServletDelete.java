package exercise.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.dao.ExerciseDao;
import exercise.domain.Exercise;


/**
 * Servlet implementation class UserServlet
 */

public class ExerciseServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseServletDelete() {
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
		ExerciseDao exerciseDao = new ExerciseDao();
		Exercise exercise = null;
		if(method.equals("search"))
		{
			try {
				exercise = exerciseDao.findByExerciseID(request.getParameter("exercise_id"));
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(exercise.getExerciseID()!=null){
						System.out.println(exercise);
						request.setAttribute("exercise", exercise);
						request.getRequestDispatcher("/jsps/exercise/exercise_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/exercise/exercise_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.print("exercise_id before delete call: ");
				System.out.println(exercise);	//test line
				exerciseDao.delete(request.getParameter("exercise_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/exercise/exercise_read_output.jsp").forward(request, response);
		}
	}
}



