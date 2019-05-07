/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.util.Date;

/**
 * Clase que representa la tabla de usuario 
 *
 * @author angelsoriachicaiza
 *
 * Mar 4, 2019 - 6:23:03 PM
 */
public class Usuario {

	private String nombreUsu;
	private String claveUsu;
	private Date fechaCreUsu;
	private Boolean cambioConUsu;
	/**
	 * @param nombreUsu
	 * @param claveUsu
	 * @param fechaCreUsu
	 * @param cambioConUsu
	 */
	
	public Usuario(){
		
	}
	
	public Usuario(String nombreUsu, String claveUsu, Date fechaCreUsu, Boolean cambioConUsu) {
		super();
		this.nombreUsu = nombreUsu;
		this.claveUsu = claveUsu;
		this.fechaCreUsu = fechaCreUsu;
		this.cambioConUsu = cambioConUsu;
	}
	/**
	 * @return the nombreUsu
	 */
	public String getNombreUsu() {
		return nombreUsu;
	}
	/**
	 * @param nombreUsu the nombreUsu to set
	 */
	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}
	/**
	 * @return the claveUsu
	 */
	public String getClaveUsu() {
		return claveUsu;
	}
	/**
	 * @param claveUsu the claveUsu to set
	 */
	public void setClaveUsu(String claveUsu) {
		this.claveUsu = claveUsu;
	}
	/**
	 * @return the fechaCreUsu
	 */
	public Date getFechaCreUsu() {
		return fechaCreUsu;
	}
	/**
	 * @param fechaCreUsu the fechaCreUsu to set
	 */
	public void setFechaCreUsu(Date fechaCreUsu) {
		this.fechaCreUsu = fechaCreUsu;
	}
	/**
	 * @return the cambioConUsu
	 */
	public Boolean getCambioConUsu() {
		return cambioConUsu;
	}
	/**
	 * @param cambioConUsu the cambioConUsu to set
	 */
	public void setCambioConUsu(Boolean cambioConUsu) {
		this.cambioConUsu = cambioConUsu;
	}

	
	
}
