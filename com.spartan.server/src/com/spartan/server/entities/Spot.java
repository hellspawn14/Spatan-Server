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
	 * Es el identificador del usuario que lo ocupa
	 */
	private int idUser;
	
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
	public Spot(int idUser, String confirmation) 
	{
		this.idUser = idUser;
		this.confirmation = confirmation;
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

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
