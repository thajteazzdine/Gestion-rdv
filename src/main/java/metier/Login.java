
package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public  int uid;
	@Column(name = "nomUtilisateur")
	private String nomUtilisateur;
	@Column(name = "mdp")
	private String mdp;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	@Override
	public String toString() {
		return "Login [uid=" + uid + ", nomUtilisateur=" + nomUtilisateur + ", mdp=" + mdp + "]";
	}
	
	
	
}
