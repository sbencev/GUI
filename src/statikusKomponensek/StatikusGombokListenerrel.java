package statikusKomponensek;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatikusGombokListenerrel implements ActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatikusGombokListenerrel window = new StatikusGombokListenerrel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatikusGombokListenerrel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(45, 42, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);

		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBounds(169, 42, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);

		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setBounds(293, 42, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);

		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setBounds(45, 110, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);

		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setBounds(169, 110, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(this);

		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setBounds(293, 110, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(frame, ((JButton) e.getSource()).getText());
	}
}
