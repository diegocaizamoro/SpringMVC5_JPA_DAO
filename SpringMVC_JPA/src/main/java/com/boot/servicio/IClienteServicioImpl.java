package com.boot.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		
		//return iClienteDao.findOne(id);
		return iClienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		//iClienteDao.delete(id);
		iClienteDao.deleteById(id);
	}

	/*@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return iClienteDao.buscarPorId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return iClienteDao.findByNombre(nombre);
	}*/

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return iClienteDao.findAll(pageable);
	}

}
