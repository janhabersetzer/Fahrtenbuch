package shared.bo;

public class Fahrzeug extends BusinessObject{

	private static final long serialVersionUID =1L;
	
	private String kennzeichen;
	
	private int km;
	
	private String modellBeschreibung;
	
	private String farbeString;

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public int getKm() {
		return this.km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getModellBeschreibung() {
		return this.modellBeschreibung;
	}

	public void setModellBeschreibung(String modellBeschreibung) {
		this.modellBeschreibung = modellBeschreibung;
	}

	public String getFarbeString() {
		return this.farbeString;
	}

	public void setFarbeString(String farbeString) {
		this.farbeString = farbeString;
	}

	@Override
	public String toString() {
		return super.toString()+ "Fahrzeug [kennzeichen=" + this.kennzeichen + ", km=" + this.km + ", modellBeschreibung=" + this.modellBeschreibung
				+ ", farbeString=" + this.farbeString + "]";
	}
	
	
	
	
}
