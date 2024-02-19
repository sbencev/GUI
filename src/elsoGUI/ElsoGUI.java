package elsoGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ElsoGUI {

	private JFrame frmFoablak;
	private JTextField txtSzoveg;
	private JTextField txtSzoveg2;
	private JLabel lblMegjelenites_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElsoGUI window = new ElsoGUI();
					window.frmFoablak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ElsoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoablak = new JFrame();
		frmFoablak.setTitle("Elso grafikus alkalmazas");
		frmFoablak.setBounds(100, 100, 600, 413);
		frmFoablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoablak.getContentPane().setLayout(null);
		
		JLabel lblSzovegBeker = new JLabel("A megjelenitendo szoveg:");
		lblSzovegBeker.setBounds(32, 54, 169, 23);
		frmFoablak.getContentPane().add(lblSzovegBeker);
		
		txtSzoveg = new JTextField();
		txtSzoveg.setBounds(240, 55, 280, 20);
		frmFoablak.getContentPane().add(txtSzoveg);
		txtSzoveg.setColumns(10);
		
		JLabel lblMegjelenites = new JLabel("");
		lblMegjelenites.setBounds(32, 127, 202, 36);
		frmFoablak.getContentPane().add(lblMegjelenites);
		
		JButton btnSzovegKiir = new JButton("Megjelenites");
		btnSzovegKiir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblMegjelenites.setText(txtSzoveg.getText());
				txtSzoveg.setText(null);
				
			}
		});
		btnSzovegKiir.setBounds(329, 127, 136, 53);
		frmFoablak.getContentPane().add(btnSzovegKiir);
		
		JLabel lblSzovegBeker_1 = new JLabel("A megjelenitendo szoveg:");
		lblSzovegBeker_1.setBounds(32, 209, 169, 23);
		frmFoablak.getContentPane().add(lblSzovegBeker_1);
		
		txtSzoveg2 = new JTextField();
		txtSzoveg2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lblMegjelenites_1.setText(txtSzoveg2.getText());
				
			}
		});
		txtSzoveg2.setColumns(10);
		txtSzoveg2.setBounds(240, 210, 280, 20);
		frmFoablak.getContentPane().add(txtSzoveg2);
		
		lblMegjelenites_1 = new JLabel("");
		lblMegjelenites_1.setBounds(32, 282, 202, 36);
		frmFoablak.getContentPane().add(lblMegjelenites_1);
	}
}
