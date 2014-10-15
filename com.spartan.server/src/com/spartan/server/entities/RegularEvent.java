package com.spartan.server.entities;

/**
 * Representa un evento regular (No torneo)
 * @author hellspawn
 */
public class RegularEvent extends Event
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Deporte 
	 */
	private String sport;
	
	/**
	 * Descripcion del evento 
	 */
	private String description;
	
	/**
	 * Lugares disponibles
	 */
	private Spot [] availableSpots;

	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo evento regular
	 * @param sport - Es el deporte a jugar
	 * @param description - Es la descripcion del evento
	 */
	public RegularEvent(int idEvent, String date, String state, String place,String details, int spots, String eventKey, String sport,String description)
	{
		super(idEvent, date, state, place, details, spots, eventKey);
		this.sport = sport;
		this.description = description;
		this.availableSpots = new Spot[super.getSpots()];
	}

	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * @param sport the sport to set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the availableSpots
	 */
	public Spot[] getAvailableSpots() {
		return availableSpots;
	}

	/**
	 * @param availableSpots the availableSpots to set
	 */
	public void setAvailableSpots(Spot[] availableSpots) {
		this.availableSpots = availableSpots;
	}
}
