package view.menuBar;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar
{
	private MenuFile menuFile;
	private MenuAbout menuAbout;
	
	public MenuBar()
	{
		initialize();
	}
	
	private void initialize()
	{
		menuFile = new MenuFile();
		menuAbout = new MenuAbout();
		
		add(menuFile);
		add(menuAbout);
	}
	
}
