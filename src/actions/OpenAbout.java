package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import appCore.Core;
import constants.AppConstants;

public class OpenAbout extends AbstractEditorAction
{
	public OpenAbout()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
		putValue(NAME, AppConstants.ABOUT_TITLE);
		putValue(SMALL_ICON, loadIcon(AppConstants.ABOUT_ICON)); 
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Core.getInstance().getView().openAbout();
	}
}
