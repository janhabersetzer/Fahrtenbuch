package server.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shared.bo.Fahrzeug;

public class FahrzeugMapper {

	
	/**
	 * Attribut des Sigleton-Patterns
	 */
	private static FahrzeugMapper fahrzeugMapper = null;
	
	
	/**
	 * privater Konstruktor des Sigleton-Patterns
	 */
	private FahrzeugMapper() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * methode des Sigleton Patterns
	 * @return DAS <code>FahrzeugMapper</code>-Objekt.
	 */
	public FahrzeugMapper fahrzeugMapper(){
		if(fahrzeugMapper == null){
			fahrzeugMapper = new FahrzeugMapper();
		}
		return fahrzeugMapper;
	}
	
	/**
	 * Methode um ein Fahrzeug anhand seiner id in der Datenbank zu finden.
	 * @param id
	 * @return das <code>Fahrzeug</code>-Objekt
	 */
	public Fahrzeug findByKey(int id){
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		String selectByKey = "SELECT * FROM Fahrzeug WHERE idFahrzeug= ? ORDER BY idFahrzeug";
		
		try{
			con = DBConnection.connection();
			
			stmt= con.prepareStatement(selectByKey);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Fahrzeug v = new Fahrzeug();
				v.setId(rs.getInt("idFahrzeug"));
				v.setKennzeichen(rs.getString("Kennzeichen"));
				v.setModellBeschreibung(rs.getString("Modellbeschreibung"));
				v.setKm(rs.getInt("Kilometerstand"));
				v.setFarbeString(rs.getString("Farbe"));
				return v;	
			}
		}
		catch(SQLException e2){
			e2.printStackTrace();
			return null;
		}
		return null;	
	}
	
	
	
	
	









}
