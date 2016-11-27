import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LearningController 
{
	private LearningModel model;
	private LearningView view;
	
	public LearningController(LearningModel model, LearningView view)
	{
		this.model=model;
		this.view=view;
		this.view.addButtonCheckAnswerListener(new buttonCheckAnswerListener());
		this.view.addButtonDisplayingAnswerListener(new buttonDisplayingAnswerListener());
		this.view.addButtonFinishLearningListener(new buttonFinishLearningListener());
		this.view.addButtonNextWordListener(new buttonNextWordListener());
		
		//pierwsze losowanie hasel
		if(model.getOnlyEnglishVocabulary())
		{
			view.setLabelYourWordToTranslating(model.getBase().getListOfWords().get(model.getNrWord()).getInEnglish());
		}
		
		if(model.getOnlyPolishVocabulary())
		{
			view.setLabelYourWordToTranslating(model.getBase().getListOfWords().get(model.getNrWord()).getInPolish());
		}
		
		if(model.getRandomingPolishAndEnglish())
		{
			model.randomingPolishAndEnglishVocabulary();
		}
		//wyswietlenie liczby slowek w bazie
		view.setLabelNumberWordsInDatabase("IloúÊ s≥Ûwek w bazie: "+model.getBase().getListOfWords().size());
	}
	
	//obsluga listenerow dla przyciskow
	class buttonFinishLearningListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			view.dispose();
			new MainWindowController(new MainWindowModel(),new MainWindowView());
		}
		
	}
	
	class buttonCheckAnswerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(model.getOnlyPolishVocabulary())
			{
				if(view.getTextFieldWritingWord().equals(model.getBase().getListOfWords().get(model.getNrWord()).getInEnglish()))
				{
					view.setLabelYourAnswer("Poprawna odpowiedü");
				}
				else
				{
					view.setLabelYourAnswer("B≥Ídna odpowiedü");
				}
			}
			
			if(model.getOnlyEnglishVocabulary())
			{
				if(view.getTextFieldWritingWord().equals(model.getBase().getListOfWords().get(model.getNrWord()).getInPolish()))
				{
					view.setLabelYourAnswer("Poprawna odpowiedü");
				}
				else
				{
					view.setLabelYourAnswer("B≥Ídna odpowiedü");
				}
			}
		}
		
	}
	
	class buttonDisplayingAnswerListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			if(model.getOnlyPolishVocabulary())
			{
				view.setLabelCorrectAnswer(model.getBase().getListOfWords().get(model.getNrWord()).getInEnglish());
			}
			
			if(model.getOnlyEnglishVocabulary())
			{
				view.setLabelCorrectAnswer(model.getBase().getListOfWords().get(model.getNrWord()).getInPolish());
			}	
		}
		
	}
	
	public void randomingUniqueWords()
	{
		if(model.getRandomingUniqueWord())
		{
			model.getBase().getListOfWords().remove(model.getNrWord());
		}
		
	}
	
	public boolean noWords()
	{
		return model.getBase().getListOfWords().size()==0;
	}
	
	public void randomingWord()
	{
		model.setNrWord(model.getGenerator().nextInt(model.getBase().getListOfWords().size()));
		
		//obsluga faktu ze losujemy zarowno polskie i angielskie
		if(model.getRandomingPolishAndEnglish())
		{
			model.randomingPolishAndEnglishVocabulary();
		}
	
		if(model.getOnlyPolishVocabulary())
		{
			view.setLabelYourWordToTranslating(model.getBase().getListOfWords().get(model.getNrWord()).getInPolish());
		}
	
		if(model.getOnlyEnglishVocabulary())
		{
			view.setLabelYourWordToTranslating(model.getBase().getListOfWords().get(model.getNrWord()).getInEnglish());
		}
	}
	class buttonNextWordListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			view.setLabelYourAnswer("");
			view.setTextFieldWritingWord("");
			
			randomingUniqueWords();
			
			if(noWords())
			{
				view.dispose();
				new TheEndController(new TheEndModel(),new TheEndView());
			}
			else
			{
				randomingWord();
				view.setLabelNumberWordsInDatabase("IloúÊ s≥Ûwek w bazie: "+model.getBase().getListOfWords().size());
				view.setLabelCorrectAnswer("");
			}
		}
		
	}
	
}
