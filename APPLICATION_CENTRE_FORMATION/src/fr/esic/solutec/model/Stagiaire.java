package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stagiaire database table.
 * 
 */
@Entity
@NamedQuery(name="Stagiaire.findAll", query="SELECT s FROM Stagiaire s")
public class Stagiaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_stagiaire")
	private int idStagiaire;

	private String adresse;

	private String email;

	private String nom;

	private String prenom;

	//bi-directional many-to-many association to SessionFormation
	@ManyToMany
	@JoinTable(
		name="assiste"
		, joinColumns={
			@JoinColumn(name="id_stagiaire")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_session_formation")
			}
		)
	private List<SessionFormation> sessionFormations;

	//uni-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="id_societe")
	private Societe societe;

	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Stagiaire() {
	}

	public int getIdStagiaire() {
		return this.idStagiaire;
	}

	public void setIdStagiaire(int idStagiaire) {
		this.idStagiaire = idStagiaire;
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

	public List<SessionFormation> getSessionFormations() {
		return this.sessionFormations;
	}

	public void setSessionFormations(List<SessionFormation> sessionFormations) {
		this.sessionFormations = sessionFormations;
	}

	public Societe getSociete() {
		return this.societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}