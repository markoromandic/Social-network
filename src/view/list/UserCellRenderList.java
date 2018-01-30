package view.list;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import constants.AppConstants;
import model.User;

public class UserCellRenderList extends DefaultListCellRenderer
{
	private JLabel lbUser; 
	private Color textSelectionColor = Color.BLACK;
	private Color backgroundSelectionColor = new Color(204, 224, 255);
	private Color textNonSelectionColor = Color.BLACK;
	private Color backgroundNonSelectionColor = Color.WHITE;
	
	public UserCellRenderList()
	{
		lbUser = new JLabel();
		lbUser.setOpaque(true);
		
		ImageIcon userIcon = new ImageIcon(AppConstants.USER_ICON);
		Image userConverter = userIcon.getImage();
		userConverter = userConverter.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		userIcon = new ImageIcon(userConverter);
		
		lbUser.setIcon(userIcon);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		User user = (User)value;
		
		lbUser.setText(user.toString());
		
		if (isSelected)
		{
			lbUser.setBackground(backgroundSelectionColor);
			lbUser.setForeground(textSelectionColor);
        } 
		else 
		{
			lbUser.setBackground(backgroundNonSelectionColor);
			lbUser.setForeground(textNonSelectionColor);
        }
		
		return lbUser;
	}
}
