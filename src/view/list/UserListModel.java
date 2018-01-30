package view.list;

import javax.swing.DefaultListModel;

import appCore.Core;
import constants.ListTypeConstants;
import model.User;

public class UserListModel extends DefaultListModel<User>
{
	private User user;
	
	public UserListModel()
	{
		initializeUsersModel();
	}
	
	public UserListModel(int type, User user)
	{
		this.user = user;
		
		if (type == ListTypeConstants.USER_TYPE)
			initializeUsersModel();
		else if	(type == ListTypeConstants.FRIENDS_TYPE)
			initializeFriendsModel();
		else if (type == ListTypeConstants.SUGGESTED_FRIENDS)
			initializeSuggestedFriendsModel();
	}
	
	private void initializeUsersModel()
	{
		for (User u: Core.getInstance().getModel().getUsers())
		{
			addElement(u);
		}
	}
	
	private void initializeFriendsModel()
	{
		for (int i = 0; i < user.getFriends().size(); i++)
		{
			for (User u : Core.getInstance().getModel().getUsers())
			{
				if(user.getFriends().get(i) == u.getiD())
				{
					addElement(u);
				}
			}
		}
	}
	
	private void initializeSuggestedFriendsModel()
	{
		int counter = 0;
		
		for(User suggestedFriend : Core.getInstance().getModel().getUsers())
		{
			counter = 0;
			if(suggestedFriend.getiD() != user.getiD())
			{
				for(int i = 0; i < user.getFriends().size(); i++)
				{
					for(User friend : Core.getInstance().getModel().getUsers())
					{
						if(user.getFriends().get(i) == friend.getiD() && suggestedFriend.getiD() != friend.getiD())
						{
							for(int j = 0; j < friend.getFriends().size(); j++)
							{
								if(suggestedFriend.getiD() == friend.getFriends().get(j))
								{
									counter++;
									break;
								}
							}
						}
						else if(counter >= 2)
							break;
					}
					if(counter >= 2)
					{
						addElement(suggestedFriend);
						counter = 0;
						break;
					}
				}
			}
		}
	}
}
