package es.koratosun.airlines.webfrontboot.ext;

import java.nio.file.FileSystems;

public class Constants {
	
	private Constants() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
	
	public static final String STRING_SEPARATOR = ";";
	public static final String STRING_CONCAT = "-";

	public static final String MODE = "mode";
	public static final String INSERT = "insert";
	public static final String UPDATE = "update";
	public static final String MODIFY = "modify";
	

	// Informes
	public static final String PAQUETE_OBJETOS_XML = "es.koratosun.airlines.webfrontboot.domain.xml"; 
	public static final String PAQUETE_PREFIX_MAPPER = "org.glassfish.jaxb.namespacePrefixMapper";

	// Fechas
	public static final String FECHA_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String FORMATO_FECHA_MM_DD_YYYY_CON_BARRA = "dd/MM/yyyy";
	
	
	public static final String SEPARADOR_MES_ANYO = "/";
	public static final String SEPARADOR_MUMERO_NOMBRE_MESES = "-";
	
	public static final String MESSAGE_EXCEPTION_PREFIX = "An exception occur: {0}";

}
