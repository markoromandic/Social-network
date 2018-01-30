package model;

import java.util.ArrayList;

import constants.AppConstants;

public class User
{
	private long iD = -1;
	private String firstName;
	private String surname;
	private int age;
	private String gender;
	private ArrayList<Integer> friends;
	
	public User(long iD, String firstName, String surname, int age, String gender, ArrayList<Integer> friends)
	{
		this.iD = iD;
		this.firstName = firstName;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.friends = friends;
	}
	
	public User()
	{
		friends = new ArrayList<>();
	}

	public long getiD()
	{
		return iD;
	}

	public void setiD(long iD)
	{
		this.iD = iD;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public ArrayList<Integer> getFriends()
	{
		return friends;
	}

	public void setFriends(ArrayList<Integer> friends)
	{
		this.friends = friends;
	}

	@Override
	public String toString()
	{
		return firstName + AppConstants.BLANK_SPACE + surname;
	}

	
}
