package api;

import java.io.IOException;
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
 * Servlet implementation class RecommendedRestaurants
 */
@WebServlet("/recommendation")
public class RecommendedRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendedRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static DBConnection connection = new MySQLDBConnection();

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*JSONArray array = new JSONArray();
		try {
			if (request.getParameterMap().containsKey("user_id")) {
				String userId = request.getParameter("user_id");
				array.put(new JSONObject().put("name", "panda express").put("location", "downtown").put("country", "united states"));
				array.put(new JSONObject().put("name", "hongkong express").put("location", "uptown").put("country", "united states"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		
		JSONArray array = null;
		
		if (request.getParameterMap().containsKey("user_id")) {
			String userId = request.getParameter("user_id");
			array = connection.recommendRestaurants(userId);
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
