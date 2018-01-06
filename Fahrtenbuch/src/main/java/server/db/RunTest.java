package server.db;

import java.sql.*;
import java.util.ArrayList;




public class RunTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		get();
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
			
			 
			// 2. Create a statement
			// Statement testStmt = testCon.createStatement();
			// 3. Execute SQL Statement
			// ResultSet testSet = testStmt.executeQuery("select* from Fahrer");
			// 4. Process Relsut set
			// while(testSet.next()){
			// System.out.println(testSet.getString("Vorname")+","+ testSet.getString("Nachname") +","+ testSet.getString("Steurnummer"));
			}
		catch(Exception e){
			System.out.print("Fuck...went wrong");
			return null;
		}
	}

}
