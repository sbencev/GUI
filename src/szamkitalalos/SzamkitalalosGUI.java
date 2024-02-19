package szamkitalalos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class SzamkitalalosGUI {

	private static Random r = new Random();

	private JFrame frmSzamkitalalos;
	private JTextField txtJatekosTippje;

	private int kitalalando;
	private JLabel lblEredmeny;
	private JButton btnTippEllenorzes;

	private DefaultListModel<String> listModel;
	private JList<String> lstTortenet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzamkitalalosGUI window = new SzamkitalalosGUI();
					window.frmSzamkitalalos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SzamkitalalosGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSzamkitalalos = new JFrame();
		frmSzamkitalalos.setTitle("Szamkitalalos");
		frmSzamkitalalos.setBounds(100, 100, 609, 423);
		frmSzamkitalalos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSzamkitalalos.getContentPane().setLayout(null);

		JButton btnVeletlenszamGeneralas = new JButton("Szamgeneralas");
		btnVeletlenszamGeneralas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				kitalalando = r.nextInt(100) + 1;
				lblEredmeny.setText("Gondoltam egy szamot 1 es 100 kozott");
				txtJatekosTippje.setEnabled(true);
				btnTippEllenorzes.setEnabled(true);
				btnVeletlenszamGeneralas.setEnabled(false);

				listModel = new DefaultListModel<String>();
				lstTortenet.setModel(listModel);

			}
		});
		btnVeletlenszamGeneralas.setBackground(new Color(102, 204, 255));
		btnVeletlenszamGeneralas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVeletlenszamGeneralas.setBounds(229, 33, 135, 44);
		frmSzamkitalalos.getContentPane().add(btnVeletlenszamGeneralas);

		txtJatekosTippje = new JTextField();
		txtJatekosTippje.setEnabled(false);
		txtJatekosTippje.setBounds(270, 95, 52, 29);
		frmSzamkitalalos.getContentPane().add(txtJatekosTippje);
		txtJatekosTippje.setColumns(10);

		JLabel lblSzambekeres = new JLabel("Jatekos tippje:");
		lblSzambekeres.setBounds(179, 99, 81, 21);
		frmSzamkitalalos.getContentPane().add(lblSzambekeres);

		btnTippEllenorzes = new JButton("Tipp ellenorzese");
		btnTippEllenorzes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int tipp = Integer.parseInt(txtJatekosTippje.getText());
					if (kitalalando > tipp) {
						lblEredmeny.setText("A gondolt szam nagyobb");
					} else if (kitalalando < tipp) {
						lblEredmeny.setText("A gondolt szam kisebb");
					} else {
						lblEredmeny.setText("Eltalaltad a szamot!");
						btnTippEllenorzes.setEnabled(false);
						btnVeletlenszamGeneralas.setEnabled(true);
						txtJatekosTippje.setEnabled(false);
					}

					listModel.addElement(txtJatekosTippje.getText() + " - " + lblEredmeny.getText());
					txtJatekosTippje.setText("");
					txtJatekosTippje.grabFocus();

				} catch (NumberFormatException e1) {
					lblEredmeny.setText("Hibas szamformatum!");
					txtJatekosTippje.setText(null);
				}

			}
		});
		btnTippEllenorzes.setEnabled(false);
		btnTippEllenorzes.setBounds(364, 95, 116, 29);
		frmSzamkitalalos.getContentPane().add(btnTippEllenorzes);

		lblEredmeny = new JLabel("");
		lblEredmeny.setBounds(158, 160, 276, 23);
		frmSzamkitalalos.getContentPane().add(lblEredmeny);

		lstTortenet = new JList<String>();
		lstTortenet.setBounds(138, 216, 317, 156);
		frmSzamkitalalos.getContentPane().add(lstTortenet);

		JButton btnKilepes = new JButton("Kilepes");
		btnKilepes.setMnemonic('k');
		btnKilepes.setToolTipText("Kilepes a jatekbol");
		btnKilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		btnKilepes.setBackground(new Color(255, 102, 102));
		btnKilepes.setBounds(494, 349, 89, 23);
		frmSzamkitalalos.getContentPane().add(btnKilepes);
	}
}
