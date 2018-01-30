package view.list;

import javax.swing.BorderFactory;
import javax.swing.JList;

import appCore.Core;
import constants.ListTypeConstants;
import model.User;

public class UserList extends JList<User>
{
	private UserListModel userListModel = null;
	private int type;
	private User user;
	
	public UserList()
	{
		initializeUserList();
	}
	
	public UserList(int type, User user)
	{
		this.type = type;
		this.user = user;
		
		if(type == ListTypeConstants.USER_TYPE)
			initializeUserList();
		else if(type == ListTypeConstants.FRIENDS_TYPE)
			initializeFriendsList();
		else if(type == ListTypeConstants.SUGGESTED_FRIENDS)
			initializeSuggestedFriendsList();
	}
	
	private void initializeUserList()
	{
		setCellRenderer(new UserCellRenderList());
		setBorder(BorderFactory.createEmptyBorder());
		userListModel = new UserListModel();
		setModel(userListModel);
		
		addKeyListener(Core.getInstance().getActionManager().getLogIn());
		addMouseListener(Core.getInstance().getActionManager().getLogIn());
	}
	
	private void initializeFriendsList()
	{
		setCellRenderer(new UserCellRenderList());
		setBorder(BorderFactory.createEmptyBorder());
		userListModel = new UserListModel(type, user);
		setModel(userListModel);
	}
	
	private void initializeSuggestedFriendsList()
	{
		setCellRenderer(new UserCellRenderList());
		setBorder(BorderFactory.createEmptyBorder());
		userListModel = new UserListModel(type, user);
		setModel(userListModel);
	}
	
}
