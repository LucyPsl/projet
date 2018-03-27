package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the possede database table.
 * 
 */
@Embeddable
public class PossedePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_formateur", insertable=false, updatable=false)
	private int idFormateur;

	@Column(name="id_theme", insertable=false, updatable=false)
	private int idTheme;

	public PossedePK() {
	}
	public int getIdFormateur() {
		return this.idFormateur;
	}
	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}
	public int getIdTheme() {
		return this.idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PossedePK)) {
			return false;
		}
		PossedePK castOther = (PossedePK)other;
		return 
			(this.idFormateur == castOther.idFormateur)
			&& (this.idTheme == castOther.idTheme);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFormateur;
		hash = hash * prime + this.idTheme;
		
		return hash;
	}
}