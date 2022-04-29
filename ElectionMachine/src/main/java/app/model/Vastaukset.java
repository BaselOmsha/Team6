package app.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vastaukset implements  Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ehdokas_id;
	private int kysymys_id;
	private String vastaus;
	private String kommentti;
	
	public Vastaukset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Vastaukset(int ehdokas_id, int kysymys_id, String vastaus, String kommentti) {
		super();
		this.ehdokas_id = ehdokas_id;
		this.kysymys_id = kysymys_id;
		this.vastaus = vastaus;
		this.kommentti = kommentti;
	}


	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public String getVastaus() {
		return vastaus;
	}
	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}
	public String getKommentti() {
		return kommentti;
	}
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}
	
	
}
