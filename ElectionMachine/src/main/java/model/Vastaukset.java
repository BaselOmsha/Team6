package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the vastaukset database table.
 * 
 */
@Entity
@NamedQuery(name = "Vastaukset.findAll", query = "SELECT v FROM Vastaukset v")
public class Vastaukset implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VastauksetPK id;

	private String kommentti;

	private int vastaus;

	// bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	// bi-directional many-to-one association to Kysymykset
	@ManyToOne
	@JoinColumn(name = "kysymys_ID")
	private Kysymykset kysymykset;

	public Vastaukset() {
	}

//	public Vastaukset(String vastaus, String kommentti, String candidate_id) {
//		// TODO Auto-generated constructor stub
//		try {
//			this.vastaus=Integer.parseInt(vastaus);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			this.kommentti=kommentti;
//		try {
//			this.candidate.setCandidate_id(Integer.parseInt(candidate_id));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public Vastaukset(String candidate_id, String kysymys_id, String vastaus, String kommentti) {
//		// TODO Auto-generated constructor stub
//		try {
//			this.candidate.setCandidate_id(Integer.parseInt(candidate_id));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			this.kysymykset.setKysymys_ID(Integer.parseInt(kysymys_id));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			this.vastaus=Integer.parseInt(vastaus);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			this.kommentti=kommentti;
//		
//	}
//
	public Vastaukset(int candidate_id, int kysymys_ID, int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		try {
			this.candidate.setCandidate_id(candidate_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.kysymykset.setKysymys_ID(kysymys_ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.vastaus = vastaus;
		this.kommentti = kommentti;
	}

	public Vastaukset(int candidate_id, int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		this.candidate.setCandidate_id(candidate_id);
		this.vastaus = vastaus;
		this.kommentti = kommentti;

	}

//	public Vastaukset(int candidate_id, int vastaus, String kommentti, int kysymykset) {
//		// TODO Auto-generated constructor stub
//		this.candidate.getCandidate_id();
//		this.vastaus=vastaus;
//		this.kommentti=kommentti;
//		this.kysymykset.getKysymys_ID();
//	}

	public Vastaukset(int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		this.vastaus = vastaus;
		this.kommentti = kommentti;
	}

	public Vastaukset(int vastaus, String kommentti, Candidate ca, Kysymykset k) {
		// TODO Auto-generated constructor stub
		this.vastaus = vastaus;
		this.kommentti = kommentti;
		this.candidate = ca;
		this.kysymykset = k;
	}

	public Vastaukset(String kommentti, int vastaus, int candidate_id, int kysymys_ID) {
		// TODO Auto-generated constructor stub
		this.kommentti = kommentti;
		this.vastaus = vastaus;
		
		this.id= new VastauksetPK();
		id.setCandidate_id(candidate_id);
		id.setKysymys_ID(kysymys_ID);
		
		this.candidate = new Candidate();
		this.candidate.setCandidate_id(candidate_id);
		
		this.kysymykset = new Kysymykset();
		this.kysymykset.setKysymys_ID(kysymys_ID);

	}

	public Vastaukset(String kommentti, int vastaus) {
		// TODO Auto-generated constructor stub
		this.kommentti = kommentti;
		this.vastaus = vastaus;
	}

	public VastauksetPK getId() {
		return this.id;
	}

	public void setId(VastauksetPK id) {
		this.id = id;
	}

	public String getKommentti() {
		return this.kommentti;
	}

	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

	public int getVastaus() {
		return this.vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Kysymykset getKysymykset() {
		return this.kysymykset;
	}

	public void setKysymykset(Kysymykset kysymykset) {
		this.kysymykset = kysymykset;
	}

	public boolean isOk() {
		// TODO Auto-generated method stub
		return this.vastaus > 0 && this.kommentti != null;
	}

}