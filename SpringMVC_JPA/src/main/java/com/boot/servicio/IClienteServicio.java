package com.boot.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.modelo.Cliente;

public interface IClienteServicio {
	
	public List	<Cliente> findAll();
	
	
	//metodo que trae los clientes de la base de datos con paginacion
	public  Page<Cliente>  findAll(Pageable pageable);
	
	
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public void delete(Long id);
	
	/*//metodo con @Query()
	Cliente buscarPorId(Long id);
	
	//metodo query metodo
	Cliente findByNombre(String nombre);*/

}
