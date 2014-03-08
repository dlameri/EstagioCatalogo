package com.ideaiseletronics.catalogo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AbstractDao<T> implements DaoBehavior<T>{

	@Autowired
	protected SessionFactory sessionFactory;
	
	protected AbstractDao() {
	}
	
	protected Session session() {
		if (sessionFactory == null) {
			throw new SessionException("Session Factory não pode ser nulo");
		}
		return sessionFactory.getCurrentSession();
	}
	
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public Long save(T object) {
		return (Long) session().save(object);
	}
	
	@Override
	public void update(T object) {
		session().update(object);
	}

	@Override
	public void delete(T object) {
		session().delete( session().merge(object) );
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<? extends Object> clazz) {
		return session().createCriteria( clazz ).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<? extends Object> clazz, Long id) {
		return (T) session().get(clazz, id);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
