import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ManagementVocabularyView extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	
	private GroupLayout gl_panel;
	
	private JScrollPane scrollPane;	
	private JTable table;	
	private DefaultTableModel tableOfWords=null;
	private ListSelectionModel listSelectionOfTable;
	
	private JButton buttonAddWord;
	private JButton buttonBackToLearning;
	private JButton buttonDeleteSelected;
	private JButton buttonRemovingAllOfWords;
	
	public DefaultTableModel getTableOfWords()
	{
		return tableOfWords;
	}
	
	public void setDataAndColumnsOfTableOfWords(Vector <Object> rowData,Vector <Object>columnNames)
	{
		tableOfWords.setDataVector(rowData, columnNames);
	}
	
	public int getSelectionIndexOfTable()
	{
		return listSelectionOfTable.getMinSelectionIndex();
	}
	
	public boolean getSelectionOfTableIsEmpty()
	{
		return listSelectionOfTable.isSelectionEmpty();
	}
	
	public void addButtonDeleteSelectedListener(ActionListener listenForButtonDeleteSelected)
	{
		buttonDeleteSelected.addActionListener(listenForButtonDeleteSelected);
	}
	
	public void addButtonRemovingAllOfWords(ActionListener listenForButtonRemovingAllOfWords)
	{
		buttonRemovingAllOfWords.addActionListener(listenForButtonRemovingAllOfWords);
	}
	
	public void addButtonToLearningListener(ActionListener listenForButtonToLearning)
	{
		buttonBackToLearning.addActionListener(listenForButtonToLearning);
	}
	
	public void addButtonAddWordListener(ActionListener listenForButtonAddWord)
	{
		buttonAddWord.addActionListener(listenForButtonAddWord);		
	}
	
	public void addListSelectionTableOfWords(ListSelectionListener listenForSelectionList)
	{
		listSelectionOfTable.addListSelectionListener(listenForSelectionList);
	}
	
	public ManagementVocabularyView(Vector <Vector<String>> rowData,Vector <String>columnNames) throws IOException 
	{
		setVisible(true);
		setTitle("Zarz¹dzanie s³ówkami");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//inicjalizacja paneli
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		//wyswietlenie tabeli z haslami		
		if(tableOfWords==null)
			tableOfWords = new DefaultTableModel(rowData, columnNames);
				
		if(table==null)
			table = new JTable(tableOfWords);
		scrollPane.setViewportView(table);
		listSelectionOfTable=table.getSelectionModel();	
		
		//inicjalizacja buttonow
		buttonAddWord = new JButton("Dodaj s\u0142\u00F3wko");
		buttonDeleteSelected = new JButton("Usu\u0144 zaznaczone");
		buttonBackToLearning = new JButton("Powr\u00F3t do nauki");
		buttonRemovingAllOfWords = new JButton("Usu\u0144 wszystkie s\u0142\u00F3wka z bazy");

		//umieszczenie wszystkich elementow w grouplayout
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonBackToLearning, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(buttonAddWord, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(buttonDeleteSelected, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(buttonRemovingAllOfWords))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addComponent(buttonAddWord)
					.addGap(36)
					.addComponent(buttonDeleteSelected)
					.addGap(26)
					.addComponent(buttonRemovingAllOfWords)
					.addGap(28)
					.addComponent(buttonBackToLearning)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}

