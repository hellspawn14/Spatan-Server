package com.spartan.server.services.event;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;

public class EventServiceImpl 
{
	/*
	 * Operaciones 
	 * 1. Buscar evento regular 
	 * 2. Crear evento regular
	 * 3. Cancelar evento 
	 * 4. Registrarse en evento 
	 * 5. Cancelar registro 
	 * 6. Obtener registros de un usuario 
	 */
	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/**
	 * Relacion con el servicio de conexion a base de datos
	 */
	private DBService dbService;
	
	/**
	 * Relacion con el servicio de generacion de Queries
	 */
	private ScriptGenerator generator;

	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	public EventServiceImpl()
	{
		dbService = new DBService();
		generator = new ScriptGenerator();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	
	
	
	
}
