import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class AddingWordsController 
{
	private AddingWordsModel model;
	private AddingWordsView view;
	
	public AddingWordsController(AddingWordsModel model,AddingWordsView view)
	{
		this.model=model;
		this.view=view;
		this.view.addButtonAddWordListener(new ButtonAddWordListener());
		this.view.addButtonToBackToLearningListener(new ButtonBackToLearningListener());	
		this.view.addButtonManagementVocabularyListener(new ButtonManagementVocabularyListener());
	}
	
	public String normalizingWord(String word)
	{
		word=word.toLowerCase();
		word=word.replace(" ", "");
		return word;
	}
	
	//listenery dla przyciskow
	class ButtonAddWordListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(!(view.getTextFieldInPolish().equals("") || view.getTextFieldInEnglish().equals("")))
				try 
				{
					//zapis nowego s³ówka do pliku
					model.getWriter().openingStream();
					model.getWriter().getWriterPolish().write(normalizingWord(view.getTextFieldInPolish()));
					model.getWriter().getWriterPolish().write("\r\n");
					model.getWriter().getWriterEnglish().write(normalizingWord(view.getTextFieldInEnglish()));
					model.getWriter().getWriterEnglish().write("\r\n");
					model.getWriter().closingStream();
				    JOptionPane.showMessageDialog(null, "Slowko zostalo poprawnie dodane do bazy","Dodane", JOptionPane.INFORMATION_MESSAGE);
				    view.setTextFieldInEnglish("");
				    view.setTextFieldInPolish("");
				} 
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			else
			{
				JOptionPane.showMessageDialog(null, "Uzupe³nij wszystkie pola !","Nieuzupe³nione pola w formularzu", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
	}
	
	class ButtonBackToLearningListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			view.dispose();
			new MainWindowController(new MainWindowModel(), new MainWindowView());	
		}		
	}
	
	class ButtonManagementVocabularyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{	
			try 
			{
				view.dispose();
				ManagementVocabularyModel model=new ManagementVocabularyModel();
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
