package com.spartan.server.services.authentification;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;

/**
 * Servicio de autenticacion de usuarios 
 * @author hellspawn
 */
@WebService(endpointInterface = "com.spartan.server.services.authentification.AuthentificationService")
public class AuthentificationServiceImpl implements AuthentificationService
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

	public AuthentificationServiceImpl()
	{
		dbService = new DBService();
		generator = new ScriptGenerator();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	/**
	 * Servicio de acceso al sistema 
	 * Si retorna 0 el usuario o password son incorrectos
	 * @param userName - Nombre de usuario 
	 * @param password - Password
	 * @return UserId - Identificador de usuario en base de datos
	 */
	public int logIn(String userName, String password)  
	{
		int ans = 0;
		String query = generator.getUserAuth(userName);
		String passDB = null;
		int userId = 0; 
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			while (rs.next()) 
			{
				userId = rs.getInt("idUser");
				passDB = rs.getString("Password");
			}
			if (passDB.equals(password))
			{
				ans = userId;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	/**
	 * Servicio para cambiar la contraseña de un usuario 
	 * @param userName - Nombre de usuario  
	 * @param oldPass - Contraseña antigua
	 * @param newPass - Nueva contraseña
	 * @return Mensaje de confirmacion de la solicitud
	 */
	public String changePassword(String userName, String oldPass, String newPass)
	{
		String query = generator.getUserAuth(userName);
		String passDB = null;
		int userId = 0;
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			while (rs.next()) 
			{
				userId = rs.getInt("idUser");
				passDB = rs.getString("Password");
			}
			
			if (passDB.equals(oldPass))
			{
				//Cambia la contraseña 
				query = generator.updateUserPassword(userId, newPass);
				System.out.println(query);
				dbService.sendExcuteUpdate(query);
				return "Your password has been changed";
			}
			
			else
			{
				//Datos invalidos 
				return "Invalid user or pass";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Error";
	}
}
