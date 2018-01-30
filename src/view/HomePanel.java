package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import appCore.Core;
import constants.AppConstants;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.list.UserList;

public class HomePanel extends JPanel
{
	private UserList userList;
	private JButton btLogIn;
	
	public HomePanel()
	{
		initialize();
	}
	
	private void initialize()
	{
		MigLayout mg = new MigLayout();
	
		setLayout(mg);
		
		userList = new UserList();
		JScrollPane scUser = new JScrollPane(userList);
		scUser.setBorder(BorderFactory.createTitledBorder(AppConstants.LIST_USERS_TITLE));
		
		btLogIn = new JButton(AppConstants.LOG_IN);
		btLogIn.addActionListener(Core.getInstance().getActionManager().getLogIn());
		
		add(scUser, "push, grow, wrap");
		add(btLogIn, "tag right");
	}
	
	public User getSelectedItem()
	{
		return userList.getSelectedValue();
	}
}
