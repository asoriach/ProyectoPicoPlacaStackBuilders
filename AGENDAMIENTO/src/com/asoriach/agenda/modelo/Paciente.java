/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.util.Date;
import java.util.List;

//import java.math.BigDecimal;
//import java.util.Date;

/**
 * Clase que representa la tabla Paciente que hereda los miembros de la clase Padre Persona
 * @author angelsoriachicaiza
 *
 * Mar 4, 2019 - 6:29:30 PM
 */
public class Paciente {

	private int idPer; 
	private String nombrePer;
	private String apellidoPer;
	private String identificacionPer;
	private Date fechaNacPer;;
	private String direccionPer;
	private String telefonoPer;
	private String correoPer;
	private String generoPer;
	private String seguroPer;
	private List <Cita> citas;
	

	public Paciente(int idPer, String nombrePer, String apellidoPer, String identificacionPer, Date fechaNacPer,
			String direccionPer, String telefonoPer, String correoPer, String generoPer, String seguroPer) {
		this.idPer = idPer;
		this.nombrePer = nombrePer;
		this.apellidoPer = apellidoPer;
		this.identificacionPer = identificacionPer;
		this.fechaNacPer = fechaNacPer;
		this.direccionPer = direccionPer;
		this.telefonoPer = telefonoPer;
		this.correoPer = correoPer;
		this.generoPer = generoPer;
		this.seguroPer = seguroPer;
	}


	public Paciente() {
	}

	




	public int getIdPer() {
		return idPer;
	}


	public void setIdPer(int idPer) {
		this.idPer = idPer;
	}


	public String getNombrePer() {
		return nombrePer;
	}


	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}


	public String getApellidoPer() {
		return apellidoPer;
	}


	public void setApellidoPer(String apellidoPer) {
		this.apellidoPer = apellidoPer;
	}


	public String getIdentificacionPer() {
		return identificacionPer;
	}


	public void setIdentificacionPer(String identificacionPer) {
		this.identificacionPer = identificacionPer;
	}


	public Date getFechaNacPer() {
		return fechaNacPer;
	}


	public void setFechaNacPer(Date fechaNacPer) {
		this.fechaNacPer = fechaNacPer;
	}


	public String getDireccionPer() {
		return direccionPer;
	}


	public void setDireccionPer(String direccionPer) {
		this.direccionPer = direccionPer;
	}


	public String getTelefonoPer() {
		return telefonoPer;
	}


	public void setTelefonoPer(String telefonoPer) {
		this.telefonoPer = telefonoPer;
	}


	public String getCorreoPer() {
		return correoPer;
	}


	public void setCorreoPer(String correoPer) {
		this.correoPer = correoPer;
	}


	public String getGeneroPer() {
		return generoPer;
	}


	public void setGeneroPer(String generoPer) {
		this.generoPer = generoPer;
	}


	public String getSeguroPer() {
		return seguroPer;
	}


	public void setSeguroPer(String seguroPer) {
		this.seguroPer = seguroPer;
	}


	public List<Cita> getCitas() {
		return citas;
	}


	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nombrePer);
		builder.append("  ");
		builder.append(apellidoPer);
		return builder.toString();
	}

	
	
	
	
	
	
}
