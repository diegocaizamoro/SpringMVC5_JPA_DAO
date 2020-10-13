package com.boot.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boot.dao.IClienteDao;
import com.boot.modelo.Cliente;

@Service
public class IClienteServicioImpl implements IClienteServicio {
	
	@Autowired
	private IClienteDao iClienteDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>)  iClienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		iClienteDao.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		
		return iClienteDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		iClienteDao.delete(id);
	}

}
