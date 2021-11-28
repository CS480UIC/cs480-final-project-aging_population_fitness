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

public class Exercise_injuryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise_injuryServletDelete() {
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
		Exercise_injuryDao exercise_injuryDao = new Exercise_injuryDao();
		Exercise_injury exercise_injury = null;
		if(method.equals("search"))
		{
			try {
				exercise_injury = exercise_injuryDao.findByInjuryID(request.getParameter("injury_id"));
				
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
						request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Exercise Injury not found");
				request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.print("injury_id before delete call: ");
				System.out.println(exercise_injury);	//test line
				exercise_injuryDao.delete(request.getParameter("injury_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Exercise Injury Deleted");
			request.getRequestDispatcher("/jsps/exercise_injury/exercise_injury_read_output.jsp").forward(request, response);
		}
	}
}



