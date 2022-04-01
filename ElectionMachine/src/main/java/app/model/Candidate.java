package app.model;

import java.io.Serializable;

public class Candidate implements Serializable{
	private int candidate_id;
	private String fname;
	private String lname;
	private String ssn;
	private String party;
	private String email;
	private String uname;
	private  int age;
	private String Why_running;
	private String What_things_Do_you_wnat_to_represent;
	private String profession;
	private String paswd;
	private String salt;
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getWhy_running() {
		return Why_running;
	}
	public void setWhy_running(String why_running) {
		Why_running = why_running;
	}
	public String getWhat_things_Do_you_wnat_to_represent() {
		return What_things_Do_you_wnat_to_represent;
	}
	public void setWhat_things_Do_you_wnat_to_represent(String what_things_Do_you_wnat_to_represent) {
		What_things_Do_you_wnat_to_represent = what_things_Do_you_wnat_to_represent;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPaswd() {
		return paswd;
	}
	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String toString() {
		return candidate_id+" "+fname+" "+lname+" "+ssn+" "+party+" "+email+" "+uname+" "+age+" "+Why_running+" "+What_things_Do_you_wnat_to_represent+" "+profession+" "+paswd+" "+salt;
	}

}