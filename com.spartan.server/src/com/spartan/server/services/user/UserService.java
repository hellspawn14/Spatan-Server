package com.spartan.server.services.user;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC) 
public interface UserService extends java.rmi.Remote 
{
	@WebMethod public String register(String userName, String pass, String phoneNumber);
}
