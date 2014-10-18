package com.spartan.server.entities;

/**
 * Representa un cupo en un evento 
 * @author hellspawn
 */
public class Spot 
{
	//------------------------------------------------------------------
	//Constantes
	//------------------------------------------------------------------
	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/**
	 * Es el estado de la confirmacion
	 */
	private String confirmation;
	
	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------
	
	/**
	 * Crea un nuevo Spot
	 * @param idUser - Es el identificador del usuario 
	 * @param idEvent - Es el identificador del evento 
	 * @param confirmation - Es la confirmacion 
	 */
	public Spot(String confirmation) 
	{
		this.confirmation = confirmation;
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------

	/**
	 * @return the confirmation
	 */
	public String getConfirmation() {
		return confirmation;
	}

	/**
	 * @param confirmation the confirmation to set
	 */
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
}
