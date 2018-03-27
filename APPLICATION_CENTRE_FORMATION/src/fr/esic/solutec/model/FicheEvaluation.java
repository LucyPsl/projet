package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fiche_evaluation database table.
 * 
 */
@Entity
@Table(name="fiche_evaluation")
@NamedQuery(name="FicheEvaluation.findAll", query="SELECT f FROM FicheEvaluation f")
public class FicheEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fiche")
	private int idFiche;

	//bi-directional many-to-many association to ContactSociete
	@ManyToMany
	@JoinTable(
		name="consulte_contact_fiche_eval"
		, joinColumns={
			@JoinColumn(name="id_fiche")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_contact")
			}
		)
	private List<ContactSociete> contactSocietes;

	//uni-directional many-to-one association to BilanGraphique
	@ManyToOne
	@JoinColumn(name="id_bilan")
	private BilanGraphique bilanGraphique;

	//uni-directional many-to-one association to EmployeCentre
	@ManyToOne
	@JoinColumn(name="id_employe")
	private EmployeCentre employeCentre;

	//uni-directional many-to-one association to SessionFormation
	@ManyToOne
	@JoinColumn(name="id_session_formation")
	private SessionFormation sessionFormation;

	//uni-directional many-to-one association to Stagiaire
	@ManyToOne
	@JoinColumn(name="id_stagiaire")
	private Stagiaire stagiaire;

	//bi-directional many-to-many association to Formateur
	@ManyToMany(mappedBy="ficheEvaluations")
	private List<Formateur> formateurs;

	public FicheEvaluation() {
	}

	public int getIdFiche() {
		return this.idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public List<ContactSociete> getContactSocietes() {
		return this.contactSocietes;
	}

	public void setContactSocietes(List<ContactSociete> contactSocietes) {
		this.contactSocietes = contactSocietes;
	}

	public BilanGraphique getBilanGraphique() {
		return this.bilanGraphique;
	}

	public void setBilanGraphique(BilanGraphique bilanGraphique) {
		this.bilanGraphique = bilanGraphique;
	}

	public EmployeCentre getEmployeCentre() {
		return this.employeCentre;
	}

	public void setEmployeCentre(EmployeCentre employeCentre) {
		this.employeCentre = employeCentre;
	}

	public SessionFormation getSessionFormation() {
		return this.sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

	public Stagiaire getStagiaire() {
		return this.stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public List<Formateur> getFormateurs() {
		return this.formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

}