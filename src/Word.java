public class Word 
{
	private String inPolish;
	private String inEnglish;
	
	Word(String inPolish, String inEnglish)
	{
		this.inPolish=inPolish;
		this.inEnglish=inEnglish;
	}
	
	public String getInPolish()
	{
		return inPolish;
	}
	
	public String getInEnglish()
	{
		return inEnglish;
	}
	
	public void setInPolish(String inPolish)
	{
		this.inPolish=inPolish;
	}
	
	public void setInEnglish(String inEnglish)
	{
		this.inEnglish=inEnglish;
	}
	
}
