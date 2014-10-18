package com.spartan.server.entities;

/**
 * Representa un evento publico 
 * @author hellspawn
 */
public class PublicEvent 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Identificador
	 */
	private int eventId;
	
	/**
	 * Nombre del evento 
	 */
	private String eventName;
	
	/**
	 * Deporte
	 */
	private String sport;
	
	/**
	 * Organizador
	 */
	private String organizer;
	
	/**
	 * Lugar
	 */
	private String place;
	
	/**
	 * Detalles
	 */
	private String details;
	
	/**
	 * Fecha
	 */
	private String date;

	
	
	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------


	/**
	 * Crea un nuevo evento publico 
	 * @param eventId
	 * @param eventName
	 * @param sport
	 * @param organizer
	 * @param place
	 * @param details
	 * @param date
	 */
	public PublicEvent(int eventId, String eventName, String sport, String organizer, String place, String details, String date)
	{
		this.eventId = eventId;
		this.eventName = eventName;
		this.sport = sport;
		this.organizer = organizer;
		this.place = place;
		this.details = details;
		this.date = date;
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}



	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}



	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



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
	 * @return the organizer
	 */
	public String getOrganizer() {
		return organizer;
	}



	/**
	 * @param organizer the organizer to set
	 */
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
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
	

	
}
