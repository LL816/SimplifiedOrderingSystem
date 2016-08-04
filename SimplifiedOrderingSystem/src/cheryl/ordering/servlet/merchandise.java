package cheryl.ordering.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cheryl.ordering.comprise.MerchandiseList;
import cheryl.ordering.comprise.MyPair;

import java.util.ArrayList;
/**
 * Servlet implementation class merchandise
 */
@WebServlet("/merchandise")
public class merchandise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public merchandise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyPair result = MerchandiseList.listMerchandise();
		ArrayList merchandise_name = result.getElement(0);
		ArrayList price = result.getElement(1);
		int len = merchandise_name.size();
		
		response.getWriter().println("Merchandise Name		Price		" + "\n");
		
		for(int i=0;i<len;i++){
			response.getWriter().println(merchandise_name.get(i) + "	" + price.get(i) + "\n");
		}
		
	}

}
