package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lieu database table.
 * 
 */
@Entity
@NamedQuery(name="Lieu.findAll", query="SELECT l FROM Lieu l")
public class Lieu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lieu")
	private int idLieu;

	private String adresse;

	private String nom;

	//uni-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="id_ville")
	private Ville ville;

	public Lieu() {
	}

	public int getIdLieu() {
		return this.idLieu;
	}

	public void setIdLieu(int idLieu) {
		this.idLieu = idLieu;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

}