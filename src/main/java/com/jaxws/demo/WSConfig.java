package com.jaxws.demo;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WSConfig {
	private final Bus bus;

	@Autowired
	public WSConfig(Bus bus) {
		this.bus = bus;
	}

	//настройка сервиса-слушателя
	@Bean
	public Endpoint helloEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new CommunicationWithClientImpl());
		endpoint.publish("/CalculateService");

		return endpoint;
	}

//	//альтернатива создания endpoint
//	@Bean
//	public void startServer() {
//		final char exitCh = 'q';
//		try {
//			Properties prop = new Properties();
//			prop.load(new FileInputStream("application.properties"));
//			String serverEndpoint = prop.getProperty("server.endpoint");
//
//			//server activate
//			Endpoint ep = Endpoint.create(new CommunicationWithClientImpl());
//			ep.publish(serverEndpoint);
//
//			System.out.println("SOAP-сервер запущен успешно!");
//			System.out.println("Адрес сервера: " + serverEndpoint);
//			System.out.println("Введите " + exitCh + " и нажмите 'Enter' для остановки сервера ...");
//
//			char ch;  int code;
//			while (-1 != (code = System.in.read())) {
//				ch = (char) code;
//				if (ch == exitCh) {
//					ep.stop(); // ОСТАНОВКА SOAP-СЕРВЕРА
//					System.out.println("Сервер остановлен.");
//					System.out.println();
//					System.exit(0);
//				}
//			}
//
//		} catch (Exception e) {
//			System.err.println("Ошибка сервера!");
//		}
//	}
}
