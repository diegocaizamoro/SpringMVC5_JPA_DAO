package com.boot.servicio;

import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ISubidaDeArchivosService {
	
	public Resource load(String filename) throws  MalformedURLException; //cargar recurso ejemplo foto
	public  String copy(MultipartFile file) throws IOException;  //guarda el recurso dentro del servidor
	public boolean delete(String filename); //elimina la foto del servidor
	public void deleteAll();  //elimina todas las fotos del servidor junto con su carpeta
	public void init() throws IOException;
	

}
