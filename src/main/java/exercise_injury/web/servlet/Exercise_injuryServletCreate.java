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

import exercise_injury.domain.Exercise_injury;
import exercise_injury.service.Exercise_injuryException;
import exercise_injury.service.Exercise_injuryService;


/**
 * Servlet implementation class UserServlet
 */

public class Exercise_injuryServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise_injuryServletCreate() {
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
		Exercise_injuryService exercise_injuryservice = new Exercise_injuryService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Exercise_injury form = new Exercise_injury();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		// might need to be 1,2,3 because i have a disabled field
		form.setExerciseID(info.get(0));
		form.setExerciseInjuryName(info.get(1));
		form.setExerciseInjuryDescription(info.get(2));		
		
		try {
			exercise_injuryservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Exercise_injuryException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
