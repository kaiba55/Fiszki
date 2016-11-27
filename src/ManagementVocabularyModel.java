import java.util.Vector;

public class ManagementVocabularyModel 
{
	private DataBaseOfWords base;
	private Writer writer;
	private Reader reader;
	private int numberOfIndex;
	private Vector <Vector<String>>rowData;
	private Vector <String>columnNames;
	
	public Vector<Vector<String>> getRowData()
	{
		return rowData;
	}
	
	public Vector<String> getColumnNames()
	{
		return columnNames;
	}
	
	void preparingColumnNames()
	{
		if(columnNames==null)
			columnNames=new Vector<String>();
		columnNames.add("id");
		columnNames.add("Polski");
		columnNames.add("Angielski");
	}
	
	void preparingMatrix()
	{
		if(rowData==null)
			rowData=new Vector<Vector<String>>();
		
		for(int i=0;i<base.getListOfWords().size();i++)
		{
			Vector<String> list=new Vector<String>();
			list.add(Integer.toString(i));
			list.add(base.getListOfWords().get(i).getInPolish());
			list.add(base.getListOfWords().get(i).getInEnglish());
			rowData.add(list);
		}
	}
	
	void preparingTable()
	{
		preparingColumnNames();
		preparingMatrix();			
	}
	
	public ManagementVocabularyModel()
	{
		base=new DataBaseOfWords();
		writer=new Writer();
		reader=new Reader();
		preparingTable();
	}
	
	public DataBaseOfWords getBase()
	{
		return base;
	}
	
	public Writer getWriter()
	{
		return writer;
	}
	
	public Reader getReader()
	{
		return reader;
	}
	
	public int getNumberOfIndex()
	{
		return numberOfIndex;
	}
	
	public void setNumberOfIndex(int numberOfIndex)
	{
		this.numberOfIndex=numberOfIndex;
	}
}
