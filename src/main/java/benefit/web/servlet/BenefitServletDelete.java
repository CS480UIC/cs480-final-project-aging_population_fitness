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

public class BenefitServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenefitServletDelete() {
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
		BenefitDao benefitDao = new BenefitDao();
		Benefit benefit = null;
		if(method.equals("search"))
		{
			try {
				benefit = benefitDao.findByBenefitID(request.getParameter("benefit_id"));
				
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
						request.getRequestDispatcher("/jsps/benefit/benefit_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Benefit not found");
				request.getRequestDispatcher("/jsps/benefit/benefit_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.print("benefit_id before delete call: ");
				System.out.println(benefit);	//test line
				benefitDao.delete(request.getParameter("benefit_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Benefit Deleted");
			request.getRequestDispatcher("/jsps/benefit/benefit_read_output.jsp").forward(request, response);
		}
	}
}



