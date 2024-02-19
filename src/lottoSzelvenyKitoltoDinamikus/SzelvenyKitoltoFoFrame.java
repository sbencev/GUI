package lottoSzelvenyKitoltoDinamikus;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SzelvenyKitoltoFoFrame {

	private JFrame frame;

	private int tippekSzama = 0;
	private JButton mentesGomb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzelvenyKitoltoFoFrame window = new SzelvenyKitoltoFoFrame();
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
	public SzelvenyKitoltoFoFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		JComboBox<LottoFajta> cmbLottoTipus = new JComboBox<LottoFajta>();
		cmbLottoTipus.setModel(new DefaultComboBoxModel<>(LottoFajta.values()));

		JOptionPane.showMessageDialog(frame, cmbLottoTipus, "Lottojatek", JOptionPane.QUESTION_MESSAGE);

		frame = new JFrame();
		frame.setTitle("Szelvenykitolto seged");
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		szelvenyKitoltes(((LottoFajta) cmbLottoTipus.getSelectedItem()).getHanyszamotHuznak(),
				((LottoFajta) cmbLottoTipus.getSelectedItem()).getHanySzambolHuzzak());

	}

	private void szelvenyKitoltes(int hanyszamotHuznak, int hanySzambolHuzzak) {

		int fentrolPozicio = 20;
		int balrolPozicio = 20;

		for (int i = 1; i <= hanySzambolHuzzak; i++) {
			JButton szamGomb = new JButton();

			szamGomb.setText(String.valueOf(i));
			szamGomb.setBounds(balrolPozicio, fentrolPozicio, 60, 60);
			szamGomb.setForeground(Color.BLACK);

			frame.getContentPane().add(szamGomb);

			if (i % 10 == 0) {

				fentrolPozicio += 65;
				balrolPozicio = 20;

			} else {
				balrolPozicio += 65;

			}

			szamGomb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					JButton aktualisGomb = (JButton) e.getSource();
					if ((aktualisGomb.getForeground() == Color.BLACK)) {

						if (tippekSzama < hanyszamotHuznak) {

							aktualisGomb.setForeground(Color.RED);
							tippekSzama++;

							if (tippekSzama == hanyszamotHuznak) {

								mentesGomb.setEnabled(true);

							}

						} else {
							JOptionPane.showMessageDialog(frame, "Nem jelolhet be tobb szamot!", "Figyelmeztetes",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						tippekSzama--;
						aktualisGomb.setForeground(Color.BLACK);
						mentesGomb.setEnabled(false);
					}
				}
			});

		}

		if (hanySzambolHuzzak % 10 != 0) {

			fentrolPozicio += 65;

		}

		mentesGomb = new JButton();
		mentesGomb.setText("Kesz");
		mentesGomb.setBounds(300, fentrolPozicio, 100, 50);
		mentesGomb.setEnabled(false);
		frame.getContentPane().add(mentesGomb);

		mentesGomb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String szelveny = "A vegleges tippek:\n";
				for (Component komponens : frame.getContentPane().getComponents()) {
					if (komponens.getClass() == JButton.class && komponens.getForeground() == Color.RED) {
						szelveny += ((JButton) komponens).getText() + "  ";
					}
				}

				JOptionPane.showMessageDialog(frame, szelveny, "Eredmeny", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
		});

	}

}
