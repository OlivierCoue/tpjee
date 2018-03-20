package servlet;

import java.io.IOException;
import java.time.DayOfWeek;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoItem;
import dao.DaoLibrary;
import model.Film;
import model.Library;
import model.MusicFile;
import model.MusicalVideo;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/item")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int libraryId = Integer.parseInt(request.getParameter("libraryId"));
		Library library = DaoLibrary.get(libraryId);
		String itemType = request.getParameter("itemType");
		String filename = request.getParameter("filename");
		
		switch (itemType) {
			case "film":
			String title = request.getParameter("title");
			String director = request.getParameter("director");
			Film film = new Film(filename, library, title, director);
			DaoItem.save(film);
			break;
		
			case "musicFile":
			String name = request.getParameter("name");
			String artist = request.getParameter("artist");
			String album = request.getParameter("album");
			MusicFile musicFile = new MusicFile(filename, library, name, artist, album);
			DaoItem.save(musicFile);
			break;
			
			case "musicalVideo":
			int musicFileId = Integer.parseInt(request.getParameter("musicFileId"));
			MusicFile musicFile2 = (MusicFile) DaoItem.get(musicFileId);
			MusicalVideo musicalVideo = new MusicalVideo(filename, library, musicFile2);
			DaoItem.save(musicalVideo);
			break;
		default:
			break;
		}
		
		response.sendRedirect(request.getContextPath()+"/library?id="+libraryId);
	}

}
