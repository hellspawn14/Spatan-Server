package com.spartan.server.enums;

/**
 * Enumeracion con los posibles estados de un juego y los estados de los participantes de un torneo
 * @author hellspawn
 */
public class State 
{

	//------------------------------------------------------------------
	//Estados de eventos
	//------------------------------------------------------------------

	/**
	 * El evento esta abierto, recibiendo jugadores el torneo no ha comenzado
	 */
	public final static String OPEN = "Open";
	
	/**
	 * El evento esta por comenzar y no recibe mas juegadores
	 */
	public final static String TO_START = "ToStart";
	
	/**
	 * El evento ya fue iniciado
	 */
	public final static String STARTED = "Started";
	
	/**
	 * El evento ha terminado
	 */
	public final static String ENDED = "Ended";
	
	//------------------------------------------------------------------
	//Estados de los participantes de un torneo
	//------------------------------------------------------------------

	/**
	 * Indica que un participante esta participando en un torneo 
	 */
	public final static String IN = "In";
	
	/**
	 * Indica que el participante esta fuera de un torneo
	 */
	public final static String OUT = "Out";
	
	//------------------------------------------------------------------
	//Tipos de torneos
	//------------------------------------------------------------------

	/**
	 * Torneo publico 
	 */
	public final static String PUBLIC = "Public";
	
	/**
	 * Torneo privado
	 */
	public final static String PRIVATE = "Private";
	
	//------------------------------------------------------------------
	//Confirmacion de asistencias
	//------------------------------------------------------------------

	/**
	 * Por asistir
	 */
	public final static String TO_ASSIST = "ToAssist";
	
	/**
	 * Ya esta en el sitio 
	 */
	public final static String CONFIRMED = "Confirmed";
	
	/**
	 * No asistio 
	 */
	public final static String DID_NO_ASSIST = "NoAssisted"; 
	
}
