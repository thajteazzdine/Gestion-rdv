package metier;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernatUtils {

	Session session = Hib_Session.getSession();
	private Login user;
	
	
	public void InsertUtilisateur(Login ut) {
		
		/*Transaction tx = session.beginTransaction();
		session.save(ut);
		tx.commit();
		session.close();
		tx.rollback(); */
		Transaction tx = null;

		try {  
			
		    tx = session.beginTransaction();  
			//YOUR CODE HERE 
		    session.save(ut);
		    
			tx.commit();  

		}catch (Exception ex) {  
			ex.printStackTrace();  
			tx.rollback();  
		}  
		finally {
			session.close();
		}


		
	}
	
	public List<Login> ListAllUtilisateur(){
		
		List<Login> list = new ArrayList<Login>();
		
		String hql = "FROM Login";
		@SuppressWarnings("unchecked")
		Query<Login> createQuery = session.createQuery(hql);
		list = createQuery.list();

		return list;	
	}
	
	public void AfficherTous(@SuppressWarnings("rawtypes") List resultat) {
		if(resultat.isEmpty()) {
			System.out.println("Null");
		}else {
			for(int i =0;i<resultat.size();i++) {
				System.out.println(resultat.get(i).toString());
			}
		}
		
	}
	
   public void AjouterRDV(Rendezvous rdv) {
		
	   Transaction tx = null;

		try {  
			
		    tx = session.beginTransaction();  
			
		    session.save(rdv);
		    
			tx.commit();  

		}catch (Exception ex) {  
			ex.printStackTrace();  
			tx.rollback();  
		}  
		

	}
   
   
   public List<Rendezvous> getbyidRDV(int id){
	   
	    List<Rendezvous> list = new ArrayList<Rendezvous>();
		
		String hql = "FROM Rendezvous R WHERE R.rdvID=:id";
		@SuppressWarnings("unchecked")
		Query<Rendezvous> createQuery = session.createQuery(hql);
		createQuery.setParameter("id", id);
		list = createQuery.list();
		return list;
	   
   }
   
   public List<Rendezvous> getbyNameRDV(String Name){
	   
	    List<Rendezvous> list = new ArrayList<Rendezvous>();
		
		String hql = "FROM Rendezvous R WHERE R.nomD=:nomd";
		@SuppressWarnings("unchecked")
		Query<Rendezvous> createQuery = session.createQuery(hql);
		createQuery.setParameter("nomd", Name);
		list = createQuery.list();
		return list;
	   
   }
   
   public void UpdateRDV(int id,String nomD,Date date,String nomP,String desc) {
	    Transaction tx = session.beginTransaction();
	    String hql = "UPDATE Rendezvous as R set R.nomD=:nomd ,R.date=:date,R.nomP=:nomp,R.description=:desc " + 
	             "WHERE R.rdvID=:rdvid";
		@SuppressWarnings("unchecked")
		Query<Rendezvous> query = session.createQuery(hql);
		query.setParameter("nomd", nomD);
		query.setParameter("date", date);
		query.setParameter("nomp", nomP);
		query.setParameter("desc", desc);
		query.setParameter("rdvid", id);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		tx.commit();
   }
	
   public void SupRDV(int id) {
	   
	    Transaction tx = session.beginTransaction();
	    String hql = "DELETE FROM Rendezvous "  + 
	             "WHERE rdvID = :rdv_id";
		@SuppressWarnings("unchecked")
		Query<Rendezvous> query = session.createQuery(hql);
		query.setParameter("rdv_id", id);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	    tx.commit();
   }
   
   
   public boolean check(String username, String password)  {
	    user = new Login();
	    String hql ="FROM Login L WHERE L.nomUtilisateur=:u and L.mdp=:p";
	    @SuppressWarnings("unchecked")
		Query<Login> query = session.createQuery(hql);
	    query.setParameter("u", username);
	    query.setParameter("p", password);
	    
	    try {
	    	user = query.list().get(0);
	    	return true;
	    }catch(java.lang.IndexOutOfBoundsException e) {
	    	return false;
	    }
		
		
	}
   public List<Rendezvous> ListAllRdv(){
		
		List<Rendezvous> list = new ArrayList<Rendezvous>();
		
		String hql = "FROM Rendezvous";
		@SuppressWarnings("unchecked")
		Query<Rendezvous> createQuery = session.createQuery(hql);
		list = createQuery.list();
		return list;	
	}

}
