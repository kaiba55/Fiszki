import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ManagementVocabularyController 
{
	private ManagementVocabularyModel model;
	private ManagementVocabularyView view;
	
	public ManagementVocabularyController (ManagementVocabularyModel model,ManagementVocabularyView view)
	{
		this.view=view;
		this.model=model;
		this.view.addButtonAddWordListener(new ButtonAddWordListener());
		this.view.addButtonDeleteSelectedListener(new ButtonDeleteSelectedListener());
		this.view.addButtonToLearningListener(new ButtonToLearningListener());
		this.view.addListSelectionTableOfWords(new ListSelectionTableOfWordsListener() );
		this.view.addButtonRemovingAllOfWords(new ButtonRemovingAllOfWordsListener());
	}
	
	//obsluga zaznaczenia wiersza tabeli
	class ListSelectionTableOfWordsListener implements ListSelectionListener
	{
		
		public void valueChanged(ListSelectionEvent e) 
		{
			if(!view.getSelectionOfTableIsEmpty())
			{
				model.setNumberOfIndex(view.getSelectionIndexOfTable());		
			}
		}
		
	}
	
	//listenery dla buttonow
	class ButtonRemovingAllOfWordsListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{		
			model.getWriter().deleteFiles();
			view.getTableOfWords().setDataVector(null, model.getColumnNames());
			JOptionPane.showMessageDialog(null, "Wszystkie slowka z bazy zostaly usuniete!","Wyczyszczono baze",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	class ButtonAddWordListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			view.dispose();
			try 
			{
				new AddingWordsController(new AddingWordsModel(),new AddingWordsView());
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
	}
	
	class ButtonDeleteSelectedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JOptionPane.showMessageDialog(null, "S³ówko:"+model.getBase().getListOfWords().get(model.getNumberOfIndex()).getInPolish()+" zosta³o poprawnie usuniête z bazy","Usuniêto s³ówko",JOptionPane.INFORMATION_MESSAGE);
			
			//usuwamy slowko z bazy i nowa baze zapisujemy do plikow
			model.getBase().getListOfWords().remove(model.getNumberOfIndex());
			view.getTableOfWords().removeRow(model.getNumberOfIndex());
			
			model.getWriter().deleteFiles();
			
			for(int i=0;i<model.getBase().getListOfWords().size();i++)
			{
				try 
				{					
					model.getWriter().getWriterPolish().write(model.getBase().getListOfWords().get(i).getInPolish());
					model.getWriter().getWriterPolish().write("\r\n");
					model.getWriter().getWriterEnglish().write(model.getBase().getListOfWords().get(i).getInPolish());
					model.getWriter().getWriterEnglish().write("\r\n");					
				} 
				catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			model.getWriter().closingStream();
		}
	}
	
	class ButtonToLearningListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			view.dispose();
			new MainWindowController(new MainWindowModel(),new MainWindowView());		
		}
	}
	
}
