package view.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import appCore.Core;
import constants.TreeTypeConstants;
import model.User;

public class UserTreeModel extends DefaultTreeModel
{
	private int type;
	private User user;
	
	private DefaultMutableTreeNode userNode;
	
	public UserTreeModel(TreeNode root, int type, User user)
	{
		super(root);
		this.type = type;
		this.user = user;
		
		if(type == TreeTypeConstants.FRIENDS_OF_FRIENDS)
			initializeFreindsOfFreindsModel();
	}
	
	private void initializeFreindsOfFreindsModel()
	{
		userNode = new DefaultMutableTreeNode(user);
		
		setRoot(userNode);
		
		for (int i = 0; i < user.getFriends().size(); i++)
		{
			for (User friend : Core.getInstance().getModel().getUsers())
			{
				if(user.getFriends().get(i) == friend.getiD())
				{
					DefaultMutableTreeNode friendNode = new DefaultMutableTreeNode(friend);
					getFreindsOfFreind(friendNode, friend);
					if(friendNode.getChildCount() > 0)
						userNode.add(friendNode);
				}
			}
		}
		
	}
	
	private void getFreindsOfFreind(DefaultMutableTreeNode friendNode, User friend)
	{
		for(int j = 0; j < friend.getFriends().size(); j++)
		{
			for (User friendOfFriend : Core.getInstance().getModel().getUsers())
			{
				if(friend.getFriends().get(j) == friendOfFriend.getiD() && friendOfFriend.getiD() != user.getiD())
				{
					DefaultMutableTreeNode friendOfFreindNode = new DefaultMutableTreeNode(friendOfFriend);
					friendNode.add(friendOfFreindNode);
				}
			}
		}
	}
	

}
