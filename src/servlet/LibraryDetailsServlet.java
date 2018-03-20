package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoItem;
import dao.DaoLibrary;

/**
 * Servlet implementation class LibraryDetailsServlet
 */
@WebServlet("/library")
public class LibraryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryDetailsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int libraryId = Integer.parseInt(request.getParameter("id"));
		String searchParam = request.getParameter("q");
		String type = request.getParameter("type") != null ? request.getParameter("type") : "Item";
		request.setAttribute("library", DaoLibrary.get(libraryId));
		request.setAttribute("items", DaoItem.searchInLibrary(libraryId, searchParam, type));
		request.setAttribute("searchType", type);
		request.setAttribute("searchRq", searchParam);
		
		getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/libraryDetails.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
