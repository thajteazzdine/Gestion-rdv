package metier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hib_Session {
	
	private static Session session;
	
	static {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Login.class).addAnnotatedClass(Rendezvous.class);
		SessionFactory sf = con.buildSessionFactory();
		session = sf.openSession();
	}

	public static Session getSession() {
		return session;
	}
   
	
}


