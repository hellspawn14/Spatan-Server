package com.spartan.server.entities;

import java.util.Hashtable;

/**
 * Representa la clase principal de las entidades 
 * @author hellspawn
 */
public class Spartan 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Lista de usuarios activos
	 * Key -> Identificador usuario 
	 */
	private Hashtable <Integer, User> activeUsers;
	
	/**
	 * Lista de equipos registrados
	 * Key  -> Identificador del equipo 
	 */
	private Hashtable <Integer, Team> registeredTeams;
	
	/**
	 * Lista de eventos actuales
	 * Key -> Identificador del evento 
	 */
	private Hashtable <Integer, RegularEvent> currentEvents;
	
	/**
	 * Lista de torneos grupales actuales
	 * Key -> Identificador del torneo grupal 
	 */
	private Hashtable <Integer, GroupTournament> groupTournaments;
	
	/**
	 * Lista de torneos individuales actuales 
	 * Key -> Identificador del torneo individual
	 */
	private Hashtable <Integer, SoloTournament> soloTournaments;
	
	/**
	 * Lista de eventos publicos 
	 * Key -> Identificador del evento publico
	 */
	private Hashtable <Integer, PublicEvent> publicCatalog;


	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------
	
	/**
	 * Crea un nuevo Spartan 
	 * Inicializa las estructuras de datos 
	 */
	public Spartan()
	{
		activeUsers = new Hashtable <Integer, User>();
		registeredTeams = new Hashtable <Integer, Team>();
		currentEvents = new Hashtable <Integer, RegularEvent>();
		groupTournaments = new Hashtable <Integer, GroupTournament>();
		soloTournaments = new Hashtable <Integer, SoloTournament>();
		publicCatalog = new Hashtable <Integer, PublicEvent>();
	}
	
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
	public Hashtable<Integer, RegularEvent> getCurrentEvents() {
		return currentEvents;
	}


	/**
	 * @param currentEvents the currentEvents to set
	 */
	public void setCurrentEvents(Hashtable<Integer, RegularEvent> currentEvents) {
		this.currentEvents = currentEvents;
	}


	/**
	 * @return the groupTournaments
	 */
	public Hashtable<Integer, GroupTournament> getGroupTournaments() {
		return groupTournaments;
	}


	/**
	 * @param groupTournaments the groupTournaments to set
	 */
	public void setGroupTournaments(
			Hashtable<Integer, GroupTournament> groupTournaments) {
		this.groupTournaments = groupTournaments;
	}


	/**
	 * @return the soloTournaments
	 */
	public Hashtable<Integer, SoloTournament> getSoloTournaments() {
		return soloTournaments;
	}


	/**
	 * @param soloTournaments the soloTournaments to set
	 */
	public void setSoloTournaments(
			Hashtable<Integer, SoloTournament> soloTournaments) {
		this.soloTournaments = soloTournaments;
	}


	/**
	 * @return the publicCatalog
	 */
	public Hashtable<Integer, PublicEvent> getPublicCatalog() {
		return publicCatalog;
	}

	/**
	 * @param publicCatalog the publicCatalog to set
	 */
	public void setPublicCatalog(Hashtable<Integer, PublicEvent> publicCatalog) {
		this.publicCatalog = publicCatalog;
	}
	
}
