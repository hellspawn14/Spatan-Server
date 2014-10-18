package com.spartan.server.operations;

import java.sql.SQLException;
import java.util.Hashtable;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;
import com.spartan.server.entities.Team;
import com.spartan.server.entities.User;

public class TeamOperations {

	// ------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------

	/**
	 * Relacon con la conexion con la db
	 */
	private DBService dbService;

	/**
	 * Relacion con el generador de scripts
	 */
	private ScriptGenerator scriptGen;

	// ------------------------------------------------------------------
	// Constructores
	// ------------------------------------------------------------------

	/**
	 * Crea un nuevo operador de eventos
	 * 
	 * @param dbService
	 *            - Servicio de base de datos
	 * @param scriptGen
	 *            - Servicio de generacion de scripts SQL
	 */
	public TeamOperations(DBService dbService, ScriptGenerator scriptGen) {

		this.dbService = dbService;
		this.scriptGen = scriptGen;
	}

	// ------------------------------------------------------------------
	// Metodos
	// ------------------------------------------------------------------

	/**
	 * Creates a team
	 * 
	 * @param teamName
	 * @param idCaptain
	 */
	public void createTeam(String teamName, int idCaptain) {
		String q = scriptGen.registerTeam(teamName, idCaptain);
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {

		}
	}

	/**
	 * Updates a team's name
	 * 
	 * @param t
	 *            the team
	 * @param teamName
	 */
	public void setTeamName(Team t, String teamName) {
		t.setTeamName(teamName);
	}

	/**
	 * Updates a team's captain
	 * 
	 * @param t
	 *            the team
	 * @param teamLeader
	 */
	public void setTeamLeader(Team t, User teamLeader) {
		t.setTeamLeader(teamLeader);
	}

	/**
	 * Updates a team's set of members
	 * 
	 * @param t
	 *            the team
	 * @param miembros
	 */
	public void setMiembros(Team t, Hashtable<Integer, String> miembros) {
		t.setMiembros(miembros);
	}

	/**
	 * Updates a team's ids
	 * 
	 * @param t
	 *            the team
	 * @param idTeam
	 */
	public void setIdTeam(Team t, int idTeam) {
		t.setIdTeam(idTeam);
	}
}
