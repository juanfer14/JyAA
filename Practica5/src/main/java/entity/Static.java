	package entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="statics")
public class Static implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String date;
	private String resource;
	private String ip;
	private String browser;
	
	public Static(String date, String resource, String ip, String browser) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.resource = resource;
		this.ip = ip;
		this.browser = browser;
	}

}
