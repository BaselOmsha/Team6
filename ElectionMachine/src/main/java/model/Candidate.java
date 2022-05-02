package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="candidate_id")
	private int candidate_id;

	private int age;

	private String email;

	private String fname;

	private String lname;

	private String party;

	private String paswd;

	private String profession;

	private String salt;

	private String ssn;

	private String uname;

	private String what_things_Do_you_wnat_to_represent;

	private String why_running;

	//bi-directional many-to-one association to Vastaukset
	@OneToMany(mappedBy="candidate")
	private List<Vastaukset> vastauksets;

	public Candidate() {
	}

	public int getCandidate_id() {
		return this.candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getParty() {
		return this.party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPaswd() {
		return this.paswd;
	}

	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getWhat_things_Do_you_wnat_to_represent() {
		return this.what_things_Do_you_wnat_to_represent;
	}

	public void setWhat_things_Do_you_wnat_to_represent(String what_things_Do_you_wnat_to_represent) {
		this.what_things_Do_you_wnat_to_represent = what_things_Do_you_wnat_to_represent;
	}

	public String getWhy_running() {
		return this.why_running;
	}

	public void setWhy_running(String why_running) {
		this.why_running = why_running;
	}

	public List<Vastaukset> getVastauksets() {
		return this.vastauksets;
	}

	public void setVastauksets(List<Vastaukset> vastauksets) {
		this.vastauksets = vastauksets;
	}

	public Vastaukset addVastaukset(Vastaukset vastaukset) {
		getVastauksets().add(vastaukset);
		vastaukset.setCandidate(this);

		return vastaukset;
	}

	public Vastaukset removeVastaukset(Vastaukset vastaukset) {
		getVastauksets().remove(vastaukset);
		vastaukset.setCandidate(null);

		return vastaukset;
	}

}