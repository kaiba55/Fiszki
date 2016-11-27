import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer 
{
	private File filePolish;
	private File fileEnglish;
	
	private FileWriter writerPolish;
	private FileWriter writerEnglish;
	
	public Writer()
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
	}
	
	public void openingStream() 
	{
		try 
		{
			writerPolish = new FileWriter(filePolish,true);
			writerEnglish=new FileWriter(fileEnglish,true);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void deleteFiles() 
	{
		try 
		{
			writerPolish = new FileWriter(filePolish);
			writerEnglish=new FileWriter(fileEnglish);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closingStream() 
	{
		try 
		{
			writerPolish.close();
			writerEnglish.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public File getF1()
	{
		return filePolish;
	}
	
	public File getF2()
	{
		return fileEnglish;
	}
	
	public FileWriter getWriterPolish()
	{
		return writerPolish;
	}
	
	public FileWriter getWriterEnglish()
	{
		return writerEnglish;
	}
}
