package com.jaxws.demo;

import javax.jws.WebService;

/*
	Реализация интерфейса с логикой методов, что будут отрабатывать при обращении к серверу.
	Soap-подход построения REST применяется там,
	где критична безопасная передача данных по строгой схеме.

	Как только communication с сервером налажено - можно слать http-клиентом запросы
	на операции сервера.
	*/
@WebService(
		serviceName = "Calculate",
		portName = "CalculatePort",
		targetNamespace = "http://service.ws.sample/",
		endpointInterface = "com.jaxws.demo.ICommunicationWithClient")
public class CommunicationWithClientImpl implements ICommunicationWithClient {

	@Override
	public String calculateThisResponse(String name) {
		return "Hello " + name;
	}

	@Override
	public double sqrtCalc() {
		return 254.33;
	}

	@Override
	public AnswerEntity calculateEntity(double a, double b, double c) {
		double x1;
		double x2;
		double desc;
		try {
			desc = Math.pow(b, 2) - 4 * a * c;
			x1 = -b + Math.sqrt(desc);
			x2 = -b - Math.sqrt(desc);
			if ((Double.isNaN(x1)) || (Double.isInfinite(x1)) || (Double.isNaN(x2)) || (Double.isInfinite(x2))) {
				throw new Exception();
			}
			AnswerEntity answer = new AnswerEntity(x1, x2);
			return answer;
		} catch (Exception e) {
			return null;
		}
	}
}
