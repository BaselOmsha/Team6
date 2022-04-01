package app.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Candidate;



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
	
	//edits candidate info
	public int editCandidate(Candidate candidate) {
		int count = 0;
		String sql = "update candidate set fname = ?, set lname = ?, set ssn = ?, set party = ?, set email = ?, set uname = ?, set age = ?, set Why_running = ?, set What_things_Do_you_wnat_to_represent = ?, set profession = ?, set paswd = ?, set salt = ?,  where candidate_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, candidate.getFname());
			stmt.setString(2, candidate.getLname());
			stmt.setString(3, candidate.getSsn());
			stmt.setString(4, candidate.getParty());
			stmt.setString(5, candidate.getEmail());
			stmt.setString(6, candidate.getUname());
			stmt.setInt(7, candidate.getAge());
			stmt.setString(8, candidate.getWhy_running());
			stmt.setString(9, candidate.getWhat_things_Do_you_wnat_to_represent());
			stmt.setString(10, candidate.getProfession());
			stmt.setString(11, candidate.getPaswd());
			stmt.setString(12, candidate.getSalt());
			
			
			stmt.setInt(13, candidate.getCandidate_id());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//shows info of each candidate
	public Candidate showCandInfo(int candidate_id) {
		Candidate result = null;
		String sql = "select * from candidate where candidate_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, candidate_id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Candidate();
				result.setCandidate_id(resultset.getInt("candidate_id"));
				result.setFname(resultset.getString("fname"));
				result.setLname(resultset.getString("lname"));
				result.setSsn(resultset.getString("ssn"));
				result.setParty(resultset.getString("party"));
				result.setEmail(resultset.getString("email"));
				result.setUname(resultset.getString("uname"));
				result.setAge(resultset.getInt("age"));
				result.setWhy_running(resultset.getString("Why_running"));
				result.setWhat_things_Do_you_wnat_to_represent(resultset.getString("What_things_Do_you_wnat_to_represent"));
				result.setProfession(resultset.getString("profession"));
				result.setPaswd(resultset.getString("paswd"));
//				result.setSalt(resultset.getString("salt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
	
	public ArrayList<cand> readAllCandidates() {
        ArrayList<cand> list=new ArrayList<>();
        Statement stmt=null;
        int count=0;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from electionmachine");
            while (rs.next()) {
                cand game=new cand();
                cand.setCandidate_id(Integer.parseInt(request.getParameter("candidate_id")));
                cand.setFname(request.getParameter("fname"));
                cand.setLname(request.getParameter("lname"));
                cand.setSsn(request.getParameter("ssn"));
                cand.setParty(request.getParameter("party"));
                cand.setEmail(request.getParameter("email"));
                cand.setUname(request.getParameter("uname"));
                cand.setAge(Integer.parseInt(request.getParameter("age")));
                cand.setWhy_running(request.getParameter("Why_running"));
                cand.setWhat_things_Do_you_wnat_to_represent(request.getParameter("What_things_Do_you_wnat_to_represent"));
                cand.setProfession(request.getParameter("profession"));
                list.add(cand);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

}
