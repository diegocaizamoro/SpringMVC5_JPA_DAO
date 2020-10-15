package com.boot.util.paginador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;
	
	private int totalPaginas;
	private int  numElementosPorPagina;
	
	private int paginaActual;
	
	private List<PageItem>  paginas;

	public PageRender(String url, Page<T> page) {
	
		this.url = url;
		this.page = page;
		
		this.paginas=new ArrayList<PageItem>();
		
		numElementosPorPagina=6;
		totalPaginas=page.getTotalPages();
		
		paginaActual=page.getNumber()+1;
		
		int desde, hasta;
		
		if(totalPaginas<=numElementosPorPagina) {
			desde=1;
			hasta=totalPaginas;
		}else {
			
			if(paginaActual<=numElementosPorPagina /2) {
				desde=1;
				hasta=numElementosPorPagina;
				//validacion para obtener las paginas segun vayamos navegando
			} else if(paginaActual>=totalPaginas-numElementosPorPagina / 2) {   
				
				desde=totalPaginas-numElementosPorPagina +1;
				hasta=numElementosPorPagina;   
			}else {
				desde=paginaActual-numElementosPorPagina/2;
				hasta=numElementosPorPagina;
			}
			
		}
		
		//recorro las paginas
		for(int i=0; i<hasta; i++){  
			paginas.add(new PageItem(desde+i,paginaActual==desde +i));
		}
		
		
	}

	public String getUrl() {
		return url;
	}

	public Page<T> getPage() {
		return page;
	}


	public int getTotalPaginas() {
		return totalPaginas;
	}


	public int getPaginaActual() {
		return paginaActual;
	}


	public List<PageItem> getPaginas() {
		return paginas;
	}
   //metodo boolean que devuelve si estamos en la primera pagina
    public boolean isFirst() {
    	return page.isFirst();
    }
	
  //metodo boolean que devuelve si estamos en la ultima pagina
    public boolean isLast() {
    	return page.isLast();
    }
     
  //metodo boolean que devuelve si estamos navegando hACIA la siguiente pagina
    public boolean isHasNext() {
    	return page.hasNext();
    }
    
	
    //metodo boolean que devuelve si estamos navegando hACIA atras
    public boolean isHasPrevious() {
    	return page.hasPrevious();
    }
    
}
