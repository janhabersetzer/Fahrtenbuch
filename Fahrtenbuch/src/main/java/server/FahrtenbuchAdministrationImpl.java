package server;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import server.db.FahrerMapper;
import server.db.FahrtMapper;
import server.db.FahrzeugMapper;
import shared.FahrtenbuchAdministration;
import shared.bo.Fahrer;
import shared.bo.Fahrt;
import shared.bo.Fahrzeug;

public class FahrtenbuchAdministrationImpl implements FahrtenbuchAdministration {
	
	private FahrerMapper dMapper = null;
	
	private FahrzeugMapper vMapper = null;
	
	private FahrtMapper tMapper = null;
	
	/**
	 * No-Argument-Konstruktor muss vorhanden sein
	 * @throws IllegalArgumentException
	 */
	public FahrtenbuchAdministrationImpl() throws IllegalArgumentException {
	    
	  }

	@Override
	public void init() throws IllegalArgumentException {
		
		this.dMapper = FahrerMapper.fahrerMapper();
		this.vMapper = FahrzeugMapper.fahrzeugMapper();
		this.tMapper = FahrtMapper.fahrtMapper();

	}
	
	
	/*
	 * ****************ENDE INITIALISIERUNG********************************
	 */

	@Override
	public Fahrer createFahrer(String first, String last, String taxNo) throws IllegalArgumentException {
		
		//FahrerObjekt anlegen
		Fahrer d = new Fahrer();
		d.setId(1);
		d.setVorname(first);
		d.setNachname(last);
		d.setSteuerNr(taxNo);
		
		return this.dMapper.insert(d);
	}

	@Override
	public Fahrzeug createFahrzeug(String regNo, int milage, String description, String color)
			throws IllegalArgumentException {
		Fahrzeug v = new Fahrzeug();
		v.setKennzeichen(regNo);
		v.setKm(milage);
		v.setModellBeschreibung(description);
		v.setFarbe(color);
		
		return this.vMapper.insert(v);
	}

	@Override
	public Fahrt createFahrt(LocalDate tripDate, String destDescr, int firstMilage, int secondMilage, int privateDist,
			int workingDist, int companyDist, String comment, int vehicleId, int driverId) throws IllegalArgumentException {
		
		
		//Bearbeitungsdatum mit aktuellem Datum setzen
		LocalDate bdate = LocalDate.now( ZoneId.of( "Europe/Berlin") );
		
		
		Fahrt t= new Fahrt();
		t.setFahrtDatum(tripDate);
		t.setZielBeschreibung(destDescr);
		t.setKmStart(firstMilage);
		t.setKmEnd(secondMilage);
		t.setPrivatKm(privateDist);
		t.setArbeitswegKm(workingDist);
		t.setBetriebsfahrtKm(companyDist);
		t.setKommentar(comment);
		t.setSourceFahrzeugId(vehicleId);
		t.setSourceFahrerId(driverId);
		t.setBearbeitungsdatum(bdate);
	
		return this.tMapper.insert(t);
	}

	@Override
	public Fahrer getFahrer(Fahrt t) throws IllegalArgumentException {
		
		// Das f-Objekt um die FahrerId erweitern
		
		//*************HIER***************
		
		//Den Fahrer anhand der FahrerId aus der Datenbank auslesen
		
		//*************HIER***************
		
		return null;
	}

	@Override
	public Vector<Fahrer> getAlleFahrer() throws IllegalArgumentException {
		return this.dMapper.findAll();
	}

	@Override
	public void saveFahrer(Fahrer d) throws IllegalArgumentException {
		dMapper.update(d);
	}

	@Override
	public void deleteFahrer(Fahrer d) throws IllegalArgumentException {
		
		//Prüfen ob der zu löschende Fahrer noch Fahrten in der DB hat
		
		//*************HIER***************
		//findByFahrer verwenden
		
		//Dann löschen
		dMapper.delete(d);

	}

	@Override
	public Fahrzeug getFahrzeug(Fahrt t) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Vector<Fahrzeug> getAlleFahrzeug() throws IllegalArgumentException {
		return vMapper.findAll();
	}

	@Override
	public void saveFahrzeug(Fahrzeug v) throws IllegalArgumentException {
		vMapper.insert(v);
	}

	@Override
	public void deleteFahrzeug(Fahrzeug v) throws IllegalArgumentException {
		//Alle Fahrten dieses Fahrzeugs löschen
		tMapper.deleteAlleFahrtenOfFahrzeug(v);
		//Fahrzeug löschen
		vMapper.delete(v);

	}

	@Override
	public Vector<Fahrt> getAlleFahrtenVonFahrer(Fahrer d) throws IllegalArgumentException {
		
		return null;
	}

	@Override
	public Vector<Fahrt> getAlleFahrtenVonFahrzeug(Fahrzeug v) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFahrt(Fahrt t) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFahrt(Fahrt t) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAlleFahrtenVonFahrzeug(Fahrzeug v) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

}
