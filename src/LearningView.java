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
		setBounds(100, 100, 534, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//inicjalizacja paneli
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel.setLayout(gl_panel);
		
		//inicjalizacja labeli
		labelTranslatingYourWord = new JLabel("Przet³umacz odpowiednie s³ówko!");
		labelYourWordToTranslate = new JLabel("Twoje s³ówko do przet³umaczenia to:");	
		labelYourWordToTranslating = new JLabel("New label");
		labelYourWordToTranslating.setHorizontalAlignment(SwingConstants.CENTER);
		labelCorrectAnswer = new JLabel("");
		labelCorrectAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		labelYourAnswer = new JLabel("");
		labelYourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumberWordsInDatabase = new JLabel("");
		labelNumberWordsInDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		
		//inicjalizacja buttonow
		buttonNextWord = new JButton("Kolejne has³o");
		buttonDisplayingAnswer = new JButton("Poka¿ odpowiedŸ");
		buttonCheckAnswer = new JButton("SprawdŸ poprawnoœæ");
		buttonFinishLearning = new JButton("Zakoñcz naukê");
		
		//inicjalizacja texfield
		textFieldWritingWord = new JTextField();
		textFieldWritingWord.setColumns(10);
		
		gl_panel = new GroupLayout(panel);
		gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(158)
					.addComponent(labelYourWordToTranslate)
					.addContainerGap(182, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(187)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(labelNumberWordsInDatabase, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonFinishLearning, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(labelYourWordToTranslating, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(60)
											.addComponent(labelYourAnswer, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)))
									.addGap(8))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textFieldWritingWord, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelCorrectAnswer, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(52)
							.addComponent(buttonCheckAnswer)
							.addGap(18)
							.addComponent(buttonDisplayingAnswer)
							.addGap(38)
							.addComponent(buttonNextWord, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
					.addGap(52))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addComponent(labelYourWordToTranslate)
					.addGap(18)
					.addComponent(labelYourWordToTranslating)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldWritingWord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(labelCorrectAnswer)))
					.addGap(18)
					.addComponent(labelYourAnswer)
					.addGap(15)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonCheckAnswer)
						.addComponent(buttonDisplayingAnswer)
						.addComponent(buttonNextWord))
					.addGap(30)
					.addComponent(labelNumberWordsInDatabase)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonFinishLearning)
					.addGap(45))
		);
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
		panel_1.setLayout(gl_panel_1);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
}
