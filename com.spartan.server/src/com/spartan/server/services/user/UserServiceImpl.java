package com.spartan.server.services.user;

import java.sql.ResultSet;

import javax.jws.WebService;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;

/**
 * Implementacion del servicio de usuario
 * @author hellspawn
 */
//"com.spartan.server.services.authentification.AuthentificationService"
@WebService(endpointInterface = "com.spartan.server.services.user.UserService")
public class UserServiceImpl 
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

	public UserServiceImpl()
	{
		dbService = new DBService();
		generator = new ScriptGenerator();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------

	/**
	 * Registra un usuario en el sistema 
	 * @param userName - Es el nombre del usuario 
	 * @param pass - Es la contraseña 
	 * @param phoneNumber - Es el numero telefonico 
	 * @return Mensaje de confirmacion/rechazo 
	 */
	public String register(String userName, String pass, String phoneNumber)
	{
		//Verificar que no exista otro usuario con el mismo nombre 
		String ans = "";
		int res = 0;
		String query = generator.getUserId(userName);
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			while (rs.next()) 
			{
				res = rs.getInt("idUser");
			}
			//El usuario ya existe 
			if (res != 0)
			{
				ans = "User already exists sorry";
				System.out.println(ans + "1");
			}
			//El usuario se puede registrar 
			else
			{
				//Verificar que el numero no exista
				query = generator.getUserIdByPhone(phoneNumber.trim());
				rs = dbService.sendQueryToDB(query);
				while (rs.next()) 
				{
					res = rs.getInt("idUser");
				}
				//El numero ya existe 
				if (res != 0)
				{
					ans = "Phone number already in use";
					System.out.println("ans" + 2);
				}
				//El numero no existe registrar 
				else
				{
					//Registra en users
					query = generator.registerUser(userName, phoneNumber, pass);
					dbService.sendExcuteUpdate(query);
					//Registra en auth
					query = generator.getUserId(userName);
					rs = dbService.sendQueryToDB(query);
					while (rs.next()) 
					{
						res = rs.getInt("idUser");
					}
					query = generator.registerUserAuth(res, pass);
					dbService.sendExcuteUpdate(query);
					query = generator.registerUserHistory(res);
					dbService.sendExcuteUpdate(query);
					query = generator.registerUserScore(res);
					dbService.sendExcuteUpdate(query);
					dbService.sendExcuteUpdate("COMMIT;");
					ans = "Registration success!";
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		UserServiceImpl S = new UserServiceImpl();
		S.register("kiraxy","123456","102");
	}
}
