package com.jaxws.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://service.ws.sample/", name = "Hallo")
public interface ICommunicationWithClient {
	
	@WebResult(name = "calculate", targetNamespace = "")
	@RequestWrapper(
			localName = "calculateThis",
			targetNamespace = "http://service.ws.sample/", 
			className = "sample.ws.service.RequestCalculateThis")
	@WebMethod(action = "urn:CalculateThisResponse")
	@ResponseWrapper(
			localName = "calculateThisResponse",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.calculateThisResponse")
	String  calculateThisResponse(@WebParam(name = "name", targetNamespace = "") String name);

	default double sqrtCalc() {
		return 0;
	}

	AnswerEntity calculateEntity(double x, double y, double z);
}
