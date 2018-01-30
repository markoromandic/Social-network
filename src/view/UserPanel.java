package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.AppConstants;
import constants.ListTypeConstants;
import constants.TreeTypeConstants;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.list.UserList;
import view.tree.UserTree;

public class UserPanel extends JPanel
{
	private JLabel lbName, lbSurname, lbAge, lbGender;
	private User user;
	private UserList lsFriendsList, lcSuggestedFreind;
	private UserTree tFriendsOfFriends;
	private View view;
	
	public UserPanel(User user, View view)
	{
		this.view = view;
		this.user = user;
		initialize();
	}
	
	private void initialize()
	{
		MigLayout migLayout = new MigLayout();
		MigLayout migLayoutGeneralInfo = new MigLayout();
		
		setLayout(migLayout);
		
		JPanel generalInfo = new JPanel();
		generalInfo.setLayout(migLayoutGeneralInfo);
		generalInfo.setBorder(BorderFactory.createTitledBorder(AppConstants.GENERAL_INFO));
		
		
		lbName = new JLabel(AppConstants.FIRST_NAME_LABEL + user.getFirstName());
		lbSurname = new JLabel(AppConstants.SURNAME_LABEL + user.getSurname());
		if (user.getAge() == 0)
			lbAge = new JLabel(AppConstants.AGE);
		else
			lbAge = new JLabel(AppConstants.AGE + user.getAge());
		lbGender = new JLabel(AppConstants.GENDER + user.getGender());
		
		lsFriendsList = new UserList(ListTypeConstants.FRIENDS_TYPE, user);
		JScrollPane scLFriends = new JScrollPane(lsFriendsList);
		scLFriends.setBorder(BorderFactory.createTitledBorder(AppConstants.LIST_FRIENDS_TITLE));
		
		tFriendsOfFriends = new UserTree(TreeTypeConstants.FRIENDS_OF_FRIENDS, user);
		JScrollPane scTFriendsOfFriends = new JScrollPane(tFriendsOfFriends);
		scTFriendsOfFriends.setBorder(BorderFactory.createTitledBorder(AppConstants.TREE_FRIENDS_OF_FRIENDS_TITLE));
		
		lcSuggestedFreind = new UserList(ListTypeConstants.SUGGESTED_FRIENDS, user);
		JScrollPane scLSuggestedFriends = new JScrollPane(lcSuggestedFreind);
		scLSuggestedFriends.setBorder(BorderFactory.createTitledBorder(AppConstants.TREE_SUGGESTED_FRIENDS_TITLE));
		
		generalInfo.add(lbName, "sg lb, wrap");
		generalInfo.add(lbSurname, "sg lb, wrap");
		generalInfo.add(lbAge, "sg lb, wrap");
		generalInfo.add(lbGender, "sg lb");
		add(generalInfo, "push, grow, wrap");
		add(scLFriends, "sg l,push, grow, wrap");
		add(scTFriendsOfFriends, "sg l,push, grow, wrap");
		add(scLSuggestedFriends, "sg l,push, grow");
		
		view.setTitle(AppConstants.APP_TITLE_USER + user.getFirstName() + AppConstants.BLANK_SPACE + user.getSurname());
		
		view.refreshMenuBar();
		
		view.pack();
	}
}
