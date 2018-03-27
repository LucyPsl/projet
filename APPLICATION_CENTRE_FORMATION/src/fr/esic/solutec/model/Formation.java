package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formation database table.
 * 
 */
@Entity
@NamedQuery(name="Formation.findAll", query="SELECT f FROM Formation f")
public class Formation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_formation")
	private int idFormation;

	private String description;

	private int duree;

	private String niveau;

	private String nom;

	@Column(name="prix_inter")
	private float prixInter;

	@Column(name="prix_intra")
	private float prixIntra;

	//uni-directional many-to-one association to Cursus
	@ManyToOne
	@JoinColumn(name="id_cursus")
	private Cursus cursus;

	//uni-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="id_theme")
	private Theme theme;

	public Formation() {
	}

	public int getIdFormation() {
		return this.idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrixInter() {
		return this.prixInter;
	}

	public void setPrixInter(float prixInter) {
		this.prixInter = prixInter;
	}

	public float getPrixIntra() {
		return this.prixIntra;
	}

	public void setPrixIntra(float prixIntra) {
		this.prixIntra = prixIntra;
	}

	public Cursus getCursus() {
		return this.cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}