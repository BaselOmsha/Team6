package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vastaukset database table.
 * 
 */
@Embeddable
public class VastauksetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="candidate_id", insertable=false, updatable=false)
	private int candidate_id;

	@Column(name="kysymys_ID", insertable=false, updatable=false)
	private int kysymys_ID;

	public VastauksetPK() {
	}
	public int getCandidate_id() {
		return this.candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public int getKysymys_ID() {
		return this.kysymys_ID;
	}
	public void setKysymys_ID(int kysymys_ID) {
		this.kysymys_ID = kysymys_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VastauksetPK)) {
			return false;
		}
		VastauksetPK castOther = (VastauksetPK)other;
		return 
			(this.candidate_id == castOther.candidate_id)
			&& (this.kysymys_ID == castOther.kysymys_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.candidate_id;
		hash = hash * prime + this.kysymys_ID;
		
		return hash;
	}
}