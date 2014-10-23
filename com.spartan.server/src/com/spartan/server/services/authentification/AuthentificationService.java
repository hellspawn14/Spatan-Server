
package com.spartan.server.services.authentification;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC) 
public interface AuthentificationService extends java.rmi.Remote 
{
	@WebMethod public int logIn(String userName, String password);
	@WebMethod public String changePassword(String userName, String oldPass, String newPass);
	@WebMethod public String changePass(String userName, String oldPass, String newPass);
}
