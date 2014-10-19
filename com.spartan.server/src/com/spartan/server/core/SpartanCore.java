package com.spartan.server.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import com.spartan.server.db.DBService;
import com.spartan.server.entities.GroupEvent;
import com.spartan.server.entities.GroupTournament;
import com.spartan.server.entities.PublicEvent;
import com.spartan.server.entities.RegularEvent;
import com.spartan.server.entities.SingleEvent;
import com.spartan.server.entities.SoloTournament;
import com.spartan.server.entities.Spartan;
import com.spartan.server.entities.Spot;
import com.spartan.server.entities.Team;
import com.spartan.server.entities.User;
import com.spartan.server.entities.UserProfile;

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