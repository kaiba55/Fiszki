import java.io.IOException;

public class AddingWordsModel 
{
	private DataBaseOfWords base;
	private Writer writer;
	
	public AddingWordsModel() throws IOException
	{
		base = new DataBaseOfWords();
		writer = new Writer();
	}
	
	public DataBaseOfWords getBase()
	{
		return base;
	}
	
	public Writer getWriter()
	{
		return writer;
	}
}
