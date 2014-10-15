package com.spartan.server.operations;

import com.spartan.server.entities.RegularEvent;
import com.spartan.server.entities.Spot;

public class UserOperations 
{
	public void createEvent()
	{
		
	}
	
	/**
	 * Registra un nuevo Spot
	 * @param Re - Es el evento a registrar
	 */
	public void registerSpot(RegularEvent Re)
	{
		Spot S = new Spot(this.userId,com.spartan.server.enums.State.TO_ASSIST);
		currentSpots.add(S);
		try 
		{
			Re.addSpot(S);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Libera el lugar ocupado en un evento 
	 * @param Re - Es el evento a cambiar
	 */
	public void clearSpot(RegularEvent Re)
	{
		
	}

}
