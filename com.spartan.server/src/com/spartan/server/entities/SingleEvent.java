package com.spartan.server.entities;

import java.util.ArrayList;

/**
 * Representa un evento de un torneo en solo
 * 
 * @author hellspawn
 */
public class SingleEvent extends Event {
	// ------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------

	/**
	 * Lista de participantes del torneo
	 */
	private ArrayList<User> participants;

	// ------------------------------------------------------------------
	// Constructores
	// ------------------------------------------------------------------

	/**
	 * Constructor generado
	 * 
	 * @param idEvent
	 * @param date
	 * @param state
	 * @param place
	 * @param details
	 * @param spots
	 * @param eventKey
	 */
	public SingleEvent(int idEvent, String date, String state, String place,
			String details, int spots, String eventKey) {
		super(idEvent, date, state, place, details, spots, eventKey);
		setParticipants(new ArrayList<User>());
	}

	// ------------------------------------------------------------------
	// Getters & Setters
	// ------------------------------------------------------------------

	/**
	 * @return the participants
	 */
	public ArrayList<User> getParticipants() {
		return participants;
	}

	/**
	 * @param participants
	 *            the participants to set
	 */
	public void setParticipants(ArrayList<User> participants) {
		this.participants = participants;
	}

	/**
	 * adds a participant. Best add one than replace the whole
	 * 
	 * @param newP
	 */
	public boolean addParticipant(User newP) {
		if (participants.size() < this.getSpots()) {
			this.participants.add(newP);
			return true;
		}
		return false;
	}
}
