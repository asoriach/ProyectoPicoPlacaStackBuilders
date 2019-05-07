/**
 * 
 */
package com.asoriach.agenda.modelo;
import java.util.Date;

/**
 * Clase que representa la tabla de Persona como modelo sobre el cual se basan las 
 * clases que dependen o se relacionan a persona 
 * @author angelsoriachicaiza
 *
 * Mar 4, 2019 - 6:28:49 PM
 */
public class Persona {

	public static String nombrePer;
	public static String apellidoPer;
	public static String identificacionPer;
//	private String fechaNacPer;
	public static Date fechaNacPer;
	public static String direccionPer;
	public static  String telefonoPer;
	public static String correoPer;
	/**
	 * @param nombrePer
	 * @param apellidoPer
	 * @param identificacionPer
	 * @param fechaNacPer
	 * @param direccionPer
	 * @param telefonoPer
	 * @param correoPer
	 */
	public Persona(String nombrePer, String apellidoPer, String identificacionPer, Date fechaNacPer,
			String direccionPer, String telefonoPer, String correoPer) {
		
		this.nombrePer = nombrePer;
		this.apellidoPer = apellidoPer;
		this.identificacionPer = identificacionPer;
		this.fechaNacPer = fechaNacPer;
		this.direccionPer = direccionPer;
		this.telefonoPer = telefonoPer;
		this.correoPer = correoPer;
	}
	/**
	 * @return the nombrePer
	 */
	public String getNombrePer() {
		return nombrePer;
	}
	/**
	 * @param nombrePer the nombrePer to set
	 */
	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}
	/**
	 * @return the apellidoPer
	 */
	public String getApellidoPer() {
		return apellidoPer;
	}
	/**
	 * @param apellidoPer the apellidoPer to set
	 */
	public void setApellidoPer(String apellidoPer) {
		this.apellidoPer = apellidoPer;
	}
	/**
	 * @return the identificacionPer
	 */
	public String getIdentificacionPer() {
		return identificacionPer;
	}
	/**
	 * @param identificacionPer the identificacionPer to set
	 */
	public void setIdentificacionPer(String identificacionPer) {
		this.identificacionPer = identificacionPer;
	}
	/**
	 * @return the fechaNacPer
	 */
	public Date getFechaNacPer() {
		return fechaNacPer;
	}
	/**
	 * @param fechaNacPer the fechaNacPer to set
	 */
	public void setFechaNacPer(Date fechaNacPer) {
		this.fechaNacPer = fechaNacPer;
	}
	/**
	 * @return the direccionPer
	 */
	public String getDireccionPer() {
		return direccionPer;
	}
	/**
	 * @param direccionPer the direccionPer to set
	 */
	public void setDireccionPer(String direccionPer) {
		this.direccionPer = direccionPer;
	}
	/**
	 * @return the telefonoPer
	 */
	public String getTelefonoPer() {
		return telefonoPer;
	}
	/**
	 * @param telefonoPer the telefonoPer to set
	 */
	public void setTelefonoPer(String telefonoPer) {
		this.telefonoPer = telefonoPer;
	}
	/**
	 * @return the correoPer
	 */
	public String getCorreoPer() {
		return correoPer;
	}
	/**
	 * @param correoPer the correoPer to set
	 */
	public void setCorreoPer(String correoPer) {
		this.correoPer = correoPer;
	}




}