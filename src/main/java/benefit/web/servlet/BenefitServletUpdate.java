package benefit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import benefit.dao.BenefitDao;
import benefit.domain.Benefit;

/**
 * Servlet implementation class UserServlet
 */

public class BenefitServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BenefitServletUpdate() {
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
		BenefitDao benefitdao = new BenefitDao();
		Benefit benefit = null;

		if(method.equals("search"))
		{
			try {
				benefit = benefitdao.findByBenefitID(request.getParameter("benefit_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(benefit.getBenefitID()!=null){
				request.setAttribute("benefit", benefit);
				request.getRequestDispatcher("/jsps/benefit/benefit_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Benefit not found");
				request.getRequestDispatcher("/jsps/benefit/benefit_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Benefit form = new Benefit();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				
			}
			
			form.setExerciseID(info.get(2));
			form.setBenefitName(info.get(3));
			form.setBenefitDescription(info.get(4));
			form.setBenefitID(request.getParameter("benefit_id"));

			try {
				benefitdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Benefit Updated");
			request.getRequestDispatcher("/jsps/benefit/benefit_read_output.jsp").forward(request, response);
		}
	}
}



