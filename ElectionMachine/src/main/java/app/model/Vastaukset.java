package app.model;

import java.io.Serializable;
import javax.persistence.*;
import app.model.*;

//@Entity
//@NamedQuery(name = "Vastaukset.findAll", query = "SELECT v FROM Vastaukset v")
public class Vastaukset implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidate_id;
	private int kysymys_id;
	private int vastaus;
	private String kommentti;

//	// bi-directional many-to-one association to Kid
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumns({
//		@JoinColumn(name = "ehdokas_id", referencedColumnName="candidate_id", insertable=false, updatable=false),
//		@JoinColumn(name="kysymys_id", referencedColumnName="kysymys_id", insertable=false, updatable=false)
//	})
	
	
//	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@ManyToOne
//	@JoinColumn(name = "candidate_id", referencedColumnName="candidate_id", insertable=false, updatable=false)
	private Candidate candidate;
	
//	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@ManyToOne
//	@JoinColumn(name="kysymys_id", referencedColumnName="kysymys_id", insertable=false, updatable=false)
	private Kysymykset kysymykset;
	
	public Vastaukset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vastaukset(int candidate_id, int kysymys_id, int vastaus, String kommentti) {
		super();
		this.candidate_id = candidate_id;
		this.kysymys_id = kysymys_id;
		this.vastaus = vastaus;
		this.kommentti = kommentti;
	}

	public Vastaukset(int candidate_id, int kysymys_id, int vastaus) {
		// TODO Auto-generated constructor stub
		super();
		this.candidate_id = candidate_id;
		this.kysymys_id = kysymys_id;
		this.vastaus = vastaus;
	}
	
	public Vastaukset(String candidate_id, String kysymys_id, String vastaus, String kommentti) {
		super();
		try {
			this.candidate_id=Integer.parseInt(candidate_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}
		try {
			this.kysymys_id=Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}
		try {
			this.vastaus=Integer.parseInt(vastaus);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}
		
		this.kommentti = kommentti;
	}
	
	public Vastaukset(String vastaus, String kommentti, String candidate_id) {
		super();
		try {
			this.candidate_id=Integer.parseInt(candidate_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}

		try {
			this.vastaus=Integer.parseInt(vastaus);
		}
		catch(NumberFormatException | NullPointerException e) {
	
		}
		
		this.kommentti = kommentti;
	}

	public Vastaukset(Candidate candidate, Kysymykset kysymykset, int vastaus) {
		super();
		this.candidate = candidate;
		this.kysymykset = kysymykset;
		this.vastaus = vastaus;
	}

	public Vastaukset(int candidate_id, Kysymykset k, String vastaus) {
		// TODO Auto-generated constructor stub
	
	}

	public Vastaukset(Kysymykset kys) {
		// TODO Auto-generated constructor stub
	}

	public Vastaukset(Candidate c, int vASTAUS2) {
		// TODO Auto-generated constructor stub
		this.candidate = c;
		
		this.vastaus = vASTAUS2;
	}

	public Vastaukset(int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		this.vastaus = vastaus;
		this.kommentti = kommentti;
	}

	public Vastaukset(Candidate c, Kysymykset k, int vastaus2, String kommentti2) {
		// TODO Auto-generated constructor stub
		this.candidate = c;
		this.kysymykset = k;
		this.vastaus = vastaus2;
		this.kommentti = kommentti2;
	}

	public Vastaukset(int candidate_id, int vastaus, String kommentti) {
		// TODO Auto-generated constructor stub
		this.candidate_id = candidate_id;
		this.vastaus = vastaus;
		this.kommentti = kommentti;

	}


	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int ehdokas_id) {
		this.candidate_id = ehdokas_id;
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

	public int getVastaus() {
		return vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}

	public String getKommentti() {
		return kommentti;
	}

	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
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
		return this.candidate_id>0 && this.kysymys_id>0 && this.vastaus>0 && this.kommentti!=null;
	}

}
