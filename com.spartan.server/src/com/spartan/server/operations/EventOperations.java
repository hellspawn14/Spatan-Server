package com.spartan.server.operations;

import java.util.Date;

import com.spartan.server.core.DateParse;
import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;
import com.spartan.server.entities.Event;

/**
 * Conjunto de operaciones soportadas por un evento 
 * @author hellspawn
 */
public class EventOperations 
{
	//------------------------------------------------------------------
	//Atributos 
	//------------------------------------------------------------------

	/**
	 * Relacion con el parser de fecha
	 */
	private DateParse dateParse;
	
	/**
	 * Relacon con la conexion con la db
	 */
	private DBService dbService;
	
	/**
	 * Relacion con el generador de scripts
	 */
	private ScriptGenerator scriptGen;
	
	//------------------------------------------------------------------
	//Constructores 
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo operador de eventos
	 * @param dateParse - Servicio de transformacion de fechas
	 * @param dbService - Servicio de base de datos 
	 * @param scriptGen - Servicio de generacion de scripts SQL
	 */
	public EventOperations(DateParse dateParse, DBService dbService, ScriptGenerator scriptGen)
	{
		this.dateParse = dateParse;
		this.dbService = dbService;
		this.scriptGen = scriptGen;
	}
	
	
	//------------------------------------------------------------------
	//Operaciones generales 
	//------------------------------------------------------------------
	
	
	
	/**
	 * Cambia la fecha de un evento 
	 */
	public synchronized void changeDate(Event E, String nDate) throws Exception 
	{
		Date today = new Date();
		Date toChange = dateParse.StringToDate(nDate);
		
		
		
		//Compara las dos fechas
		
	}
	
	public static void main (String args[])
	{
	}

	/**
	 * Cambia los detalles generales de un evento 
	 */
	public void changeDetails(Event E, String details)
	{
		
	}
	
	/**
	 * Cambia el estado de un evento (ver com.spartan.server.enums)
	 */
	public void changeState(Event E, String state)
	{
		
	}
	
	/**
	 * Cancela un evento 
	 */
	public void cancelEvent(Event E)
	{
		
	}
	
	/**
	 * Cambia la localizacion de un evento 
	 */
	public void changeLocation(Event E, String location)
	{
		
	}
	
	/**
	 * Actualiza el numero de lugares disponibles
	 */
	public void upgradeSpots(Event E, int spots)  
	{
		
	}
	
	/**
	 * Reduce el numero de lugares disponibles
	 */
	public void downgradeSpots(Event E)
	{
		
	}
		
	//------------------------------------------------------------------
	//Regular event
	//------------------------------------------------------------------
	

	
	
	
	
}
