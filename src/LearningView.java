import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class LearningView extends JFrame 
{
	private static final long serialVersionUID = 6745920673186303890L;
	private JPanel contentPane;
	private JPanel panel ;
	private JPanel panel_1;
	
	private GroupLayout gl_panel ;
	private GroupLayout gl_panel_1;
	
	private JButton buttonFinishLearning;
	private JButton buttonCheckAnswer;
	private JButton buttonDisplayingAnswer;
	private JButton buttonNextWord;
	
	private JLabel labelYourWordToTranslating;
	private JLabel labelCorrectAnswer;
	private JLabel labelYourAnswer;
	private JLabel labelTranslatingYourWord;
	private JLabel labelYourWordToTranslate;
	private JLabel labelNumberWordsInDatabase ;
	
	private JTextField textFieldWritingWord;
	
	//dodanie listenerow dla przyciskow
	public void addButtonFinishLearningListener(ActionListener buttonFinishLearningListener)
	{
		buttonFinishLearning.addActionListener(buttonFinishLearningListener);
	}
	
	public void addButtonCheckAnswerListener(ActionListener buttonCheckAnswerListener)
	{
		buttonCheckAnswer.addActionListener(buttonCheckAnswerListener);
	}
	
	public void addButtonDisplayingAnswerListener(ActionListener buttonDisplayingAnswerListener)
	{
		buttonDisplayingAnswer.addActionListener(buttonDisplayingAnswerListener);
	}
	
	public void addButtonNextWordListener(ActionListener buttonNextWordListener)
	{
		buttonNextWord.addActionListener(buttonNextWordListener);
	}
	
	//obsluga textfieldow
	public String getTextFieldWritingWord()
	{
		return textFieldWritingWord.getText();
	}
	
	public void setTextFieldWritingWord(String text)
	{
		textFieldWritingWord.setText(text);
	}
	
	//obsluga labeli
	public void setLabelYourAnswer(String text)
	{
		labelYourAnswer.setText(text);
	}
	
	public void setLabelYourWordToTranslating(String text)
	{
		labelYourWordToTranslating.setText(text);
	}
	
	public void setLabelCorrectAnswer(String text)
	{
		labelCorrectAnswer.setText(text);
	}
	
	public void setLabelNumberWordsInDatabase(String text)
	{
		labelNumberWordsInDatabase.setText(text);
	}
	
	public LearningView() throws IOException 
	{
		setVisible(true);
		setTitle("Fiszki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 581, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//inicjalizacja paneli
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		gl_panel = new GroupLayout(panel);
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel.setLayout(gl_panel);
		gl_panel_1 = new GroupLayout(panel_1);
		
		//inicjalizacja labeli
		labelTranslatingYourWord = new JLabel("Przet³umacz odpowiednie s³ówko!");
		labelYourWordToTranslate = new JLabel("Twoje s³ówko do przet³umaczenia to:");	
		labelYourWordToTranslating = new JLabel("New label");
		labelCorrectAnswer = new JLabel("");
		labelCorrectAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		labelYourAnswer = new JLabel("");
		labelYourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumberWordsInDatabase = new JLabel("");
		
		//inicjalizacja buttonow
		buttonNextWord = new JButton("Kolejne has³o");
		buttonDisplayingAnswer = new JButton("Poka¿ odpowiedŸ");
		buttonCheckAnswer = new JButton("SprawdŸ poprawnoœæ");
		buttonFinishLearning = new JButton("Zakoñcz naukê");
		
		//inicjalizacja texfield
		textFieldWritingWord = new JTextField();
		textFieldWritingWord.setColumns(10);
		
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addComponent(labelTranslatingYourWord)
					.addGap(160))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(labelTranslatingYourWord))
		);
				
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(197)
							.addComponent(labelYourWordToTranslate))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(123)
							.addComponent(textFieldWritingWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(labelCorrectAnswer, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(269, Short.MAX_VALUE)
					.addComponent(labelYourWordToTranslating)
					.addGap(240))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(51)
							.addComponent(labelYourAnswer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(61)
							.addComponent(buttonCheckAnswer)
							.addGap(18)
							.addComponent(buttonDisplayingAnswer)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonNextWord)))
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(200)
					.addComponent(labelNumberWordsInDatabase)
					.addContainerGap(355, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(187)
					.addComponent(buttonFinishLearning, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addComponent(labelYourWordToTranslate)
					.addGap(18)
					.addComponent(labelYourWordToTranslating)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldWritingWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelCorrectAnswer))
					.addGap(18)
					.addComponent(labelYourAnswer)
					.addGap(15)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonCheckAnswer)
						.addComponent(buttonDisplayingAnswer)
						.addComponent(buttonNextWord))
					.addGap(30)
					.addComponent(labelNumberWordsInDatabase)
					.addGap(30)
					.addComponent(buttonFinishLearning)
					.addGap(55))
		);
		panel_1.setLayout(gl_panel_1);
		setLocationRelativeTo(null);
	}
}
