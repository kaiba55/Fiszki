import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader
{
	private File filePolish;
	private File fileEnglish;
	
	private FileReader readerPolish;
	private FileReader readerEnglish;
	
	//bufferedreader use filereader
	BufferedReader bufferedReaderPolish;
	BufferedReader bufferedReaderEnglish;
	
	public Reader() 
	{
		filePolish=new File("polski.txt");
		fileEnglish=new File("angielski.txt");
		
		if(!filePolish.isFile())
		{	
			try 
			{
				filePolish.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}			
		}
		
		if(!fileEnglish.isFile())
		{
			try 
			{
				fileEnglish.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}				
		}
		
		try 
		{
			readerPolish = new FileReader(filePolish);
			readerEnglish=new FileReader(fileEnglish);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		bufferedReaderPolish = new BufferedReader(readerPolish);
		bufferedReaderEnglish = new BufferedReader(readerEnglish);

	}
	
	public void closingStream()
	{
		try 
		{
			readerPolish.close();
			readerEnglish.close();
			bufferedReaderPolish.close();
			bufferedReaderEnglish.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	public FileReader getReaderPolish()
	{
		return readerPolish;
	}
	
	public FileReader getReaderEnglish()
	{
		return readerEnglish;
	}
	
	public void openingStream()
	{
		try 
		{
			readerPolish = new FileReader(filePolish);
			readerEnglish=new FileReader(fileEnglish);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		bufferedReaderPolish = new BufferedReader(readerPolish);
		bufferedReaderEnglish = new BufferedReader(readerEnglish);
	}
	
	public void deletingFiles()
	{
		filePolish.delete();
		filePolish.delete();
		filePolish=new File("polski.txt");
		fileEnglish=new File("angielski.txt");
	}
	
	
	public BufferedReader getBufferedReaderPolish()
	{
		return bufferedReaderPolish;
	}
	
	public BufferedReader getBufferedReaderEnglish()
	{
		return bufferedReaderEnglish;
	}
}
