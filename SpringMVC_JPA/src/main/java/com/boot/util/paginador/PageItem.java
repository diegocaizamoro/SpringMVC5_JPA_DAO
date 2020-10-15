package com.boot.util.paginador;

public class PageItem {
	
	private int numero;  //para obtener el numero de pagina
	private boolean actual;  //para saber en que pagina estoy
	
	
	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}


	public int getNumero() {
		return numero;
	}


	public boolean isActual() {
		return actual;
	}


	

}
