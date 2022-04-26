package app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysymykset implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kysymys_id;
	private String kysymys;
	
	
	public Kysymykset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kysymykset(int kysymys_id, String kysymys) {
		super();
		this.kysymys_id = kysymys_id;
		this.kysymys = kysymys;
	}

	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return "Kysymykset [kysymys_id=" + kysymys_id + ", kysymys=" + kysymys + "]";
	}
	
}
