package szamBekeres;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SzamGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzamGUI window = new SzamGUI();
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
	public SzamGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int osszeg = 0;
		int szorzat = 1;

		while (osszeg < 100) {

			try {

				int aktualisSzam = Integer.parseInt(JOptionPane.showInputDialog(frame,
						"Adja meg a kovetkezo szamot (" + osszeg + ")", "Szambekeres", JOptionPane.QUESTION_MESSAGE));

				osszeg += aktualisSzam;
				szorzat *= aktualisSzam;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "Nem megfelelo formatum", "Hiba", JOptionPane.ERROR_MESSAGE);
			}

		}
		JOptionPane.showMessageDialog(frame, "A szamok szorzata: " + szorzat, "Eredmeny",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
