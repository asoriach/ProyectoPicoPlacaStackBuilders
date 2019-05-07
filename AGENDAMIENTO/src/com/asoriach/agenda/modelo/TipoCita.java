/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.util.List;

/**
 * Clase que representa la tabla de Tipo de Cita 
 * @author angelsoriachicaiza
 *
 * Mar 5, 2019 - 7:23:30 PM
 */
public class TipoCita {

	private int id; 
	private String nombreCita;  
	private String sucursalCita; 
	private List <Cita> citas;
	
	//Tipos de cita pueden ser Express, Especialidad, Convenio(Seguro)
	
	/**
	 * 
	 */
	public TipoCita() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the nombreCita
	 */
	public String getNombreCita() {
		return nombreCita;
	}


	/**
	 * @param nombreCita the nombreCita to set
	 */
	public void setNombreCita(String nombreCita) {
		this.nombreCita = nombreCita;
	}


	/**
	 * @return the sucursalCita
	*/
	public String getSucursalCita() {
		return sucursalCita;
	}

	/**
	 * @param sucursalCita the sucursalCita to set
	*/
	public void setSucursalCita(String sucursalCita) {
		this.sucursalCita = sucursalCita;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nombreCita);
		builder.append("		");
		builder.append(sucursalCita);
		return builder.toString();
	}
	
	
	
	
}
