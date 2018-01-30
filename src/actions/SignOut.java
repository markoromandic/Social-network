package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import appCore.Core;
import constants.AppConstants;

public class SignOut extends AbstractEditorAction
{
	public SignOut()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon(AppConstants.SIGN_OUT_ICON)); 
		putValue(NAME, AppConstants.SIGN_OUT);
		putValue(SHORT_DESCRIPTION, AppConstants.SIGN_OUT_DESCRIPTION);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Core.getInstance().getView().setHomePanelToView();
	}
}
