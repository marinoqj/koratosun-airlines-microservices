package es.koratosun.airlines.webfrontboot.controller.constants;

public class UrlConstants {

	private UrlConstants() {
		throw new IllegalStateException("Utility class");
	}

	// TODO - Filtrar los path por roles

	
	
	public static final String HEALTHCHECK = "/healthcheck";
	public static final String HEALTHCHECK_JSON = "/healthcheck-json";


	public static final String VER_LOGIN = "/view-login";
	public static final String LOGIN = "/login";
	public static final String LOGIN_FAILURE = "/login-failure";
	
	// Customers
	public static final String LIST_CUSTOMERS = "/listCustomers";
	public static final String VER_CREATE_CUSTOMER = "/viewCreateCustomer";
	public static final String EDIT_CUSTOMER = "/editCustomer";
	public static final String UPDATE_CUSTOMER = "/updateCustomer";
	public static final String INSERT_CUSTOMER = "/insertCustomer";
	public static final String DELETE_CUSTOMER = "/deleteCustomer";
	
	public static final String SHOW_CUSTOMER_REGISTRATION = "/showCustomerRegistration";
	public static final String REGISTER_CUSTOMER= "/registerCustomer";

	// Front (Navegación)
	public static final String ROOT = "/";
	public static final String INICIO_PAGE = "/inicio/{page}";
	public static final String LOAD_CONNECTIONS = "/loadConnections";

	// Vuelos
	public static final String SEARCH_ROUTES_CONNECTION = "/searchRouteConnection";
}