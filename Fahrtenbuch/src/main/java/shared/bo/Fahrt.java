package shared.bo;

import java.sql.Date;

public class Fahrt extends BusinessObject{
	
	//Attribute

	private static final long SerialVersionUID = 1L;
	
	private String zielBeschreibung;
	
	private int kmStart;
	
	private int kmEnd;
	
	private int privatKm;
	
	private int arbeitswegKm;
	
	private int betriebsfahrtKm;
	
	private Date datum;
	
	private String kommentar;
	
	private Date bearbeitungsdatum;
	
	
	
//	Getter/ Setter-Block

	public String getZielBeschreibung() {
		return this.zielBeschreibung;
	}

	public void setZielBeschreibung(String zielBeschreibung) {
		this.zielBeschreibung = zielBeschreibung;
	}

	public int getKmStart() {
		return this.kmStart;
	}

	public void setKmStart(int kmStart) {
		this.kmStart = kmStart;
	}

	public int getKmEnd() {
		return this.kmEnd;
	}

	public void setKmEnd(int kmEnd) {
		this.kmEnd = kmEnd;
	}

	public int getPrivatKm() {
		return this.privatKm;
	}

	public void setPrivatKm(int privatKm) {
		this.privatKm = privatKm;
	}

	public int getArbeitswegKm() {
		return this.arbeitswegKm;
	}

	public void setArbeitswegKm(int arbeitswegKm) {
		this.arbeitswegKm = arbeitswegKm;
	}

	public int getBetriebsfahrtKm() {
		return this.betriebsfahrtKm;
	}

	public void setBetriebsfahrtKm(int betriebsfahrtKm) {
		this.betriebsfahrtKm = betriebsfahrtKm;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getKommentar() {
		return this.kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public Date getBearbeitungsdatum() {
		return this.bearbeitungsdatum;
	}

	public void setBearbeitungsdatum(Date bearbeitungsdatum) {
		this.bearbeitungsdatum = bearbeitungsdatum;
	}

	@Override
	public String toString() {
		return super.toString()+ "Fahrt [zielBeschreibung=" + this.zielBeschreibung + ", kmStart=" + this.kmStart + ", kmEnd=" + this.kmEnd
				+ ", privatKm=" + this.privatKm + ", arbeitswegKm=" + this.arbeitswegKm + ", betriebsfahrtKm=" + this.betriebsfahrtKm
				+ ", datum=" + this.datum + ", kommentar=" + this.kommentar + ", bearbeitungsdatum=" + this.bearbeitungsdatum + "]";
	}
	
	
	
	
	
	
}
