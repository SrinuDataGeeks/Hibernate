package com.datageeks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FacebookDAO {

	SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public void saveOrUpdate(FacebookPost fbPost) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(fbPost);
		session.getTransaction().commit();
		session.close();
	}

	public FacebookPost get(Integer postId) {
		return sessionFactory.openSession().get(FacebookPost.class, postId);
	}

	public void delete(Integer postId) {
		Session session = sessionFactory.openSession();
		FacebookPost fbPost = session.get(FacebookPost.class, postId);
		;
		if (fbPost != null) {
			session.beginTransaction();
			session.delete(fbPost);
			session.getTransaction().commit();
		}
		session.close();
	}

	public List<FacebookPost> getAll() {
		return sessionFactory.openSession().createQuery("Select fp from FacebookPost as fp", FacebookPost.class)
				.getResultList();
	}

}
