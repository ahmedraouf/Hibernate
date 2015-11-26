package persistence;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Buyers")
public class Buyer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4619651034034731538L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Fname", length = 255, unique = true, nullable = false)
	private String Fname;
	
	@Column(name = "Lname", length = 255, unique = true, nullable = false)
	private String Lname;
	
	@Column(name = "city", length = 255, nullable = false)
	private String city;
	
	@Column(name = "age", length = 255, nullable = false)
	private Integer age;
	
	@Column(name = "phonenum", length = 255, nullable = false)
	private Integer phonenum;
	
	public Buyer() {
		id = 0;
		Fname = "";
		Lname = "";
		city = "";
		age = 0 ;
		phonenum = 0;
			}
	
	public Buyer(Integer id, String fname, String lname, String city , Integer age , Integer phonenum) {
		this.id = id;
		this.Fname = fname;
		this.Lname = lname;
		this.city = city;
		this.age = age;
		this.phonenum = phonenum; 
	}
	public Integer getId() {
		return id;
		}

	public void setId(Integer id) {
		this.id = id;
		}
	public String getFName(){
		return Fname;
		}
	public void  setFName(String fname){
		this.Fname =fname; 
	}
	
	public String getLName(){
		return Lname;
		}
	public void  setLName(String lname){
		this.Lname =lname; 
	}
	public String getCity(){
		return city;
		}
	public void  setCity(String city){
		this.city =city; 
	}
	public Integer getAge(){
		return age;
		}
	public void setAge(Integer age){
		this.age =age; 
	}
	public Integer getPhonenum(){
		return phonenum;
		}
	public void setPhonenum(Integer phonenum){
		this.phonenum =phonenum; 
		}
	
	@Override
	public String toString() {
		return id + ": " + Fname + " - "+ Lname + " - " + city + " - "  + age + " - "  + phonenum + " - ";
		}
}