import java.io.IOException;
import java.util.ArrayList;

public class DataBaseOfWords 
{
	private ArrayList<Word> listOfWords;
	private Reader reader;
	
	public DataBaseOfWords()
	{
		listOfWords=new ArrayList<Word>();
		reader=new Reader();
		fillDatabase();
	}
	
	public void fillDatabase()
	{
		String polishWord = "";
		String englishWord = "";

		// ODCZYT KOLEJNYCH LINII Z PLIKU:
		reader.openingStream();
		try 
		{
			while(((polishWord = reader.getBufferedReaderPolish().readLine()) != null) &&((englishWord = reader.getBufferedReaderEnglish().readLine()) != null) )
			{
				listOfWords.add(new Word(polishWord,englishWord));
			}
		}  
		catch (IOException e) 
		{
			System.out.println("B£¥D ODCZYTU Z PLIKU!");
			System.exit(2);
		}
		reader.closingStream();
	}
	
	public ArrayList<Word> getListOfWords()
	{
		return listOfWords;
	}
}
