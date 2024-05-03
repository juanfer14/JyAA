package entitys;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Items.find", query="SELECT * FROM items")
})
@Table(name="items")
public class Items implements java.io.Serializable {

	@Id
	private Long id;
	private Integer salon;
	private Integer catering;
	private Integer barra;
	private Integer vino;
	private Integer champagne;
	private Integer torta;
	private Integer animacion;
	private Integer ceremonia;
	private Integer invitacion;
	private Integer alianzas;
	private Integer servicio;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSalon() {
		return salon;
	}

	public void setSalon(Integer salon) {
		this.salon = salon;
	}

	public Integer getCatering() {
		return catering;
	}

	public void setCatering(Integer catering) {
		this.catering = catering;
	}

	public Integer getBarra() {
		return barra;
	}

	public void setBarra(Integer barra) {
		this.barra = barra;
	}

	public Integer getVino() {
		return vino;
	}

	public void setVino(Integer vino) {
		this.vino = vino;
	}

	public Integer getChampagne() {
		return champagne;
	}

	public void setChampagne(Integer champagne) {
		this.champagne = champagne;
	}

	public Integer getTorta() {
		return torta;
	}

	public void setTorta(Integer torta) {
		this.torta = torta;
	}

	public Integer getAnimacion() {
		return animacion;
	}

	public void setAnimacion(Integer animacion) {
		this.animacion = animacion;
	}

	public Integer getCeremonia() {
		return ceremonia;
	}

	public void setCeremonia(Integer ceremonia) {
		this.ceremonia = ceremonia;
	}

	public Integer getInvitacion() {
		return invitacion;
	}

	public void setInvitacion(Integer invitacion) {
		this.invitacion = invitacion;
	}

	public Integer getAlianzas() {
		return alianzas;
	}

	public void setAlianzas(Integer alianzas) {
		this.alianzas = alianzas;
	}

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}
	
	

}
