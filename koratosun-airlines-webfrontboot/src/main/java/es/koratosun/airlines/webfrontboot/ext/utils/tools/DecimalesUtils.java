package es.koratosun.airlines.webfrontboot.ext.utils.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalesUtils {
	
	public static final String COMA = ",";
	public static final String PUNTO = ".";
	
	private DecimalesUtils() {
		throw new IllegalStateException("Clase de Utilidad");
	}
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static String decimalToStringRedondeado(Double decimal) {
		
		return df.format(decimal);
	}
	
    public static String formatearDouble(Double value, String separadorDecimal, int numDecimales) {
    	String result = "";
    	
    	if (value != null) {
        	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(separadorDecimal.charAt(0));
            StringBuilder decimalPattern = new StringBuilder("0.");
            
            for (int i = 0; i < numDecimales; i++) {
                decimalPattern.append("0");
            }
            
            DecimalFormat decimalFormat = new DecimalFormat(decimalPattern.toString(), symbols);
            
            result = decimalFormat.format(value);    		
    	}
    
    	return result;
    }    
	
    public static String formatearDouble(String doubleValue, String separadorDecimal, int numDecimales) {
    	double value = Double.parseDouble(doubleValue);
        
        return formatearDouble(value, separadorDecimal, numDecimales);
    }
    	
	public static Double decimalToDoubleRedondeado(Double decimal) {

		BigDecimal bd = BigDecimal.valueOf(decimal);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    
	    return bd.doubleValue();
	}
	
	public static String formatearDoubleConMiles(Double value) {
		String result = "0,00";
		
        if (value != null) {
        	Locale locale = new Locale("es", "ES");
        	
        	DecimalFormatSymbols simbolos = new DecimalFormatSymbols(locale);
            
            DecimalFormat formato = new DecimalFormat("#,##0.00", simbolos);
            result = formato.format(value);
        }
        
        return result;
	}	
	
    public static Double convertirStringADouble(String numeroStr) {
    	
    	Double result = 0d;
    	
    	if(numeroStr != null && !numeroStr.equals("")) {
    		
    	    // Reemplazar el punto de las unidades de millar con una cadena vacía
            String sinPunto = numeroStr.replace(".", "");
            // Reemplazar la coma de los decimales con un punto
            String conPuntoDecimal = sinPunto.replace(",", ".");
            // Convertir el String resultante a Double
            result =  Double.valueOf(conPuntoDecimal);
    		
    	}
    	
    	return result;
  
    }	

}
