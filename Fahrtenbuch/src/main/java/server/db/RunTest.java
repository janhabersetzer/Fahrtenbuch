package server.db;

import java.sql.*;
import java.util.ArrayList;

import shared.bo.Fahrer;




public class RunTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testFahrerMapper();
	}
	
	
	public static  void testFahrerMapper() throws Exception{
		
		//Fahrer- Objekt erzeugen und Atrribute deklarieren
		Fahrer d= new Fahrer();
		d.setVorname("Juli");
		d.setNachname("Bert");
		d.setSteuerNr("111111111");
		d.setId(1);
		
		//FahrerMapper intanzieren
		
		FahrerMapper dm = FahrerMapper.fahrerMapper();
		
		//Objekt in DB speichern
		dm.insert(d);
		
		
	}
	
	public static ArrayList<String> get() throws Exception{
		try{
			//1. Get a connection to the database
			Connection testCon = DBConnection.connection();
			PreparedStatement statement = testCon.prepareStatement("SELECT * FROM Fahrer");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			
			while(result.next()){
				 System.out.print(result.getString("Vorname"));
				 System.out.print(" ");
				 System.out.println(result.getString("Nachname"));
				 array.add(result.getString("Nachname"));
				 
			 }
			System.out.println("All records have been seleced");
			return array;

			}
		catch(Exception e){
			System.out.print("Fuck...went wrong");
			return null;
		}
	}

}
