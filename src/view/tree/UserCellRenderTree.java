package view.tree;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import constants.AppConstants;
import model.User;

public class UserCellRenderTree extends DefaultTreeCellRenderer
{
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		
		Component renderer = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		
		if (node.getUserObject() instanceof User)
			generateIcon(value.toString());
		
		return renderer;
	}
	
	private void generateIcon(String name)
	{
		ImageIcon userIcon = new ImageIcon(AppConstants.USER_ICON);
		Image icon = userIcon.getImage();
		icon = icon.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		
		userIcon = new ImageIcon(icon);
		
		setText(name);
		setIcon(userIcon);
	}
}
