package com.spartan.server.entities;

import java.util.ArrayList;

/**
 * Representa un torneo grupal
 * @author hellspawn
 */
public class GroupTournament extends Tournament
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Lista de equipos participantes
	 */
	private ArrayList <Team> participants;
	
	/**
	 * Lista de eventos programados
	 */
	private ArrayList <GroupEvent> tournamentEvents;
	
	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo torneo grupal sin participantes ni eventos 
	 */
	public GroupTournament(int idTournament, String tournamentName, String tournamentDescription, String sport, String state, User organizer,  int nParticipants)
	{
		super(idTournament, tournamentName, tournamentDescription, sport, state,organizer, nParticipants);
		participants = new ArrayList <Team>();
		tournamentEvents = new ArrayList<GroupEvent>();
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the participants
	 */
	public ArrayList<Team> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(ArrayList<Team> participants) {
		this.participants = participants;
	}

	/**
	 * @return the tournamentEvents
	 */
	public ArrayList<GroupEvent> getTournamentEvents() {
		return tournamentEvents;
	}

	/**
	 * @param tournamentEvents the tournamentEvents to set
	 */
	public void setTournamentEvents(ArrayList<GroupEvent> tournamentEvents) {
		this.tournamentEvents = tournamentEvents;
	}
}