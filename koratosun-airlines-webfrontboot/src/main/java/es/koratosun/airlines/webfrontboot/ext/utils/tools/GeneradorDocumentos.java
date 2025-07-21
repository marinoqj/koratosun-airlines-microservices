package es.koratosun.airlines.webfrontboot.ext.utils.tools;

import java.security.SecureRandom;
import java.util.Random;

public class GeneradorDocumentos {

	/**
	 * Array de letras para calcular el NIF
	 */
	public static final String[] LETRAS_NIF = { "T", "R", "W", "A", "G", "M",
			"Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H",
			"L", "C", "K", "E" };
	/**
	 * Array de ceros para completar los DNI menores de 9 caracteres
	 */
	public static final String[] CEROS = {"0","00","000","0000"};
	
	/**
	 * Array de letras iniciales del NIE
	 */
	public static final String[] LETRAS_NIE = { "X", "Y", "Z"};
	

	/**
	 * M�todo que genera un NIF aleatoriamente
	 * @return cadena que contiene un NIF v�lido (de 9 car�cteres o menos)
	 */
	public static String generarNIF() {

		String result;
		int modulo = 0;
		int dni = 0;

		SecureRandom aleatorio = new SecureRandom();

		dni = (int) (aleatorio.nextDouble() * 99999999 + 1);

		modulo = dni % 23;

		result = dni + LETRAS_NIF[modulo];

		
		return result;

	}

	/**
	 * M�todo para obtener un NIF de 9 caracteres aunque los primeros sean ceros
	 * @return cadena que contiene un NIF v�lido (siempre de 9 car�cteres en los que las primeras posiciones son ceros si es el caso).
	 */
	public static String generarNIFCompleto() {
		
		String result;
		
		result = generarNIF();
		
		
		if(result.length() < 9){
			
			result = CEROS[9 - result.length() - 1] + result;
			
		}
		
		
		return result;
		
	}

	/**
	 * M�todo para generar CIFs de prueba. Todos tienen la misma letra de actividad
	 * @return cadena que contiene un CIF v�lido
	 */
	public static String generarCIF(){
		
		String letra_actividad = "A";		
		String parte_fija;
		int digito_control = 0;
		String CIF; 
		SecureRandom aleatorio = new SecureRandom();	
		int impar1 = 0;
		int impar3 = 0;
		int impar5 = 0;
		int impar7 = 0;
		
		double aleatorioD = aleatorio.nextDouble();
		
		
		while(aleatorioD < 0.09999999){
			
			//System.out.println(aleatorioD);
			aleatorioD = aleatorio.nextDouble();
			
		}
		

		
		parte_fija = String.valueOf((int)(aleatorioD * 9999999 + 1));
		
		//System.out.println(aleatorioD);
		//System.out.println(parte_fija + "|" + parte_fija.length());
		
		int sumaA = Integer.parseInt(String.valueOf(parte_fija.charAt(1))) 
					+ Integer.parseInt(String.valueOf(parte_fija.charAt(3))) 
					+ Integer.parseInt(String.valueOf(parte_fija.charAt(5))); 

		
		impar1 = Integer.parseInt(String.valueOf(parte_fija.charAt(0))) * 2; 
		impar3 = Integer.parseInt(String.valueOf(parte_fija.charAt(2))) * 2; 
		impar5 = Integer.parseInt(String.valueOf(parte_fija.charAt(4))) * 2;
		impar7 = Integer.parseInt(String.valueOf(parte_fija.charAt(6))) * 2;
		
		
		if (impar1 > 9) {
			impar1 = 1 + (impar1 - 10);
		}
		
		if (impar3 > 9) {
			impar3 = 1 + (impar3 - 10);
		}
		
		if (impar5 > 9) {
			impar5 = 1 + (impar5 - 10);
		}
		
		if (impar7 > 9) {
			impar7 = 1 + (impar7 - 10);
		}
		
		int sumaB = impar1 + impar3 + impar5 + impar7;

		
		int sumaC = sumaA + sumaB;

		
		digito_control = sumaC % 10;
		
		int digitoControlCorregido = (digito_control > 0) ? (10 - digito_control): 0;
		
		
		CIF = letra_actividad + parte_fija + digitoControlCorregido;
		
		return CIF;
		
		
	}
	
	/**
	 * M�todo que genera un NIE aleatoriamente
	 * @return cadena que contiene un NIE v�lido (siempre tiene 9 car�cteres)
	 */
	public static String generarNIE() {

		String result;
		int modulo = 0;
		int numeros = 0;
		int letraInicial = 0;

		SecureRandom aleatorioLetraInicial = new SecureRandom();
		
		letraInicial = aleatorioLetraInicial.nextInt(3);
		
		SecureRandom aleatorioNumeros = new SecureRandom();

		numeros = (int) (aleatorioNumeros.nextDouble() * 9999999 + 1);

		modulo = ((letraInicial*10000000 )+ numeros) % 23;

		result = LETRAS_NIE[letraInicial] + numeros + LETRAS_NIF[modulo];

		
		if(result.length() < 9){
			
			result = LETRAS_NIE[letraInicial] + CEROS[9 - result.length() - 1] + numeros + LETRAS_NIF[modulo];
			
		}
		
		
		
		return result;

	}

	public static String calcularLetraDNI(String dniS) {

		String result = null;
		
		int modulo = 0;
		
		int dni = Integer.parseInt(dniS);
		
		modulo = dni % 23;
		
		result = dni + LETRAS_NIF[modulo];
		
		return result;
	}
	
	
//	public static void main(String[] args) {
//		
//		String [] dnis = {"802109","1117921","1812296","1819989","1827584","1828851","1831425","1832846","11958899","50086152","50950397","50952107","50957128",
//						  "50962544","51377411","51650043","51889342","51891055","51891400","51893824","51899807","51900548","51900852","51903807","51906897",
//						  "51908789","51908949","51911616","51914522","51915064","51916390","51916969","51917592","51918019","51918513","51920635","51921959",
//						  "51922144","51923659","51924560","51926962","51927457","51929984","51930489","51930513","51930579","51935021","51935622","51931853",
//						  "13122864","50949579","50953351","51885098","51908498","51910657","51921398","51925078","51936605"};
//		
//		for(String unDni : dnis) {
//		
//			System.out.println(calcularLetraDNI(unDni));
//		}
//		
//		
//	}
	


}
