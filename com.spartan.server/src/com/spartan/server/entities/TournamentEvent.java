package com.spartan.server.entities;

/**
 * Representa un evento de un torneo basico 
 * @author hellspawn
 */
public abstract class TournamentEvent extends Event
{
	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Constructor generado
	 */
	public TournamentEvent(int idEvent, String date, String state, String place, String details, int spots, String eventKey)
	{
		super(idEvent, date, state, place, details, spots, eventKey);
	}
}
