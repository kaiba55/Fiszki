import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindowView extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	private GroupLayout gl_panel_1;
	
	private JPanel panel;
	private JPanel panel_1;
	private JPanel contentPane;
	
	private JCheckBox checkBoxRandomingPolish;
	private JCheckBox checkBoxRandomingEnglish;
	private JCheckBox checkBoxNotRepeating;
	
	private JLabel labelConfigurationOfProgram;
	
	private JButton buttonManagementVocabulary;
	private JButton buttonLearning;
	
	//dodanie listenerow do przyciskow
	public void addButtonLearningListener(ActionListener buttonLearningListener)
	{
		buttonLearning.addActionListener(buttonLearningListener);
	}
	
	public void addButtonManagementVocabularyListener(ActionListener buttonManagementListener)
	{
		buttonManagementVocabulary.addActionListener(buttonManagementListener);
	}
	
	//gety do checboxow
	public boolean getCheckBoxRandomingPolishIsSelected()
	{
		return checkBoxRandomingPolish.isSelected();
	}
	
	public boolean getCheckBoxNotRepeatingIsSelected()
	{
		return checkBoxNotRepeating.isSelected();
	}
	
	public boolean getCheckBoxRandomingEnglishIsSelected()
	{
		return checkBoxRandomingEnglish.isSelected();
	}
	
	public MainWindowView() 
	{
		setTitle("Fiszki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//inicjalizacja paneli
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		
		//inicjalizacja buttonow
		buttonLearning = new JButton("Zaczynamy");
		buttonManagementVocabulary = new JButton("Dodaj/Usu\u0144 s\u0142\u00F3wka");
		
		
		//inicjalizacja checboxow
		checkBoxRandomingPolish = new JCheckBox("Losuj polskie\r\n");
		checkBoxRandomingEnglish = new JCheckBox("Losuj angielskie");
		checkBoxNotRepeating = new JCheckBox("Losuj bez powt\u00F3rze\u0144");
		
		//inicjalizacja labeli
		labelConfigurationOfProgram = new JLabel("Skonfiguruj program");
		gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(174)
							.addComponent(buttonLearning))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(68)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(checkBoxNotRepeating, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(checkBoxRandomingPolish, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(checkBoxRandomingEnglish))
							.addGap(48)
							.addComponent(buttonManagementVocabulary)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addComponent(checkBoxRandomingPolish)
					.addGap(2)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkBoxRandomingEnglish)
						.addComponent(buttonManagementVocabulary))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkBoxNotRepeating)
					.addGap(41)
					.addComponent(buttonLearning)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panel.add(labelConfigurationOfProgram);
		panel_1.setLayout(gl_panel_1);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
}
