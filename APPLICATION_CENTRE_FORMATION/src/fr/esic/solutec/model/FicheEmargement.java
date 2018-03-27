package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fiche_emargement database table.
 * 
 */
@Entity
@Table(name="fiche_emargement")
@NamedQuery(name="FicheEmargement.findAll", query="SELECT f FROM FicheEmargement f")
public class FicheEmargement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fiche_emargement")
	private int idFicheEmargement;

	@Temporal(TemporalType.DATE)
	@Column(name="date_jour")
	private Date dateJour;

	//bi-directional many-to-many association to EmployeCentre
	@ManyToMany
	@JoinTable(
		name="consulte_employe_fiche_emarg"
		, joinColumns={
			@JoinColumn(name="id_fiche_emargement")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_employe")
			}
		)
	private List<EmployeCentre> employeCentres;

	//uni-directional many-to-one association to SessionFormation
	@ManyToOne
	@JoinColumn(name="id_session_formation")
	private SessionFormation sessionFormation;

	public FicheEmargement() {
	}

	public int getIdFicheEmargement() {
		return this.idFicheEmargement;
	}

	public void setIdFicheEmargement(int idFicheEmargement) {
		this.idFicheEmargement = idFicheEmargement;
	}

	public Date getDateJour() {
		return this.dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public List<EmployeCentre> getEmployeCentres() {
		return this.employeCentres;
	}

	public void setEmployeCentres(List<EmployeCentre> employeCentres) {
		this.employeCentres = employeCentres;
	}

	public SessionFormation getSessionFormation() {
		return this.sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

}