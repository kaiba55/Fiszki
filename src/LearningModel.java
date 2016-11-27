import java.io.IOException;
import java.util.Random;

public class LearningModel 
{
	private DataBaseOfWords base;
	private boolean onlyPolishVocabulary;
	private boolean onlyEnglishVocabulary;
	private boolean randomingUniqueWord;
	private boolean randomingPolishAndEnglish;
	private Random generator;
	private int nrWord;
	
	public LearningModel(boolean onlyPolishVocabulary,boolean onlyEnglishVocabulary,boolean randomingUniqueWord) throws IOException
	{
		this.onlyPolishVocabulary=onlyPolishVocabulary;
		this.onlyEnglishVocabulary=onlyEnglishVocabulary;
		this.randomingUniqueWord=randomingUniqueWord;
		
		//losowanie slowek zarowno polskich jak i angielskich
		if(onlyPolishVocabulary && onlyEnglishVocabulary)
		{
			randomingPolishAndEnglish=true;
		}
				
		base=new DataBaseOfWords();
		generator=new Random();
		nrWord=generator.nextInt(base.getListOfWords().size());
	}
	
	public DataBaseOfWords getBase()
	{
		return base;
	}
	
	public boolean getOnlyPolishVocabulary()
	{
		return onlyPolishVocabulary;
	}
	
	public boolean getOnlyEnglishVocabulary()
	{
		return onlyEnglishVocabulary;
	}
		
	public boolean getRandomingUniqueWord()
	{
		return randomingUniqueWord;
	}
	
	public int getNrWord()
	{
		return nrWord;
	}
	
	public void setNrWord (int nrWord)
	{
		this.nrWord=nrWord;
	}
	
	public Random getGenerator()
	{
		return generator;
	}
	
	public boolean getRandomingPolishAndEnglish()
	{
		return randomingPolishAndEnglish;
	}
	
	public void randomingPolishAndEnglishVocabulary()
	{
		onlyPolishVocabulary=generator.nextBoolean();
		onlyEnglishVocabulary=!onlyPolishVocabulary;
	}
	
}
