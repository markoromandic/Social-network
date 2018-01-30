package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.AppConstants;

public class Exit extends AbstractEditorAction
{
	public Exit()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		putValue(NAME, AppConstants.EXIT);
		putValue(SMALL_ICON, loadIcon(AppConstants.EXIT_ICON)); 
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
}
