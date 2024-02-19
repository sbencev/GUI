package proba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Proba {

	private JFrame frmFrameCim;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proba window = new Proba();
					window.frmFrameCim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Proba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrameCim = new JFrame();
		frmFrameCim.setTitle("Frame cim");
		frmFrameCim.setBounds(100, 100, 728, 394);
		frmFrameCim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrameCim.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gomb");
		btnNewButton.setBounds(312, 167, 111, 33);
		frmFrameCim.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(168, 129, 388, 27);
		frmFrameCim.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
