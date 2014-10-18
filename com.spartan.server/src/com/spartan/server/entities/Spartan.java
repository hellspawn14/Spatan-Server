package com.spartan.server.entities;

import java.util.Hashtable;

public class Spartan 
{
	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Lista de usuarios activos
	 * Key -> Id
	 */
	private Hashtable <Integer, User> activeUsers;
	
	/**
	 * Lista de equipos registrados
	 * Key  -> Team name
	 */
	private Hashtable <Integer, Team> registeredTeams;
	
	/**
	 * Lista de eventos actuales
	 */
	private Hashtable <Integer, Event> currentEvents;
	
	/**
	 * Lista de torneos actuales
	 */
	private Hashtable <Integer, Tournament> currentTournaments;
	
	/**
	 * Lista de eventos publicos 
	 */
	private Hashtable <Integer, PublicEvent> publicCatalog;


	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------
	
	
	
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the activeUsers
	 */
	public Hashtable<Integer, User> getActiveUsers() {
		return activeUsers;
	}

	/**
	 * @param activeUsers the activeUsers to set
	 */
	public void setActiveUsers(Hashtable<Integer, User> activeUsers) {
		this.activeUsers = activeUsers;
	}

	/**
	 * @return the registeredTeams
	 */
	public Hashtable<Integer, Team> getRegisteredTeams() {
		return registeredTeams;
	}

	/**
	 * @param registeredTeams the registeredTeams to set
	 */
	public void setRegisteredTeams(Hashtable<Integer, Team> registeredTeams) {
		this.registeredTeams = registeredTeams;
	}

	/**
	 * @return the currentEvents
	 */
	public Hashtable<Integer, Event> getCurrentEvents() {
		return currentEvents;
	}

	/**
	 * @param currentEvents the currentEvents to set
	 */
	public void setCurrentEvents(Hashtable<Integer, Event> currentEvents) {
		this.currentEvents = currentEvents;
	}

	/**
	 * @return the currentTournaments
	 */
	public Hashtable<Integer, Tournament> getCurrentTournaments() {
		return currentTournaments;
	}

	/**
	 * @param currentTournaments the currentTournaments to set
	 */
	public void setCurrentTournaments(
			Hashtable<Integer, Tournament> currentTournaments) {
		this.currentTournaments = currentTournaments;
	}

	/**
	 * @return the publicCatalog
	 */
	public Hashtable <Integer, PublicEvent> getPublicCatalog() {
		return publicCatalog;
	}

	/**
	 * @param publicCatalog the publicCatalog to set
	 */
	public void setPublicCatalog(Hashtable <Integer, PublicEvent> publicCatalog) {
		this.publicCatalog = publicCatalog;
	}
	
	

}
