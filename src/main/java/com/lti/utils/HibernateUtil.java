package com.lti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}

	public static void closeConnection(Session s, SessionFactory sf) {
		s.close();
		sf.close();
	}
}
