import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheEndController 
{
	@SuppressWarnings("unused")
	private TheEndModel model;
	private TheEndView view;
	
	public TheEndController(TheEndModel model, TheEndView view)
	{
		this.model=model;
		this.view=view;
		this.view.addButtonToMainWindowListener(new ButtonToMainWindowListener());
	}
	
	//obsluga listenerow dla buttonow
	class ButtonToMainWindowListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			view.dispose();
			new MainWindowController(new MainWindowModel(), new MainWindowView());
		}
		
	}
}
