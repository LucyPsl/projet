package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the possede database table.
 * 
 */
@Entity
@NamedQuery(name="Possede.findAll", query="SELECT p FROM Possede p")
public class Possede implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PossedePK id;

	private String niveau;

	//uni-directional many-to-one association to Formateur
	@ManyToOne
	@JoinColumn(name="id_formateur",insertable=false,updatable=false)
	private Formateur formateur;

	//uni-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="id_theme",insertable=false,updatable=false)
	private Theme theme;

	public Possede() {
	}

	public PossedePK getId() {
		return this.id;
	}

	public void setId(PossedePK id) {
		this.id = id;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Formateur getFormateur() {
		return this.formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}