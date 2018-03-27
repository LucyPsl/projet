package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cursus database table.
 * 
 */
@Entity
@NamedQuery(name="Cursus.findAll", query="SELECT c FROM Cursus c")
public class Cursus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cursus")
	private int idCursus;

	private String nom;

	public Cursus() {
	}

	public int getIdCursus() {
		return this.idCursus;
	}

	public void setIdCursus(int idCursus) {
		this.idCursus = idCursus;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}