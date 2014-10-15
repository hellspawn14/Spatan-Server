package com.spartan.server.operations;

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
	//Operaciones generales 
	//------------------------------------------------------------------
	
	/**
	 * Cambia la fecha de un evento 
	 */
	public void changeDate(Event E, String nDate)
	{
		
	}

	/**
	 * Cambia los detalles generales de un evento 
	 */
	public void changeDetails()
	{
		
	}
	
	/**
	 * Cambia el estado de un evento (ver com.spartan.server.enums)
	 */
	public void changeState()
	{
		
	}
	
	/**
	 * Cancela un evento 
	 */
	public void cancelEvent()
	{
		
	}
	
	/**
	 * Cambia la localizacion de un evento 
	 */
	public void changeLocation()
	{
		
	}
	
	/**
	 * Actualiza el numero de lugares disponibles
	 */
	public void upgradeSpots()
	{
		
	}
	
	/**
	 * Reduce el numero de lugares disponibles
	 */
	public void downgradeSpots()
	{
		
	}
		
	//------------------------------------------------------------------
	//Regular event
	//------------------------------------------------------------------
	

	
	
	
	
}
