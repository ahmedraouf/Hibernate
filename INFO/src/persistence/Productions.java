package persistence;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productions")
public class Productions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4619651034034731538L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "proname", length = 255, unique = true, nullable = false)
	private String proname;
	
	@Column(name = "procategory", length = 255, unique = true, nullable = false)
	private String procategory;
	
	@Column(name = "prosize", length = 255, nullable = false)
	private Integer prosize;
	
	@Column(name = "proprice ", length = 255, nullable = false)
	private Integer proprice ;
	
	@Column(name = "procolor", length = 255, nullable = false)
	private String procolor;
	
	public Productions() {
		id = 0;
		proname = "";
		procategory = "";
		prosize = 0;
		proprice = 0 ;
		procolor = "";
			}
	
	public Productions(Integer id, String proname, String procategory, Integer prosize , Integer proprice , String procolor) {
		this.id = id;
		this.proname = proname;
		this.procategory = procategory;
		this.prosize = prosize;
		this.proprice = proprice;
		this.procolor = procolor; 
	}
	public Integer getId() {
		return id;
		}

	public void setId(Integer id) {
		this.id = id;
		}
	public String getProname(){
		return proname;
		}
	public void  setProname(String proname){
		this.proname =proname; 
	}
	
	public String getProcategory(){
		return procategory;
		}
	public void  setProcategory(String procategory){
		this.procategory =procategory; 
	}
	public Integer getProsize(){
		return prosize;
		}
	public void  setCity(Integer prosize){
		this.prosize =prosize; 
	}
	public Integer getProprice(){
		return proprice;
		}
	public void setProprice(Integer proprice){
		this.proprice =proprice; 
	}
	public String getProcolor(){
		return procolor;
		}
	public void setProcolor(String procolor){
		this.procolor =procolor; 
		}
	
	@Override
	public String toString() {
		return id + ": " + proname + " - "+ procategory + " - " + prosize + " - "  + proprice + " - "  + procolor + " - ";
		}
}