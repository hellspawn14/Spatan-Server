package com.spartan.server.entities;

import java.util.ArrayList;

public class SoloTournament extends Tournament
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Lista de eventos 
	 */
	private ArrayList <SingleEvent> tournamentEvents;
	
	/**
	 * Lista de participantes
	 */
	private ArrayList <User> participants;
	
	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo torneo de singles sin eventos ni participantes
	 */
	public SoloTournament(int idTournament, String tournamentName, String tournamentDescription, String sport, String state, User organizer, int nParticipants) 
	{
		super(idTournament, tournamentName, tournamentDescription, sport, state, organizer, nParticipants);
		tournamentEvents = new ArrayList <SingleEvent>();
		participants = new ArrayList <User>();
	}


	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the tournamentEvents
	 */
	public ArrayList<SingleEvent> getTournamentEvents() {
		return tournamentEvents;
	}

	/**
	 * @param tournamentEvents the tournamentEvents to set
	 */
	public void setTournamentEvents(ArrayList<SingleEvent> tournamentEvents) {
		this.tournamentEvents = tournamentEvents;
	}

	/**
	 * @return the participants
	 */
	public ArrayList<User> getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(ArrayList<User> participants) {
		this.participants = participants;
	}

}
