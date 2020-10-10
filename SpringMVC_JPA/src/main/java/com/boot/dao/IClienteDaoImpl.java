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
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return entityManage.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getId()!=null && cliente.getId()>0) {
			entityManage.merge(cliente); //actualiza
		}else {
			entityManage.persist(cliente);  //crea
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return entityManage.find(Cliente.class,id);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		entityManage.remove(findOne(id));
	}

}
