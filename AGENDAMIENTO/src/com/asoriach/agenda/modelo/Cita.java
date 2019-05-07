/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.util.Date;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * Mar 18, 2019 - 12:25:45 AM
 */
public class Cita {

	private int idCita;
	private String especialidadCita; // En cita solo se va a Recibir La especialidad 
	// Tipo cita guardara el tipo de cita puede ser Express / Convenio / Particular 
	private Date fechaCita; 
//	private String surcursalCita; 
	//private int verificarSeguro; 
	
	private TipoCita tipocita;
//	private Doctor doctor; 
	private Paciente paciente;
//	private CentroAntencion centro; 

	
	
	
	public Cita() {
	}
/*	
	public Cita(int idCita, String especialidadCita, Date fechaCita, TipoCita tipocita, Paciente paciente) {
		this.idCita = idCita;
		this.especialidadCita = especialidadCita;
		this.fechaCita = fechaCita;
		this.tipocita = tipocita;
		this.paciente = paciente;
	}
*/
	public int getIdCita() {
		return idCita;
	}




	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}




	public String getEspecialidadCita() {
		return especialidadCita;
	}




	public void setEspecialidadCita(String especialidadCita) {
		this.especialidadCita = especialidadCita;
	}




	public Date getFechaCita() {
		return fechaCita;
	}




	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}




	public TipoCita getTipocita() {
		return tipocita;
	}




	public void setTipocita(TipoCita tipocita) {
		this.tipocita = tipocita;
	}




	public Paciente getPaciente() {
		return paciente;
	}




	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCita;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		if (idCita != other.idCita)
			return false;
		return true;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cita [idCita=");
		builder.append(idCita);
		builder.append(", especialidadCita=");
		builder.append(especialidadCita);
		builder.append(", fechaCita=");
		builder.append(fechaCita);
		builder.append(", tipocita=");
		builder.append(tipocita);
		builder.append(", paciente=");
		builder.append(paciente);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
