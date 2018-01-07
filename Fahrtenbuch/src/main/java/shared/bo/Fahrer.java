package shared.bo;

public class Fahrer extends BusinessObject {
	
	//Attribute
	
	private static final long serialVersionUID = 1L;
	
	private String vorname;
	private String nachname;
	private String steuerNr;
	
	/*
	 * No Argument Constructor 
	 * Auch wenn dieser eigentlich nicht benötigt wird wurde er schonmal hingeschreiben, damit er später - im Falle das ein
	 * Construktor mit Eingabe-Parametern angelegt wird nicht überdekt wird
	 */
	
	public Fahrer(){
		
	}
	
	
	//Getter und Setter
	
	public String getVorname() {
		return this.vorname;
	}
	
	public void setVorname(String vorname){
		this.vorname = vorname;
	}
	
	public String getNachname(){
		return this.nachname;
	}
	
	public void setNachname(String nachname){
		this.nachname = nachname;
	}

	public String getSteuerNr(){
		return this.steuerNr;
	}
	
	public void setSteuerNr(String steuerNr){
		this.steuerNr = steuerNr;
	}
	
	
}
