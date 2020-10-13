package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.servicio.ISubidaDeArchivosService;

@SpringBootApplication
public class SpringMvcJpaApplication  implements CommandLineRunner{
	
	@Autowired
	ISubidaDeArchivosService iSubidaDeArchivosService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//elimina y crea la casrpeta de recursos
		iSubidaDeArchivosService.deleteAll();
		iSubidaDeArchivosService.init();
	}

}
