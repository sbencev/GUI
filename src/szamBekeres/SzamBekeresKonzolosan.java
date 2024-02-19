package szamBekeres;

import javax.swing.JOptionPane;

public class SzamBekeresKonzolosan {

	public static void main(String[] args) {

		int osszeg = 0;
		int szorzat = 1;

		while (osszeg < 100) {

			try {

				int aktualisSzam = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Adja meg a kovetkezo szamot (" + osszeg + ")", "Szambekeres", JOptionPane.QUESTION_MESSAGE));

				osszeg += aktualisSzam;
				szorzat *= aktualisSzam;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Nem megfelelo formatum", "Hiba", JOptionPane.ERROR_MESSAGE);
			}

		}
		JOptionPane.showMessageDialog(null, "A szamok szorzata: " + szorzat, "Eredmeny",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
