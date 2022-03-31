package app.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Dao {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/electionmachine", "team6",
					"kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//inserts new candidate into candidate table
	public void addCandidate(String fname, String lname, String ssn, String party, String email, 
			String uname, int age, String paswd, String salt) {
		
		String sql = "insert into candidate(fname, lname, ssn, party, email, uname, age, paswd, salt) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, ssn);
			stmt.setString(4, party);
			stmt.setString(5, email);
			stmt.setString(6, uname);
			stmt.setInt(7, age);
			stmt.setString(8, paswd);
			stmt.setString(9, salt);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Checks for duplicate candidates' username
	public boolean checkCandUname (String uname) {
		boolean count = true;
		String sql = "select uname from candidate where uname=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, uname);


			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				System.out.println(""+uname+" is already in use");
				return count;
            }  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public int editCandidate(Candidate candidate) {
		int count = 0;
		String sql = "update gametable set breed = ?, weight = ? where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, game.getBreed());
			stmt.setFloat(2, game.getWeight());
			
			stmt.setInt(3, game.getId());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	public String getUserSalt(String uname) {
		String result = "";
		String sql = "select salt from candidate where uname=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, uname);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getString("salt");
			}
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getUserpasswordHash(String uname) {
		String result = "";
		String sql = "select paswd from candidate where uname=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, uname);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getString("paswd");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
