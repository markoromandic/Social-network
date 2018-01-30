package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

import appCore.Core;
import constants.AppConstants;
import model.User;

public class LogIn extends MouseAdapter implements ActionListener, KeyListener
{
	@Override
	public void mouseClicked(MouseEvent e)
	{
		super.mouseClicked(e);
		
		if(e.getClickCount() == 2)
		{
			JList theList = (JList) e.getSource();
			
			int index = theList.locationToIndex(e.getPoint());
	
			User user = (User)theList.getModel().getElementAt(index);
			
			Core.getInstance().getView().setUserPanelToView(user);
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyPressedNum = e.getKeyCode();
		String keyChar = KeyEvent.getKeyText(keyPressedNum);
		
		if(keyChar.equals(AppConstants.ENTER))
		{
			User u = Core.getInstance().getView().getHomePanel().getSelectedItem();
			
			if(u != null)
				Core.getInstance().getView().setUserPanelToView(u);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		User u = Core.getInstance().getView().getHomePanel().getSelectedItem();
		
		if(u != null)
			Core.getInstance().getView().setUserPanelToView(u);
	}
}
