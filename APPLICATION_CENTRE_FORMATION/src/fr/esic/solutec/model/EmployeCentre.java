package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employe_centre database table.
 * 
 */
@Entity
@Table(name="employe_centre")
@NamedQuery(name="EmployeCentre.findAll", query="SELECT e FROM EmployeCentre e")
public class EmployeCentre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_employe")
	private int idEmploye;

	private String adresse;

	private String email;

	private String nom;

	private String prenom;

	//bi-directional many-to-many association to FicheEmargement
	@ManyToMany(mappedBy="employeCentres")
	private List<FicheEmargement> ficheEmargements;

	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public EmployeCentre() {
	}

	public int getIdEmploye() {
		return this.idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<FicheEmargement> getFicheEmargements() {
		return this.ficheEmargements;
	}

	public void setFicheEmargements(List<FicheEmargement> ficheEmargements) {
		this.ficheEmargements = ficheEmargements;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}