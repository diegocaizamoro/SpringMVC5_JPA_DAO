package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.boot.modelo.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>  {
	
	/*public List	<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public void delete(Long id);*/
	
	
	/*@Query("select c from Cliente c where c.id=?1")
	Cliente buscarPorId(Long id);
	
	
	Cliente findByNombre(String nombre);*/
	

}
