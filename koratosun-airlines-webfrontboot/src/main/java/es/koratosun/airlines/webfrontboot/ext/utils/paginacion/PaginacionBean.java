package es.koratosun.airlines.webfrontboot.ext.utils.paginacion;

import java.io.Serializable;

public class PaginacionBean implements Serializable{


	private static final long serialVersionUID = 1L;

	private int inicio = 0;
	private int elementosXpagina = 20;
	private int totalRegistros;
	private int totalPaginas;

	
	
	public int getElementosXpagina() {
		return elementosXpagina;
	}
	public void setElementosXpagina(int elementosXpagina) {
		this.elementosXpagina = elementosXpagina;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	public int getTotalPaginas() {
		
		double dTotalRegistros = totalRegistros;
		double dElementosXPagina = elementosXpagina;
		
		double result = Math.ceil(dTotalRegistros / dElementosXPagina);		
		
		return (int)result;
		
	}

	public int getFin(){
		
		return this.inicio + this.elementosXpagina;
	}
	
	public int getPaginaActual(){
		
		return Double.valueOf((this.inicio + this.elementosXpagina - 1)/this.elementosXpagina).intValue();
		
	}
	
}
