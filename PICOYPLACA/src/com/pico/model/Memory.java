package com.pico.model;

import java.util.Date;

/**
 * Clase que representa la informacion recibida por el sistema 
 * @author angelsoriachicaiza
 *
 */


public class Memory {

	private String placa; 
	private String fecha;
	private String horario;
	private String mensaje;
	/**
	 * @param placa
	 * @param fecha
	 * @param horario
	 * @param mensaje
	 */
	public Memory(String placa, String fecha, String horario, String mensaje) {
		this.placa = placa;
		this.fecha = fecha;
		this.horario = horario;
		this.mensaje = mensaje;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	} 
	
	
	
	
	
}


