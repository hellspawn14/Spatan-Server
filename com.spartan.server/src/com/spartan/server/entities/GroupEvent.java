package com.spartan.server.entities;

import java.util.ArrayList;

/**
 * Representa un evento de un torneo grupal 
 * @author hellspawn
 */
public class GroupEvent extends TournamentEvent
{
	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	private ArrayList <Team> participantTeams;
	
	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo evento grupal sin participantes
	 */
	public GroupEvent(int idEvent, String date, String state, String place, String details, int spots, String eventKey)
	{
		super(idEvent, date, state, place, details, spots, eventKey);
		setParticipantTeams(new ArrayList<Team>());
	}

	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------


	/**
	 * @return the participantTeams
	 */
	public ArrayList <Team> getParticipantTeams() {
		return participantTeams;
	}

	/**
	 * @param participantTeams the participantTeams to set
	 */
	public void setParticipantTeams(ArrayList <Team> participantTeams) {
		this.participantTeams = participantTeams;
	}
}
