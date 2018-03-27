package fr.esic.solutec.dao;

import java.util.Collection;

import javax.persistence.NoResultException;


import fr.esic.solutec.model.Societe;

public class DaoSociete extends Dao {
	
	
	public static Societe get(int idSociete){
	return em.find(Societe.class, idSociete);
	}
	

	public static Collection<Societe> list() {
	return em.createQuery("select u from Societe u").getResultList();
	}
	
	public static void add (Societe societe) {

	em.getTransaction().begin();
	em.persist(societe);
	em. getTransaction().commit();  
	}

	public static void remove(int idSociete) {
	em.getTransaction().begin();
	em.remove(em.find(Societe.class, idSociete));
	em.getTransaction().commit();
	}

	public static void modify(int idSociete) {
	em.getTransaction().begin();
	em.merge(em.find(Societe.class, idSociete));
	em.getTransaction().commit(); 
	}




}
