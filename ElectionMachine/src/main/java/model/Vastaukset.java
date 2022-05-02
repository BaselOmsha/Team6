package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vastaukset database table.
 * 
 */
@Entity
@NamedQuery(name="Vastaukset.findAll", query="SELECT v FROM Vastaukset v")
public class Vastaukset implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VastauksetPK id;

	private String kommentti;

	private int vastaus;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

	//bi-directional many-to-one association to Kysymykset
	@ManyToOne
	@JoinColumn(name="kysymys_ID")
	private Kysymykset kysymykset;

	public Vastaukset() {
	}

	public Vastaukset(String vastaus, String kommentti, String candidate_id) {
		// TODO Auto-generated constructor stub
		try {
			this.vastaus=Integer.parseInt(vastaus);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			this.kommentti=kommentti;
		try {
			this.candidate.setCandidate_id(Integer.parseInt(candidate_id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vastaukset(String candidate_id, String kysymys_id, String vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		try {
			this.candidate.setCandidate_id(Integer.parseInt(candidate_id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.kysymykset.setKysymys_ID(Integer.parseInt(kysymys_id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.vastaus=Integer.parseInt(vastaus);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			this.kommentti=kommentti;
		
	}

	public Vastaukset(int candidate_id, int kysymys_id, int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		this.candidate.getCandidate_id();
		this.kysymykset.getKysymys_ID();
		this.vastaus=vastaus;
		this.kommentti=kommentti;
	}

	public Vastaukset(int candidate_id, int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		this.candidate.getCandidate_id();
		this.vastaus=vastaus;
		this.kommentti=kommentti;
		
	}

	public Vastaukset(int candidate_id, int vastaus, String kommentti, int kysymykset) {
		// TODO Auto-generated constructor stub
		this.candidate.getCandidate_id();
		this.vastaus=vastaus;
		this.kommentti=kommentti;
		this.kysymykset.getKysymys_ID();
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

}