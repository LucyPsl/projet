package fr.esic.solutec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_salle")
	private int idSalle;

	private int capacite;

	@Column(name="nb_poste")
	private int nbPoste;

	//uni-directional many-to-one association to Lieu
	@ManyToOne
	@JoinColumn(name="id_lieu")
	private Lieu lieu;

	//uni-directional many-to-one association to SessionFormation
	@ManyToOne
	@JoinColumn(name="id_session_formation")
	private SessionFormation sessionFormation;

	public Salle() {
	}

	public int getIdSalle() {
		return this.idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getNbPoste() {
		return this.nbPoste;
	}

	public void setNbPoste(int nbPoste) {
		this.nbPoste = nbPoste;
	}

	public Lieu getLieu() {
		return this.lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public SessionFormation getSessionFormation() {
		return this.sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

}