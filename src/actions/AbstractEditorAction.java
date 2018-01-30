package actions;

import java.awt.Image;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import constants.AppConstants;

public abstract class AbstractEditorAction extends AbstractAction
{
	public Icon loadIcon(String imageURL)
	{
		Icon icon = null;
		
		if (!imageURL.equals("")) 
		{       
			ImageIcon iconNotResized = new ImageIcon(imageURL);
			
			Image imgResizing =	iconNotResized.getImage();
			imgResizing = imgResizing.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			icon = new ImageIcon(imgResizing);
	    } 
		else 
	    {                                     
	        System.err.println(AppConstants.RESOURCE_NOT_FOUND_MESSAGE + imageURL + AppConstants.APOSTROPHE);
	    }

		return icon;
	}
}
