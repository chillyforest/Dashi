package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.MySQLDBConnection;

/**
 * Servlet implementation class SearchRestaurants
 */
@WebServlet("/restaurants")
public class SearchRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String username = "";
		//PrintWriter out = response.getWriter();
		if (request.getParameter("username") != null) {
			username = request.getParameter("username");
			//out.print("Hello " + username);
		}
		JSONObject obj = new JSONObject();
		try {
			obj.put("username", username);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(obj);
		out.flush();
		out.close();*/
		
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>This is a HTML page</h1>");
		out.println("</body></html>");
		out.flush();
		out.close();*/
		
		/*JSONArray array = new JSONArray();
		try {
			if (request.getParameterMap().containsKey("user_id")
						&& request.getParameterMap().containsKey("lat")
						&& request.getParameterMap().containsKey("lon")) {
					String userId = request.getParameter("user_id");
					double lat = Double.parseDouble(request.getParameter("lat"));
					double lon = Double.parseDouble(request.getParameter("lon"));
					array.put(new JSONObject().put("name", "Panda Express"));
					array.put(new JSONObject().put("name", "Hong Kong Express"));
				}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RpcParser.writeOutput(response, array);*/
		
		JSONArray array = new JSONArray();
		DBConnection connection = new MySQLDBConnection();
		if (request.getParameterMap().containsKey("lat") 
				&& request.getParameterMap().containsKey("lon")) {
			// term is null or empty by default
			String term = request.getParameter("term");
			//String userId = (String) session.getAttribute("user");
			String userId = "1111";
			double lat = Double.parseDouble(request.getParameter("lat"));
			double lon = Double.parseDouble(request.getParameter("lon"));
			array = connection.searchRestaurants(userId, lat, lon, term);
		}
		RpcParser.writeOutput(response, array);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
