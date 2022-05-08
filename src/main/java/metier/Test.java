package metier;

import java.sql.Date;


public class Test {
    private static HibernatUtils hib  = new HibernatUtils();
	public static void main(String[] args) {
		
		
		long millis = System.currentTimeMillis();
	    Date date = new Date(millis);
	   
	    
        Login u1 = new Login();
		u1.setNomUtilisateur("Dr azzadine");
		u1.setMdp("azzadine");
		
		hib.InsertUtilisateur(u1);
	    
		//System.out.println(hib.check("Dr azzedine", "azzedine"));
		
		Rendezvous rdv = new Rendezvous();
		/*rdv.setRdvID(5);
		rdv.setNomD("Dr ismail");
		rdv.setDate(date);
		rdv.setNomP("mohmed");
		rdv.setDescription("nothing ");*/
		
		/*ajout un rendez vous*/
	    //hib.AjouterRDV(rdv);
		//hib.AfficherTous(hib.ListAllUtilisateur());
		/*Recherche render vous selon le id*/
		//System.out.println(hib.getbyidRDV(2).toString());
		
		/*Recherche render vous selon le nom de docteur*/
		//hib.AfficherTous(hib.getbyNameRDV("yahya"));
		
		/*mise a jour de rendez vous selon le id */
		//hib.UpdateRDV(1, "ismail",date , "azzdin", "nothing");
		
		/*supression de rendez vous selon le id */
		//hib.SupRDV(2);
		
	}

}
