package com.boot.servicio;

import java.util.List;
import com.boot.modelo.Cliente;

public interface IClienteServicio {
	
	public List	<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public void delete(Long id);

}
