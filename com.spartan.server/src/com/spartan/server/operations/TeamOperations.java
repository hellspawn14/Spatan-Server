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
//		String q = scriptGen.changeTeamName(t.getIdTeam(), teamName);
//		try {
//			dbService.sendQueryToDB(q);
//		} catch (SQLException e) {
//
//		}
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
		String q = scriptGen.changeTeamLeader(t.getIdTeam(), teamLeader.getUserId());
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {

		}
		
	}

	/**
	 * Adds a member to the team
	 * 
	 * @param t the Team
	 * @param miembros
	 */
	public void setNewMember(Team t, User nMember) {
		String q = scriptGen.registerUserInTeam(t.getIdTeam(), nMember.getUserId());
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {

		}
	}
	/**
	 * 
	 * @param t theTeam
	 * @param toRemove
	 */
	public void removeMember(Team t, User toRemove)
	{
		String q = scriptGen.removeUserFromTeam(t.getIdTeam(), toRemove.getUserId());
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {

		}
	}
	
	//cant actually understand why do we do all thi stuff
}
