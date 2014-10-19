package com.spartan.server.core;


import com.spartan.server.db.DBService;
import com.spartan.server.entities.Spartan;


/**
 * Clase responsable de orquestar los servicios y las operaciones
 * @author hellspawn
 */
public class SpartanCore 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/**
	 * Relacion con el servicio de DB
	 */
	private DBService dbService;
	
	/**
	 * Relacion con la clase principal del modelo
	 */
	private Spartan spartan;
	
	/**
	 * Relacion con el loader 
	 */
	private SpartanLoader loader;
	
	//------------------------------------------------------------------
	//Constructores 
	//------------------------------------------------------------------

	public SpartanCore()
	{
		setDbService(new DBService());
		loader = new SpartanLoader();
		setSpartan(loader.getModelInstance());
	}

	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the spartan
	 */
	public Spartan getSpartan() {
		return spartan;
	}

	/**
	 * @param spartan the spartan to set
	 */
	public void setSpartan(Spartan spartan) {
		this.spartan = spartan;
	}

	/**
	 * @return the dbService
	 */
	public DBService getDbService() {
		return dbService;
	}

	/**
	 * @param dbService the dbService to set
	 */
	public void setDbService(DBService dbService) {
		this.dbService = dbService;
	}
}