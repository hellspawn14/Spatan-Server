package com.spartan.server.operations;

import java.sql.SQLException;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;
import com.spartan.server.entities.GroupTournament;
import com.spartan.server.entities.Team;
import com.spartan.server.entities.Tournament;

public class TournamentOperations {
	/**
	 * 1. Crear torneo 2. Modificar torneo 3. Crear evento 4. Modificar evento
	 */

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
	 * Crea un nuevo operador de torneos
	 * 
	 * 
	 * @param dbService
	 *            - Servicio de base de datos
	 * @param scriptGen
	 *            - Servicio de generacion de scripts SQL
	 */
	public TournamentOperations(DBService dbService, ScriptGenerator scriptGen) {
		this.dbService = dbService;
		this.scriptGen = scriptGen;
	}

	public void createGroupTournament(String name, String description,
			String sport, String state, int idOrganizer, int nParticipants) {
		String q = scriptGen.createGroupTournament(name, description, sport,
				state, idOrganizer, nParticipants);
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}

	public void createSingleTournament(String name, String description,
			String sport, String state, int idOrganizer, int nParticipants) {
		String q = scriptGen.createSingleTournament(name, description, sport,
				state, idOrganizer, nParticipants);
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}

	public void cancelGroupTournament(GroupTournament tournmnt) {
		String q = scriptGen.cancelGroupTournament(tournmnt.getIdTournament(),
				tournmnt.getOrganizer().getUserId());
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}

	public void registerTeamInTournament(Tournament tournament, Team team) {
		String q = scriptGen.registerTeamInTournament(
				tournament.getIdTournament(), team.getIdTeam());
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}

	public void removeTeamFromTournament(Tournament tournament, Team team) {
		String q = scriptGen.removeTeamFromTournament(
				tournament.getIdTournament(), team.getIdTeam());
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}

	public void updateTeamInTournament(Tournament to, Team team, String state,
			int nPosition) {
		String q = scriptGen.updateTeamInTournament(to.getIdTournament(),
				team.getIdTeam(), state, nPosition);
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}

	public void registerGroupTournamentEvent(Tournament to, String date,
			String state, String place, String details, int nSpots, String key) {
		String q = scriptGen.registerGroupTournamentEvent(to.getIdTournament(),
				date, state, place, details, nSpots, key);
		try {
			dbService.sendQueryToDB(q);
		} catch (SQLException e) {
		}
	}
}
