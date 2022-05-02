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
		this.vastaus=Integer.parseInt(vastaus);
		this.kommentti=kommentti;
		this.candidate.setCandidateId(Integer.parseInt(candidate_id));
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