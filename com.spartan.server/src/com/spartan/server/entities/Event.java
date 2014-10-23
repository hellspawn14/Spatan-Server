package com.spartan.server.entities;

/**
 * Representa un evento disponible
 * @author hellspawn
 */
public abstract class Event 
{	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Identificador del evento
	 */
	private int idEvent;
	
	/**
	 * Fecha del evento YYYY/MM/dd HH:mm
	 */
	private String date;
	
	/**
	 * Estado del evento -> Ver com.spartan.server.enums
	 */
	private String state;
	
	/**
	 * Lugar del evento (coordenadas de google maps)
	 */
	private String place;
	
	/**
	 * Detalles adicionales del evento 
	 */
	private String details;
	
	/**
	 * Numero de spots disponibles (se puede cambiar)
	 */
	private int spots;

	/**
	 * Clave del evento 
	 */
	private String eventKey;


	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------
	
	/**
	 * Crea un nuevo evento generico 
	 * @param idEvent - Es el identificador del evento 
	 * @param date - Es la fecha del evento 
	 * @param state - Es el estado del evento 
	 * @param place - Es el lugar del evento 
	 * @param details - Corresponde a los detalles del evento 
	 * @param spots - Corresponde al numero de participantes 
	 * @param eventKey - Corresponde a la clave del evento 
	 */
	public Event(int idEvent, String date, String state, String place, String details, int spots, String eventKey) 
	{
		this.idEvent = idEvent;
		this.date = date;
		this.state = state;
		this.place = place;
		this.details = details;
		this.spots = spots;
		this.eventKey = eventKey;
	}

	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the idEvent
	 */
	public int getIdEvent() {
		return idEvent;
	}


	/**
	 * @param idEvent the idEvent to set
	 */
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}


	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}


	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}


	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}


	/**
	 * @return the spots
	 */
	public int getSpots() {
		return spots;
	}


	/**
	 * @param spots the spots to set
	 */
	public void setSpots(int spots) {
		this.spots = spots;
	}


	/**
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
