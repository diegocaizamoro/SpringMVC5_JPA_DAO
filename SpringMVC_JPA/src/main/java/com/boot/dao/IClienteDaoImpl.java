package com.boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.modelo.Cliente;


@Repository
public class IClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager entityManage;
	
	
	@SuppressWarnings("unchecked")
	@Override
	
	public List<Cliente> findAll() {
		
		return entityManage.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		if(cliente.getId()!=null && cliente.getId()>0) {
			entityManage.merge(cliente); //actualiza
		}else {
			entityManage.persist(cliente);  //crea
		}
	}

	@Override
	
	public Cliente findOne(Long id) {
		return entityManage.find(Cliente.class,id);

	}

	@Override
	
	public void delete(Long id) {
		entityManage.remove(findOne(id));
	}

}
