package com.ideaiseletronics.web.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AbstractDao<T> implements DaoBehavior<T>{

private SessionFactory sessionFactory;
private Class objectClass;
	
	protected AbstractDao( Class objectClass ){
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		this.objectClass = objectClass;
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

	public Long save(T obj) {
		Transaction transaction = null;
		Long id = null;
		try {
			transaction = session().beginTransaction();
			id = (Long) session().save(obj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			session().close();
		}
		return id;
	}

	public void delete(T obj) {
		Transaction transaction = null;
		try {
			transaction = session().beginTransaction();
			session().delete(session().merge(obj));
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
	}
	
	public void update(T obj) {
		Transaction Transaction = null;
		try {
			Transaction = session().beginTransaction();
			session().update(obj);
			Transaction.commit();
		} catch (Exception e) {
			if (Transaction != null) {
				Transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Transaction transaction = null;
		List<T> objects = null;
		try {
			transaction = session().beginTransaction();
			objects = session().createCriteria( objectClass ).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
		
		return objects;

	}
	
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		Transaction transaction = null;
		T object = null;
		try {
			transaction = session().beginTransaction();
			object = (T) session().get( objectClass, id );
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session().close();
		}
		
		return object;
	}

}
