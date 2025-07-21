package es.koratosun.airlines.flights.controller.constants;

public class UrlConstants {

	public static final String ID_CONNECTION = "/{idConnection}";
	public static final String URL_FLIGHTS = "/flights";
	public static final String COD_ORIGIN_PATH = "/{codOrigin}";
	public static final String CONNECTIONS_PATH = "/connections";
	public static final String CONNECTIONS_DEPARTURE_ARRIVAL_PATH = CONNECTIONS_PATH +"/{departure}/{arrival}";
	public static final String ID_CONNECTION_PATH = CONNECTIONS_PATH + ID_CONNECTION;
	public static final String DESTINATIONS_PATH = "/destinations/{origin}";

}
