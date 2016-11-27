import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.SwingConstants;

public class AddingWordsView extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private GroupLayout gl_panel;
	
	private JPanel contentPane;
	private JPanel panel;
	
	private JTextField textFieldInPolish;
	private JTextField textFieldInEnglish;
	
	private JLabel labelAddingWord;
	private JLabel labelInPolish;
	private JLabel labelInEnglish;
	
	private JButton buttonAddWord;
	private JButton buttonBackToLearning;
	private JButton buttonManagementVocabulary;
	
	//listenery dla przyciskow
	public void addButtonToBackToLearningListener(ActionListener listenForButtonToLearning)
	{
		buttonBackToLearning.addActionListener(listenForButtonToLearning);
	}
	
	public void addButtonAddWordListener(ActionListener listenForButtonAddWord)
	{
		buttonAddWord.addActionListener(listenForButtonAddWord);
	}
	
	public void addButtonManagementVocabularyListener(ActionListener listenForButtonManagementVocabulary)
	{
		buttonManagementVocabulary.addActionListener(listenForButtonManagementVocabulary);
	}
	
	//obsluga textfield
	public String getTextFieldInPolish()
	{
		return textFieldInPolish.getText();
	}
	
	public String getTextFieldInEnglish()
	{
		return textFieldInEnglish.getText();
	}
	
	public void setTextFieldInPolish(String text)
	{
		textFieldInPolish.setText(text);
	}
	
	public void setTextFieldInEnglish(String text)
	{
		textFieldInEnglish.setText(text);
	}
	
	public AddingWordsView() throws IOException 
	{
		//ogolne ustawienia okna
		setVisible(true);
		setTitle("Dodaj slowko");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//inicjalizacja paneli i layouta
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		
		//inicjalizacja labeli
		labelAddingWord = new JLabel("Dodaj s\u0142\u00F3wko do bazy");
		labelInPolish = new JLabel("Po polsku:");
		labelInPolish.setHorizontalAlignment(SwingConstants.CENTER);
		labelInEnglish = new JLabel("Po angielsku:");
		labelInEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		
		//inicjalizacja textfieldow
		textFieldInPolish = new JTextField();
		textFieldInPolish.setColumns(10);
		textFieldInEnglish = new JTextField();
		textFieldInEnglish.setColumns(10);
		
		//inicjalizacja buttonow
		buttonAddWord = new JButton("Dodaj");
		buttonBackToLearning = new JButton("Nauka");
		buttonManagementVocabulary = new JButton("Zarz\u0105dzanie has\u0142ami");
		
		//dodanie wszystkich elementow do grouplayouta
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(164)
							.addComponent(labelAddingWord))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addComponent(buttonAddWord, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(buttonBackToLearning)
							.addGap(28)
							.addComponent(buttonManagementVocabulary)))
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(labelInPolish, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(textFieldInPolish))
					.addGap(67)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelInEnglish, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
						.addComponent(textFieldInEnglish))
					.addGap(97))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(labelAddingWord)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelInEnglish, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelInPolish))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldInPolish, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldInEnglish, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonAddWord, Alignment.TRAILING)
						.addComponent(buttonBackToLearning, Alignment.TRAILING)
						.addComponent(buttonManagementVocabulary, Alignment.TRAILING))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
