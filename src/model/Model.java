package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import constants.AppConstants;
import constants.JsonConstants;

public class Model
{
	private ArrayList<User> users;
	
	public Model()
	{
		initialize();
	}
	
	private void initialize()
	{
		loadFromDatabase();
	}
	
	private void loadFromDatabase()
	{
		BufferedReader br;
		
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(AppConstants.DATABASE_LOCATION))));
		
			JSONTokener tokener = new JSONTokener(br);
			JSONObject o = new JSONObject(tokener);
			
			br.close();
			
			JSONArray usersJArray = o.getJSONArray(JsonConstants.USERS);
			users = new ArrayList<>();
			
			for(int i = 0; i < usersJArray.length(); i++)
			{
				JSONObject curObject = usersJArray.getJSONObject(i);
				
				User u = new User();
				
				u.setiD(curObject.getLong(JsonConstants.ID));
				u.setFirstName(curObject.optString(JsonConstants.FIRST_NAME));
				u.setSurname(curObject.optString(JsonConstants.SURNAME));
				u.setAge(curObject.optInt(JsonConstants.AGE));
				u.setGender(curObject.optString(JsonConstants.GENDER));
				
				JSONArray friends = curObject.optJSONArray(JsonConstants.FRIENDS);
				
				ArrayList<Integer> userFriends = new ArrayList<>();
				
				for(int j = 0; j < friends.length(); j++)
				{
					userFriends.add(friends.getInt(j));
				}
				
				u.setFriends(userFriends);
				
				users.add(u);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			System.out.println(AppConstants.DATABASE_LOADED);
		}
	}

	public ArrayList<User> getUsers()
	{
		return users;
	}
}
