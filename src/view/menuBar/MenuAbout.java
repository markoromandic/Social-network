package view.menuBar;

import javax.swing.JMenu;

import appCore.Core;
import constants.AppConstants;

public class MenuAbout extends JMenu
{
	public MenuAbout()
	{
		initialize();
	}
	
	private void initialize()
	{
		setText(AppConstants.MENU_ABOUT_TITLE);
		
		add(Core.getInstance().getActionManager().getOpenAbout());
	}
}
