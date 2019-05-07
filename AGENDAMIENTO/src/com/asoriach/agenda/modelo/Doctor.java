/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa la tabla de doctores 
 * @author angelsoriachicaiza
 *
 * Mar 11, 2019 - 9:27:06 PM
 */
public class Doctor {
	
	
	private int idDoc; 
	private String nombreDoc;
	private String apellidoDoc;
	private String especialidadDoc;
	private String sucursalDoc;
	private Date horarioDoc;
	//private String horarioDoc;
	private List <Cita> citas;

	
	/**
	 * @param idDoc
	 * @param nombreDoc
	 * @param apellidoDoc
	 * @param especialidadDoc
	 * @param sucursalDoc
	 * @param horarioDoc
	 */
	public Doctor(int idDoc, String nombreDoc, String apellidoDoc, String especialidadDoc, String sucursalDoc,
			Date horarioDoc) {
		super();
		this.idDoc = idDoc;
		this.nombreDoc = nombreDoc;
		this.apellidoDoc = apellidoDoc;
		this.especialidadDoc = especialidadDoc;
		this.sucursalDoc = sucursalDoc;
		this.horarioDoc = horarioDoc;
	}
	
	
	
	
	/**
	 * @return the idDoc
	 */
	public int getIdDoc() {
		return idDoc;
	}




	/**
	 * @param idDoc the idDoc to set
	 */
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}




	/**
	 * @return the nombreDoc
	 */
	public String getNombreDoc() {
		return nombreDoc;
	}




	/**
	 * @param nombreDoc the nombreDoc to set
	 */
	public void setNombreDoc(String nombreDoc) {
		this.nombreDoc = nombreDoc;
	}




	/**
	 * @return the apellidoDoc
	 */
	public String getApellidoDoc() {
		return apellidoDoc;
	}




	/**
	 * @param apellidoDoc the apellidoDoc to set
	 */
	public void setApellidoDoc(String apellidoDoc) {
		this.apellidoDoc = apellidoDoc;
	}




	/**
	 * @return the especialidadDoc
	 */
	public String getEspecialidadDoc() {
		return especialidadDoc;
	}




	/**
	 * @param especialidadDoc the especialidadDoc to set
	 */
	public void setEspecialidadDoc(String especialidadDoc) {
		this.especialidadDoc = especialidadDoc;
	}




	/**
	 * @return the sucursalDoc
	 */
	public String getSucursalDoc() {
		return sucursalDoc;
	}




	/**
	 * @param sucursalDoc the sucursalDoc to set
	 */
	public void setSucursalDoc(String sucursalDoc) {
		this.sucursalDoc = sucursalDoc;
	}




	/**
	 * @return the horarioDoc
	 */
	public Date getHorarioDoc() {
		return horarioDoc;
	}




	/**
	 * @param horarioDoc the horarioDoc to set
	 */
	public void setHorarioDoc(Date horarioDoc) {
		this.horarioDoc = horarioDoc;
	}




	/**
	 * @return the citas
	 */
	public List <Cita> getCitas() {
		return citas;
	}
	/**
	 * @param citas the citas to set
	 */
	public void setCitas(List <Cita> citas) {
		this.citas = citas;
	} 
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDoc;
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
		Doctor other = (Doctor) obj;
		if (idDoc != other.idDoc)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [ID :" + idDoc + ", Nombre :" + nombreDoc + ", Apellido :" + apellidoDoc
				+ ", Especialidad :" + especialidadDoc + ", Sucursal :" + sucursalDoc + ", Horario :" + horarioDoc
				+ "]";
	}
	
	
	
	
	

}
