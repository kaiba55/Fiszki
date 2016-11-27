import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;

public class TheEndView extends JDialog 
{
	private static final long serialVersionUID = 1L;

	private GroupLayout gl_contentPanel;
	
	private JPanel buttonPane;
	private final JPanel contentPanel;
	
	private JButton buttonToMainWindow;
	
	private JLabel labelUsedAllWords;
	
	public void addButtonToMainWindowListener(ActionListener buttonToMainWindowListener)
	{
		buttonToMainWindow.addActionListener(buttonToMainWindowListener);
	}
	
	public TheEndView() 
	{
		setTitle("Koniec hase³ w bazie");
		setVisible(true);
		setBounds(100, 100, 450, 300);
	
		//inicjalizacja layout
		contentPanel = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		gl_contentPanel = new GroupLayout(contentPanel);

		//inicjalizacja labeli
		labelUsedAllWords = new JLabel("Wykorzysta\u0142e\u015B wszystkie has\u0142a z bazy.");
		
		//inicjalizacja buttonow
		buttonToMainWindow = new JButton("OK");
		
		//umieszczenie elementow w layoucie	
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(109)
					.addComponent(labelUsedAllWords)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(75)
					.addComponent(labelUsedAllWords)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{			
				buttonPane.add(buttonToMainWindow);
				getRootPane().setDefaultButton(buttonToMainWindow);
			}
		}
		setLocationRelativeTo(null);
	}

}
