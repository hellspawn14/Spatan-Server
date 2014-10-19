package com.spartan.server.services;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;

public class BoardService 
{
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

	public BoardService()
	{
		dbService = new DBService();
		generator = new ScriptGenerator();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------	
}
