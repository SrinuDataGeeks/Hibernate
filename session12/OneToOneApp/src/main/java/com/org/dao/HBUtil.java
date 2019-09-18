package com.org.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtil {
	
	private static final SessionFactory SESSION_FACTORY;
	
	static {
		
		synchronized(HBUtil.class) {
			
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SESSION_FACTORY=cfg.buildSessionFactory();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		
		return SESSION_FACTORY;
	}

}
