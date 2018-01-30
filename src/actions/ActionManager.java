package actions;

import view.dialog.About;

public class ActionManager
{
	private Exit exit;
	private LogIn logIn;
	private SignOut signOut;
	private OpenAbout openAbout;
	
	public ActionManager()
	{
		initialize();
	}
	
	private void initialize()
	{
		exit = new Exit();
		logIn = new LogIn();
		signOut = new SignOut();
		openAbout = new OpenAbout();
	}

	public Exit getExit()
	{
		return exit;
	}

	public LogIn getLogIn()
	{
		return logIn;
	}

	public SignOut getSignOut()
	{
		return signOut;
	}

	public OpenAbout getOpenAbout()
	{
		return openAbout;
	}
	
}
