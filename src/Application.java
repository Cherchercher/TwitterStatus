import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.*;
import twitter4j.conf.*;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONObject;

public class Application extends HttpServlet {
	public static void main(String[] args) {};
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
	
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setOAuthConsumerKey("YHiNz5KSS7C83xWRiZCiqT9qU");
    cb.setOAuthConsumerSecret("0c93lXa71gfZMQmOkpWWrBeIkr6KrWRCwLuJtpXmrvgfaJaASS");
    cb.setOAuthAccessToken("3239606863-jPSacglPRGMBHqJdKq0Jcfhm2NFtmVPPNT7eGYn");
    cb.setOAuthAccessTokenSecret("Fx1v4Si0jVYqwIQmr7RIvSCzbheuc5DXxzw0GWAoy7DiY");

    Twitter twitter = new TwitterFactory(cb.build()).getInstance();
    PrintWriter out= response.getWriter();
    response.setContentType("text/html");  
    String userScreenName = request.getParameter("screenName");
    try {
    	    List<Status> statuses;
    	    statuses = twitter.getUserTimeline(userScreenName); 
    	    User user = twitter.showUser(userScreenName);
    	    int numOfFavorites  = user.getFavouritesCount();  
    	    int numOfFollowers  = user.getFollowersCount();     	   
    	    int numOfFriends  = user.getFriendsCount();
    	    Date createdAt  = user.getCreatedAt();
    	    int numOfUpdates  = user.getStatusesCount();
    	 
    	    String userLocation  = user.getLocation();
    	    
    	    String profilePic  = user.getBiggerProfileImageURL();

    	    		 
        JSONObject obj = new JSONObject();
   		obj.put("user", userScreenName);
   		obj.put("screenName", userScreenName);
	obj.put("createdAt", createdAt);
	obj.put("numOfFavorites", numOfFavorites);
	obj.put("numOfFriends",numOfFriends);
	obj.put("numOfFollowers",numOfFollowers);
	obj.put("numOfUpdates", numOfUpdates);
	obj.put("userLocation", userLocation);
	obj.put("profilePic", profilePic);
	
	 
	JSONArray gjson = new JSONArray();
	for (Status status : statuses) {
		
		JSONObject gobj = new JSONObject();
	      	gobj.put("userScreen", "@"+status.getUser().getScreenName());
	      	gobj.put("statusText",status.getText());
	      	gobj.put("hashtags", status.getHashtagEntities());
	      	gobj.put("createdAt", status.getCreatedAt());
	      	gobj.put("favoritesCount", status.getFavoriteCount());
	      	gobj.put("RetweetsCount", status.getRetweetCount());
	      	
	      	gjson.put(gobj);

	}
		 		obj.put("tweets", gjson);
		 		out.print(obj.toString());
       
     
       }  
    catch(TwitterException e) {
           
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
           e.printStackTrace();
           out.println("Failed to get timeline: "+ e.getMessage());
           rd.include(request, response);
            }
 out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws IOException, ServletException
		{
		    		doGet(request, response);
		 }
}