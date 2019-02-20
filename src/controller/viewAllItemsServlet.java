package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllItemsServlet
 */
@WebServlet("/viewAllItemsServlet")
public class viewAllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//creating an instance of listItemHelper to snag items for an arrayList
		ListItemHelper dao = new ListItemHelper();
		
		request.setAttribute("allItems", dao.showAllItems());
		
		if(dao.showAllItems().isEmpty()) {
			request.setAttribute("allItems", " ");
		}
		//sending to page that will display items in the database
		getServletContext().getRequestDispatcher("/shopping-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
