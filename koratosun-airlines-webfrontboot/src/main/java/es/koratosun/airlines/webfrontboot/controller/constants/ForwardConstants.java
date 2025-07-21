package es.koratosun.airlines.webfrontboot.controller.constants;

public class ForwardConstants {

	public static final String FWD_HEALTHCHECK = "healthcheck";
	
	public static final String FWD_INICIO = "/inicio";
	public static final String RED_INICIO = "redirect:inicio"; // Para evitar acceder directamente a la URL de login	
	public static final String FWD_LOGIN_FORM = "/login-form";
	public static final String FWD_HOME = "/home";
	public static final String FWD_MODEL_AND_VIEW_DOWNLOAD = "download";
	public static final String FWD_CHANGE_PASSWORD = "/change-password";
	public static final String FWD_MESSAGE = "/message";
	public static final String FWD_MESSAGES = "/messages";
	
	public static final String FWD_LIST_CUSTOMERS = "customers/list-customers";
	public static final String FWD_CUSTOMER_FORM = "customers/customer-form";
	public static final String FWD_CUSTOMER_REGISTRATION_FORM = "customers/customer-registration-form";
	public static final String RED_LIST_CUSTOMERS = "redirect:listCustomers";
	
	public static final String FWD_LIST_ROUTES = "flights/list-routes";
	
}

