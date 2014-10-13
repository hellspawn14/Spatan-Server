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
	 * El evento esta abierto y recibiendo jugadores 
	 */
	public final static String OPEN = "Open";
	
	/**
	 * El evento esta cerrado y no recibe mas jugadores
	 */
	public final static String CLOSED = "Closed";
	
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
}
