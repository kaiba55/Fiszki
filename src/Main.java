import java.io.IOException;

public class Main 
{
	static public void main(String args[]) throws IOException
	{
		new MainWindowController(new MainWindowModel(), new MainWindowView());
	}	
}
