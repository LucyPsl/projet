package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formateur database table.
 * 
 */
@Entity
@NamedQuery(name="Formateur.findAll", query="SELECT f FROM Formateur f")
public class Formateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_formateur")
	private int idFormateur;

	private String adresse;

	private float cout;

	private String email;

	private String nom;

	private String prenom;

	private String status;

	//bi-directional many-to-many association to SessionFormation
	@ManyToMany(mappedBy="formateurs")
	private List<SessionFormation> sessionFormations;

	//uni-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="id_societe")
	private Societe societe;

	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-many association to FicheEvaluation
	@ManyToMany
	@JoinTable(
		name="rempli_formateur_fiche_eval"
		, joinColumns={
			@JoinColumn(name="id_formateur")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_fiche")
			}
		)
	private List<FicheEvaluation> ficheEvaluations;

	public Formateur() {
	}

	public int getIdFormateur() {
		return this.idFormateur;
	}

	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getCout() {
		return this.cout;
	}

	public void setCout(float cout) {
		this.cout = cout;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<FicheEvaluation> getFicheEvaluations() {
		return this.ficheEvaluations;
	}

	public void setFicheEvaluations(List<FicheEvaluation> ficheEvaluations) {
		this.ficheEvaluations = ficheEvaluations;
	}

}