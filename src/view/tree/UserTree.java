package view.tree;

import javax.swing.JTree;

import constants.TreeTypeConstants;
import model.User;

public class UserTree extends JTree
{
	private User user;
	private int type;
	private UserTreeModel userTreeModel;
	
	public UserTree(int type, User user)
	{
		this.user = user;
		this.type = type;
		
		if(type == TreeTypeConstants.FRIENDS_OF_FRIENDS)
			initializeFreindsOfFriends();
	}
	
	private void initializeFreindsOfFriends()
	{
		setCellRenderer(new UserCellRenderTree());
		userTreeModel = new UserTreeModel(null, type, user);
		setModel(userTreeModel);
		setRootVisible(false);
	}
}
