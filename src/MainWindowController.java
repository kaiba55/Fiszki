import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MainWindowController 
{
	private MainWindowModel model;
	private MainWindowView view;
	
	public MainWindowController(MainWindowModel model, MainWindowView view)
	{
		this.model=model;
		this.view=view;
		this.view.addButtonLearningListener(new ButtomLearningListener());
		this.view.addButtonManagementVocabularyListener(new ButtonManagementVocabularyListener());
	}
	
	public boolean noWords()
	{
		return model.getBase().getListOfWords().size()==0;
	}
	
	public void choosingLanguageWords() throws IOException
	{
		if(view.getCheckBoxRandomingPolishIsSelected() ||view.getCheckBoxRandomingEnglishIsSelected())
		{
			view.dispose();
			LearningModel model=new LearningModel(view.getCheckBoxRandomingPolishIsSelected(),view.getCheckBoxRandomingEnglishIsSelected(),view.getCheckBoxNotRepeatingIsSelected());		
			new LearningController(model, new LearningView());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Zaznacz czy chcesz losowaæ s³ówka po polsku czy po angielsku, b¹dŸ w obu jêzykach","Zaznacz odpowiednie opcje",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	//obsluga listenerow dla przyciskow
	class ButtomLearningListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				if(noWords())
				{
					JOptionPane.showMessageDialog(null,"Baza slowek jest pusta, dodaj slowka do bazy !");
				}
				else
				{	
					choosingLanguageWords();
				};
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		}	
	}
	
	class ButtonManagementVocabularyListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			view.dispose();
			try 
			{
				ManagementVocabularyModel model = new ManagementVocabularyModel();
				ManagementVocabularyView view=new ManagementVocabularyView(model.getRowData(),model.getColumnNames());
				new ManagementVocabularyController(model,view);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		
	}
}
