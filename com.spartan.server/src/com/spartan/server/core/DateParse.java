package com.spartan.server.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servicio para el manejo de fechas y formatos
 * @author hellspawn
 */
public class DateParse 
{
	//------------------------------------------------------------------
	//Constantes 
	//------------------------------------------------------------------
	
	/**
	 * Formato obligatorio de fecha
	 */
	private String DATE_FORMAT = "yyyy/MM/dd HH:mm";
	
	//------------------------------------------------------------------
	//Atributos 
	//------------------------------------------------------------------

	/**
	 * Formateador de fecha 
	 */
	private DateFormat dateFormat;
	
	//------------------------------------------------------------------
	//Constructores 
	//------------------------------------------------------------------

	public DateParse()
	{
		dateFormat = new SimpleDateFormat(DATE_FORMAT);
	}
	
	//------------------------------------------------------------------
	//Metodos 
	//------------------------------------------------------------------
	
	/**
	 * Pasa una fecha a string con el formato dado
	 * @param D - Es la fecha a parsear
	 * @return Fecha en formato -> YYYY/MM/dd HH:mm
	 */
	public String DateToString(Date D)
	{
		return dateFormat.format(D);
	}
	
	/**
	 * Pasa un String a Date 
	 * @param S - Es la fecha en formato -> YYYY/MM/dd HH:mm
	 * @return La fecha en date 
	 * @throws Exception - En el caso de algun error 
	 */
	public Date StringToDate(String S) throws Exception 
	{
		Date D = null;
		try
		{
			D = dateFormat.parse(S);
		}
		catch (Exception e)
		{
			throw new Exception ("Incorrect format, try again");
		}
		return D;
	}	
}
