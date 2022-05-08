package metier;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rendezvous")
public class Rendezvous {
	
	@Id
	@Column(name = "rdvID")
	private int rdvID;
	@Column(name = "nomD")
	private String nomD ;
	@Column(name = "date")
	private String date ;
	@Column(name = "time")
	private String time ;
	@Column(name = "nomP")
	private String nomP;
	@Column(name = "description")
	private String description ;
	@Column(name = "email")
	private String email ;
	
	
	public int getRdvID() {
		return rdvID;
	}
	public void setRdvID(int rdvID) {
		this.rdvID = rdvID;
	}
	public String getNomD() {
		return nomD;
	}
	public void setNomD(String nomD) {
		this.nomD = nomD;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Rendezvous [rdvID=" + rdvID + ", nomD=" + nomD + ", date=" + date + ", nomP=" + nomP + ", description="
				+ description + ", email=" + email + ", time=" + time + "]";
	}
	
	

}
