package es.koratosun.airlines.webfrontboot.ext.exceptions.resolver;

import java.io.PrintWriter;
import java.io.StringWriter;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class CustomExceptionResolver extends SimpleMappingExceptionResolver{
	
	//private static final Logger log = LogManager.getLogger(CustomExceptionResolver.class);
	
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    	String message = null;
    	String codigo = null;
    	ModelAndView view = null;
    	
//    	if(ex instanceof NullPointerException ){
//    		
//    		message = "excepcion.valor.nulo";
//    	
//    	}else if(ex instanceof LoginException){
//        		
//        	message = "excepcion.error.login";    		
//    		
//    	}else{
//    	
//    		message = "excepcion.error.desconocido";
//    	}

    	// codigo = GeneradorCodigo.generaCodigoExcepcion();
    	
    	
//    	log.error("Se produjo una excepción de tipo : " + ex.getMessage());
//    	// log.error("El código de la excepción es : " + codigo);
//    	log.error("La traza de la excepción es : " + getTraza(ex, "LOG"));
    	
    	
    	
//    	request.setAttribute(Constants.ATRIBUTO_MESSAGE, message);
//    	request.setAttribute(Constants.ATRIBUTO_CODIGO, codigo);
//    	request.setAttribute(Constants.ATRIBUTO_TRAZA, getTraza(ex, "HTML"));
    	

        view =  super.resolveException(request, response, handler, ex);
                
        return view;

    }
    
	public static String getTraza(Throwable throwable, String output) {
		
		String saltoLinea = null;
		
		if(output.equalsIgnoreCase("HTML")){
			saltoLinea = "<br>";
		}else if(output.equalsIgnoreCase("LOG")) {
			saltoLinea = "\n";
		}

		StringBuilder msg = new StringBuilder();

		msg.append(saltoLinea);
        msg.append("Tipo de excepción: " + throwable.getMessage());

        
        msg.append(saltoLinea);
        msg.append("---------------------------------------------------------------------");
        msg.append(saltoLinea);
        msg.append(saltoLinea);
        try {
            StringWriter sWriter = new StringWriter();
            PrintWriter pWriter = new PrintWriter(sWriter);
            throwable.printStackTrace(pWriter);
            msg.append(sWriter.toString());
            msg.append(saltoLinea);
            msg.append("---------------------------------------------------------------------");
            msg.append(saltoLinea);
            sWriter.close();
        } catch (Exception e) {
            msg.append(throwable.toString());
        }
        return msg.toString();		
	}

}
