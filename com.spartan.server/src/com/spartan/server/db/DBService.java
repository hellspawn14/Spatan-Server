package com.spartan.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servicio responsable de hacer consultas a la base de datos en MySQL
 * Es responsable de conectarse con la base de datos MySQL
 * Hacer consultas y registrar cambios
 * @author hellspawn
 */
public class DBService 
{
	//------------------------------------------------------------------
	//Constantes
	//------------------------------------------------------------------
	
	/**
	 * Direccion del servidor de base de datos 
	 */
	private final static String DB_SERVER = "jdbc:mysql://127.0.0.1:3306/?user=root";
		
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Conexion con la base de datos
	 */
	private Connection DBConnection;
	
	/**
	 * Medio de conexion para enviar Queries a la DB 
	 */
	private Statement statement;
	
	/**
	 * Resultado de la consulta
	 */
	private ResultSet resultSet;
		
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	/**
	 * Crea la conexion con la base de datos 
	 * @throws ClassNotFoundException - En el caso de no encontrar el driver
	 * @throws SQLException - En el caso de encontrar errores a nivel de SQL 
	 */
	private void connectToDB() throws ClassNotFoundException, SQLException
	{
		// this will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver");
		DBConnection = DriverManager.getConnection(DB_SERVER);
		//Inicia el statement con la conexion creada
		statement = DBConnection.createStatement();
	}
	
	/**
	 * Envia una Query a la base de datos 
	 * @param Query - Es la Query a enviar a la DB 
	 * @return ResultSet de la consulta 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ResultSet sendQueryToDB(String Query) throws SQLException 
	{
		try 
		{ 
			connectToDB();
			resultSet = statement.executeQuery(Query);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public void sendExcuteUpdate(String query) throws SQLException
	{
		try {
			connectToDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statement.executeUpdate(query);
	}

	
	public void close()
	{
		try 
		{
			statement.close();
			DBConnection.close();
			resultSet.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
