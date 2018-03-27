package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contact_societe database table.
 * 
 */
@Entity
@Table(name="contact_societe")
@NamedQuery(name="ContactSociete.findAll", query="SELECT c FROM ContactSociete c")
public class ContactSociete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contact")
	private int idContact;

	private String adresse;

	private String email;

	private String nom;

	private String prenom;

	//bi-directional many-to-many association to SessionFormation
	@ManyToMany(mappedBy="contactSocietes")
	private List<SessionFormation> sessionFormations;

	//bi-directional many-to-many association to BilanGraphique
	@ManyToMany
	@JoinTable(
		name="consulte_contact_bilan"
		, joinColumns={
			@JoinColumn(name="id_contact")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_bilan")
			}
		)
	private List<BilanGraphique> bilanGraphiques;

	//bi-directional many-to-many association to FicheEvaluation
	@ManyToMany(mappedBy="contactSocietes")
	private List<FicheEvaluation> ficheEvaluations;

	//uni-directional many-to-one association to Societe
	@ManyToOne
	@JoinColumn(name="id_societe")
	private Societe societe;

	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public ContactSociete() {
	}

	public int getIdContact() {
		return this.idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
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

	public List<BilanGraphique> getBilanGraphiques() {
		return this.bilanGraphiques;
	}

	public void setBilanGraphiques(List<BilanGraphique> bilanGraphiques) {
		this.bilanGraphiques = bilanGraphiques;
	}

	public List<FicheEvaluation> getFicheEvaluations() {
		return this.ficheEvaluations;
	}

	public void setFicheEvaluations(List<FicheEvaluation> ficheEvaluations) {
		this.ficheEvaluations = ficheEvaluations;
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