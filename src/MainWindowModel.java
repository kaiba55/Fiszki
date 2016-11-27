public class MainWindowModel 
{
	private DataBaseOfWords base;
	
	public MainWindowModel()
	{
		try 
		{
			base=new DataBaseOfWords();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DataBaseOfWords getBase()
	{
		return base;
	}
}
