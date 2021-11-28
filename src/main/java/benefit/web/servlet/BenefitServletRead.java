package benefit.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import benefit.dao.BenefitDao;
import benefit.domain.Benefit;


/**
 * Servlet implementation class UserServlet
 */

public class BenefitServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenefitServletRead() {
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
		Benefit benefit = null;
		BenefitDao benefitDao = new BenefitDao();
		
		try {
			benefit = benefitDao.findByBenefitID(request.getParameter("benefit_id"));
			System.out.println(benefit);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(benefit.getBenefitID()!=null){
					System.out.println(benefit);
					request.setAttribute("benefit", benefit);
					request.getRequestDispatcher("/jsps/benefit/benefit_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Benefit not found");
			request.getRequestDispatcher("/jsps/benefit/benefit_read_output.jsp").forward(request, response);
		}
	}
}



