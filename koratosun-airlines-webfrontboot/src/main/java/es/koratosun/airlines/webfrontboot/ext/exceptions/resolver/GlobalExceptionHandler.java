package es.koratosun.airlines.webfrontboot.ext.exceptions.resolver;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import es.koratosun.airlines.webfrontboot.ext.exceptions.CustomFileNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	//private static Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomFileNotFoundException.class)
    public ModelAndView handleCustomFileNotFoundException(CustomFileNotFoundException ex) {
    	//LOGGER.error("Error al descargar el archivo", ex);
        ModelAndView modelAndView = new ModelAndView("message"); // página html de retorno
        // Parámetros de la respuesta
        modelAndView.addObject("message", "El archivo solicitado no existe o no está disponible.");
        modelAndView.addObject("tipoMensaje", "alert-warning");
        return modelAndView;
    }
}