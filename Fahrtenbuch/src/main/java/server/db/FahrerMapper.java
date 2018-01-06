package server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import shared.bo.Fahrer;

public class FahrerMapper {
	
	/**
	 * Attribut des Sigleton-Patterns
	 */
	private static FahrerMapper fahrerMapper = null;
	
	/**
	 * privater Konstruktor des Sigleton-Patterns
	 */
	
	private FahrerMapper() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * methode des Sigleton Patterns
	 * @return DAS <code>AccountMapper</code>-Objekt.
	 */
	public static FahrerMapper fahrerMapper(){
		if(fahrerMapper == null){
			fahrerMapper = new FahrerMapper();
		}
		return fahrerMapper;
	}
	
	/**
	 * methode um einen Fahrer anhand seiner id in der Datenbank zu finden
	 * @param id
	 * @return zur id passendes Fahrer Objekt, bei nicht vorhandenem Datensatz wird null zurückgegeben
	 */
	
	public Fahrer findByKey(int id){
		// DBConnetion aufbauen
		Connection con = DBConnection.connection();
		
		try {
		      // Leeres SQL-Statement (JDBC) anlegen
		      Statement stmt = con.createStatement();

		      // Statement ausfüllen und als Query an die DB schicken
		      ResultSet rs = stmt.executeQuery("SELECT * FROM Fahrer"
		          + "WHERE id=" + id + " ORDER BY Nachname");

		      /*
		       * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
		       * werden. Prüfe, ob ein Ergebnis vorliegt.
		       */
		      if (rs.next()) {
		        // Ergebnis-Tupel in Objekt umwandeln
		        Fahrer d = new Fahrer();
		        // Setzen der Attribute entspechenden des DB-Datensatzes
		        d.setVorname(rs.getString("Vorname"));
		        d.setNachname(rs.getString("Nachname"));
		        d.setSteuerNr(rs.getString("Steuernummer"));
		        return d;
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		      return null;
		    }

		    return null;
	}
	
	public Vector<Fahrer> findAll(){
		Connection con = DBConnection.connection();
		
		//Vector erzeugen, der alle Fahrer-Datensätze aufnehmen kann
		Vector<Fahrer> result = new Vector<Fahrer>();
		
		try{
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();
			
			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT * FROM Fahrer"+"ORDER by idFahrer");
			
			// while Schleife, weil hier Viele Zeilen durchaufen werden müssen
			while(rs.next()){
				Fahrer d = new Fahrer();
				d.setId(rs.getInt("idFahrer"));
				d.setVorname(rs.getString("Vorname"));
				d.setNachname(rs.getString("Nachname"));
				d.setSteuerNr(rs.getString("Steuernummer"));
				
				//Anstatt ein Ergebnis über return auszugeben muss hier zuerst der Vektor um d erweitert werden
				result.addElement(d);
			}		
		}catch (SQLException e2){
			e2.printStackTrace();
		}
		return result;
	}
	/**
	 * Einfuegen eines Fahrer-Objekts als neuer Tupel in die Datenbank
	 * @param d - einzufügendes Fahrer-Objekt
	 * @return d - eingefügtes Fahrer-Objekt 
	 */
	
	public Fahrer insert(Fahrer d){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			//Zunächst wird die höchste ID (Primärschlüssel) in der Datenbank abgefragt...
			ResultSet rs = stmt.executeQuery("SELECT MAX(idFahrer) AS maxid"
	          + "FROM Fahrer ");
			
			// ....um diese dann um 1 inkrementiert der id des BO zuzuweisen.
			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein --> if-Bedingung
			if(rs.next()){
				d.setId(rs.getInt("maxid")+1);
			}
			
			stmt = con.createStatement();
			
			// Jetzt erfolgt der INSERT die ID wird jedoch nicht wie beim Bankprojekt eingefügt, 
			// sondern wird durch die Autoinkrement-Einstellung der Datenbank vorgenommen.
			stmt.executeUpdate("INSERT INTO Fahrer (Vorname, Nachname, SteuerNr) " + "VALUES ("+ 
					 d.getVorname() + "," + d.getNachname() + "," + d.getSteuerNr() + ")");
			
	
		}catch(SQLException e2){
			e2.printStackTrace();
			}
		return d;
	}
	
	/*
	 * Verändern eines bereits in der DB vorhandenen Datensatzes
	 * @param Fahrer-Objekt, das geändert werden soll
	 * @return das übergebene und geänderte Fahrer-Objekt
	 */
	
	public Fahrer update(Fahrer d){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			// UPDATE aller Tupel Attribute entsprechend der Objekt Attribute
			stmt.executeUpdate("UPDATE Fahrer " + "SET Vorname= \"" + d.getVorname()
	          + "\","+ "\""+d.getNachname()+"\","+"\""+d.getSteuerNr()+"\""+ "WHERE idFahrer="+ d.getId());
			
			
		}catch(SQLException e2){
			e2.printStackTrace();
		}
		
		return d;
	}
	
	/*
	 * Löschen des Fahrers aus der DB
	 * ACHTUNG !!!!!!! Darf nur möglich sein, wenn der Fahrer nicht mehr von Fahrten oder Fahrzeugen referenziert wird
	 * Diese Umsetzung steht noch aus!!!!!!!!
	 */
	
	public void delete(Fahrer d){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM Fahrer"+ "WHERE idFahrer="+ d.getId());
			
		}catch(SQLException e2){
			e2.printStackTrace();
		}
	}
	


}