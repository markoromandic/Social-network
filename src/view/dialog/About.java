package view.dialog;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import constants.AppConstants;
import net.miginfocom.swing.MigLayout;
import view.View;

@SuppressWarnings("serial")
public class About extends JDialog
{
	private JLabel lbInfo, lbAuthor, lbIcon;
	private View view;
	
	public About(View view)
	{
		this.view = view;
		initialize();
	}
	
	private void initialize()
	{
		MigLayout migLayout = new MigLayout();
		
		setLayout(migLayout);
		
		ImageIcon iconNotResized = new ImageIcon(AppConstants.SOCIAL_NETWORK_ICON);
		Image iconConverter = iconNotResized.getImage();
		iconConverter = iconConverter.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		setIconImage(iconConverter);
		
		lbIcon = new JLabel();
		
		lbInfo = new JLabel(AppConstants.INFO);
		lbAuthor = new JLabel(AppConstants.AUTHOR);
		
		ImageIcon logo = new ImageIcon(AppConstants.SOCIAL_NETWORK_ICON);
		Image logoConverter = logo.getImage();
		logoConverter = logoConverter.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		logo = new ImageIcon(logoConverter);
		lbIcon = new JLabel(logo);
		
		getContentPane().add(lbIcon, "split2");
		getContentPane().add(lbInfo, "wrap");
		getContentPane().add(lbAuthor, "tag right");
		
		setTitle(AppConstants.ABOUT_SOCIAL_NETWORK_TITLE);
		setLocationRelativeTo(view);
		setModal(true);
		pack();
		setResizable(false);
		setVisible(true);
	}
}
