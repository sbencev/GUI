package szamkitalalosBovitett;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class SzamkitalalosGUI {

	private static Random r = new Random();

	private JFrame frmSzamkitalalos;
	private JTextField txtJatekosTippje;

	private int kitalalando;
	private JLabel lblEredmeny;
	private JButton btnTippEllenorzes;
	int tippekSzama;

	private DefaultListModel<String> listModel;
	private JList<String> lstTortenet;
	private JButton btnVeletlenszamGeneralas;

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
		frmSzamkitalalos.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				Object[] opciok = { "Igen", "Nem" };
				ImageIcon ikon = new ImageIcon("kilepes.png");

				int valasz = JOptionPane.showOptionDialog(frmSzamkitalalos, "Biztosan ki akar lepni a programbol?",
						"Kilepes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ikon, opciok, opciok[1]);
				if (valasz == JOptionPane.YES_OPTION) {
					// frmSzamkitalalos.dispose(); --> ablak bezarasa
					System.exit(0);
				}

			}
		});
		frmSzamkitalalos.setTitle("Szamkitalalos");
		frmSzamkitalalos.setBounds(100, 100, 609, 440);
		frmSzamkitalalos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmSzamkitalalos.getContentPane().setLayout(null);

		btnVeletlenszamGeneralas = new JButton("Szamgeneralas");
		btnVeletlenszamGeneralas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ujJatek();

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
				tippEllenorzes();

			}
		});
		btnTippEllenorzes.setEnabled(false);
		btnTippEllenorzes.setBounds(364, 95, 116, 29);
		frmSzamkitalalos.getContentPane().add(btnTippEllenorzes);

		lblEredmeny = new JLabel("");
		lblEredmeny.setBounds(158, 160, 276, 23);
		frmSzamkitalalos.getContentPane().add(lblEredmeny);

		JButton btnKilepes = new JButton("Kilepes");
		btnKilepes.setMnemonic('k');
		btnKilepes.setToolTipText("Kilepes a jatekbol");
		btnKilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmSzamkitalalos.dispatchEvent(new WindowEvent(frmSzamkitalalos, WindowEvent.WINDOW_CLOSING));

			}
		});
		btnKilepes.setBackground(new Color(255, 102, 102));
		btnKilepes.setBounds(494, 349, 89, 23);
		frmSzamkitalalos.getContentPane().add(btnKilepes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 183, 354, 190);
		frmSzamkitalalos.getContentPane().add(scrollPane);

		lstTortenet = new JList<String>();
		scrollPane.setViewportView(lstTortenet);

		JMenuBar menuBar = new JMenuBar();
		frmSzamkitalalos.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmUjJatek = new JMenuItem("Uj jatek");
		mntmUjJatek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ujJatek();

			}
		});
		mnNewMenu.add(mntmUjJatek);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mntmStatisztika = new JMenuItem("Statisztika");
		mntmStatisztika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmSzamkitalalos,
						"A szam kitalalasahoz " + tippekSzama + " lepesre volt szukseged!", "Statisztika",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmStatisztika);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		JMenuItem mntmKilepes = new JMenuItem("Kilepes");
		mnNewMenu.add(mntmKilepes);

		JMenuItem mntmNewMenuItem = new JMenuItem("Nevjegy");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(frmSzamkitalalos, "Szamkitalalos jatek\nCopyright SB", "Nevjegy",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		menuBar.add(mntmNewMenuItem);
	}

	private void tippEllenorzes() {

		try {

			tippekSzama++;
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

				JOptionPane.showMessageDialog(frmSzamkitalalos, "Eltalaltad a szamot!", "Eredmeny",
						JOptionPane.INFORMATION_MESSAGE);
			}

			listModel.addElement(txtJatekosTippje.getText() + " - " + lblEredmeny.getText());
			txtJatekosTippje.setText("");
			txtJatekosTippje.grabFocus();

		} catch (NumberFormatException e1) {
			lblEredmeny.setText("Hibas szamformatum!");
			txtJatekosTippje.setText(null);

			JOptionPane.showMessageDialog(frmSzamkitalalos, "Hibas szamformatum!", "Hiba", JOptionPane.ERROR_MESSAGE);

		}

	}

	private void ujJatek() {

		kitalalando = r.nextInt(100) + 1;
		lblEredmeny.setText("Gondoltam egy szamot 1 es 100 kozott");
		txtJatekosTippje.setEnabled(true);
		btnTippEllenorzes.setEnabled(true);
		btnVeletlenszamGeneralas.setEnabled(false);

		listModel = new DefaultListModel<String>();
		lstTortenet.setModel(listModel);

		tippekSzama = 0;

	}

}
