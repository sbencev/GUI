package lottoSzelvenyKitoltoDinamikus;

public enum LottoFajta {

	OTOS("otos", 5, 90), HATOS("hatos", 6, 45), HETES("skandi", 7, 35);

	private final String megnevezes;
	private final int hanyszamotHuznak;
	private final int hanySzambolHuzzak;

	private LottoFajta(String megnevezes, int hanyszamotHuznak, int hanySzambolHuzzak) {
		this.megnevezes = megnevezes;
		this.hanyszamotHuznak = hanyszamotHuznak;
		this.hanySzambolHuzzak = hanySzambolHuzzak;
	}

	public int getHanyszamotHuznak() {
		return hanyszamotHuznak;
	}

	public int getHanySzambolHuzzak() {
		return hanySzambolHuzzak;
	}

	public String toString() {

		return megnevezes;

	}

}
