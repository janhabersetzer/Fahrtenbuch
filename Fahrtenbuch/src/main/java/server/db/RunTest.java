package server.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import shared.bo.Fahrer;


public class RunTest {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		
		testUpdate();
		testInsert();
		
	}
	
	
	public static  void testFindByKey() throws Exception{
		

		//FahrerMapper intanzieren
		
		FahrerMapper dm = FahrerMapper.fahrerMapper();
		
		//Objekt abfragen
		Fahrer d = dm.findByKey(1);
		
		System.out.println("idFahrer: "+d.getId());
		System.out.println("Vorname: "+d.getVorname());
		System.out.println("Nachname: "+d.getNachname());

	}
	
public static  void testFindAll() throws Exception{
		

		//FahrerMapper intanzieren
		
		FahrerMapper dm = FahrerMapper.fahrerMapper();
		
		//Objekt abfragen
		Vector <Fahrer> dv = dm.findAll();
		
		for (Enumeration<Fahrer> e = dv.elements(); e.hasMoreElements();){
			Fahrer d = new Fahrer();
			System.out.println("idFahrer: "+d.getId());
			System.out.println("Vorname: "+d.getVorname());
			System.out.println("Nachname: "+d.getNachname());
			System.out.println("Steuernummer: "+d.getSteuerNr());
		}
		
		
	}
	public static  void testInsert() throws Exception{
		
		//Objekt anlegen
				Fahrer d= new Fahrer();
				d.setVorname("Peter");
				d.setNachname("Lustig");
				d.setSteuerNr("44444444");
		try{
		//FahrerMapper intanzieren
		FahrerMapper dm = FahrerMapper.fahrerMapper();
		
		//in DB schreiben
		dm.insert(d);
		System.out.println(d.getId()+"Erfolgreicher Insert");
		
		}catch(Exception e){
			System.out.println("So ein Sch...");
		}
	
	}
	
public static  void testUpdate() throws Exception{
		
		//Objekt anlegen
				Fahrer d= new Fahrer();
				d.setId(2);
				d.setVorname("Peter");
				d.setNachname("Lustig");
				d.setSteuerNr("44444444");
		try{
		//FahrerMapper intanzieren
		FahrerMapper dm = FahrerMapper.fahrerMapper();
		
		//in DB schreiben
		dm.update(d);
		System.out.println(d.getId()+"Erfolgreiches Update");
		
		}catch(Exception e){
			System.out.println("So ein Sch...");
		}
	
	}
	
	
	public static  void testDelete() throws Exception{
		FahrerMapper dm = FahrerMapper.fahrerMapper();
		
		
		Fahrer d= new Fahrer();
		d.setId(2);
		
		
		dm.delete(d);
		System.out.println("Erfolgreich gelöscht");
	}
	
	
	public static ArrayList<String> get() throws Exception{
		
		ArrayList<String> array = new ArrayList<String>();
		
		try{
			//1. Get a connection to the database
			Connection testCon = DBConnection.connection();
			PreparedStatement statement = testCon.prepareStatement("SELECT * FROM Fahrer");
			ResultSet result = statement.executeQuery();
			
			
			
			while(result.next()){
				 System.out.print(result.getString("Vorname"));
				 System.out.print(" ");
				 System.out.println(result.getString("Nachname"));
				 array.add(result.getString("Vorname"));
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
