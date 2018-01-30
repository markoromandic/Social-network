package view.menuBar;

import javax.swing.JMenu;

import appCore.Core;
import constants.AppConstants;

public class MenuFile extends JMenu
{
	public MenuFile()
	{
		initialize();
	}
	
	private void initialize()
	{
		setText(AppConstants.MENU_FILE_TITLE);
		
		if(Core.getInstance().getView() != null)
			if(Core.getInstance().getView().isU())
			{
				add(Core.getInstance().getActionManager().getSignOut());
				addSeparator();
			}
				
		add(Core.getInstance().getActionManager().getExit());
	}
}
