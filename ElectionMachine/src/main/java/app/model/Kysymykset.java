package app.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import app.model.*;

@Entity
@NamedQuery(name = "Kysymykset.findAll", query = "SELECT k FROM Kysymykset k")
public class Kysymykset implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kysymys_id;
	private String kysymys;

	// bi-directional many-to-one association to Fish
//	@OneToMany(targetEntity=Vastaukset.class, mappedBy = "Kysymykset", cascade = CascadeType.PERSIST)
	@OneToMany(mappedBy="kysymykset")
//	@OrderBy("kysymys_id")
	private List<Vastaukset> vastaukset;

	public Kysymykset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kysymykset(int kysymys_id, String kysymys) {
		super();
		this.kysymys_id = kysymys_id;
		this.kysymys = kysymys;
	}

	public Kysymykset(int kysymys_id) {
		// TODO Auto-generated constructor stub
		this.kysymys_id = kysymys_id;
	}

	public Kysymykset(List<Vastaukset> list) {
		// TODO Auto-generated constructor stub
		this.vastaukset = list;
	}

	public Kysymykset(Vastaukset list) {
		// TODO Auto-generated constructor stub
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

	public void setKysymys_id(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);
		} catch (NumberFormatException e) {

		}
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public List<Vastaukset> getVastaukset() {
		if (this.vastaukset == null) {
			vastaukset = new ArrayList<>();
		}
		return this.vastaukset;
	}

	public void setVastaukset(List<Vastaukset> vastaukset) {
		this.vastaukset = vastaukset;
	}

	public Vastaukset addVastaukset(Vastaukset vastaukset) {
		getVastaukset().add(vastaukset);
		vastaukset.setKysymykset(this);

		return vastaukset;
	}

	public Vastaukset removeVastaukset(Vastaukset vastaukset) {
		getVastaukset().remove(vastaukset);
		vastaukset.setKysymykset(null);

		return vastaukset;
	}

	@Override
	public String toString() {
		return "Kysymykset [kysymys_id=" + kysymys_id + ", kysymys=" + kysymys + "]";
	}

}