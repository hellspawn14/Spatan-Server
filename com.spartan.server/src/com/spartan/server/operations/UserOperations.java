package com.spartan.server.operations;

import com.spartan.server.entities.RegularEvent;
import com.spartan.server.entities.Spot;

public class UserOperations 
{

	
	/**
	 * Operaciones del usuario 
	 * 1. Crear nuevo usuario 
	 * 2. Ingresar al sistema
	 * 3. Cambiar contraseña
	 * 3. Ingresar a equipo
	 * 4. Modificar perfil
	 * 5. Crear torneo
	 * 6. Crear evento
	 * 7. Crear asistencia 
	 * 8. Modificar asistencia
	 * 9. Crear equipo
	 */
	
	/**
	 * Registra un nuevo usuario en el sistema 
	 * Proceso de registro de un usuario 
	 * 1. Registrar el usuario en la tabla Users 
	 * 2. Registrar el usuario en la tabla Auth
	 * 3. Registrar el usuario en el Score
	 * 4. Registrar la historia del usuario
	 */
	public void registerNewUser()
	{
		
	}
	
	public void updateUserPassword()
	{
		/**
		 * Proceso de actulizacion de contraseña
		 */
	}
	
	public void createEvent()
	{
		
	}
	
	/**
	 * Registra un nuevo Spot
	 * @param Re - Es el evento a registrar
	 */
	public void registerSpot(RegularEvent Re)
	{

	}
	
	/**
	 * Libera el lugar ocupado en un evento 
	 * @param Re - Es el evento a cambiar
	 */
	public void clearSpot(RegularEvent Re)
	{
		
	}

}
