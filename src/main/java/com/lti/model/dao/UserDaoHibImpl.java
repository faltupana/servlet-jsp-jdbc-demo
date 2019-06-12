package com.lti.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lti.model.beans.User;
import com.lti.utils.HibernateUtil;

public class UserDaoHibImpl implements UserDao {

	@Override
	public int store(User user) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(user);
		tx.commit();
		HibernateUtil.closeConnection(s, sf);
		return pk;
	}

	@Override
	public User login(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changePassword(int id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
