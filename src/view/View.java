package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import constants.AppConstants;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.dialog.About;
import view.menuBar.MenuBar;

public class View extends JFrame
{
	private MenuBar menuBar;
	private HomePanel homePanel;
	private UserPanel userPanel;
	
	boolean isU;
	
	public View()
	{
		initialize();
	}
	
	private void initialize()
	{
		isU = false;
		
		MigLayout mg = new MigLayout();
	
		setLayout(mg);
		setTitle(AppConstants.APP_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon iconNotResized = new ImageIcon(AppConstants.SOCIAL_NETWORK_ICON);
		Image iconConverter = iconNotResized.getImage();
		iconConverter = iconConverter.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		setIconImage(iconConverter);
		
		setMinimumSize(new Dimension(400, 425));
		
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		homePanel = new HomePanel();
		
		getContentPane().add(homePanel,  "push, grow");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		
		pack();
		
		setVisible(true);
	}

	public HomePanel getHomePanel()
	{
		return homePanel;
	}
	
	public void setUserPanelToView(User user)
	{
		isU = true;
		
		userPanel = new UserPanel(user, this);
		
		setContentPane(userPanel);
//		getContentPane().removeAll();
//		getContentPane().add(userPanel, "push, grow");
		revalidate();
		validate();
	}
	
	public void setHomePanelToView()
	{
		isU = false;
		refreshMenuBar();
		setTitle(AppConstants.APP_TITLE);
		setContentPane(homePanel);
		revalidate();
		validate();
		
		userPanel.removeAll();
		userPanel = null;
	}
	
	public void refreshMenuBar()
	{
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
	}
	
	public void openAbout()
	{
		About about = new About(this);
	}

	public boolean isU()
	{
		return isU;
	}
}
