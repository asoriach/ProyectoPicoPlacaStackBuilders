/**
 * 
 */
package com.asoriach.agenda.modelo;

/**
 * Clase que representa la tabla de centros de atencion a clientes
 * @author angelsoriachicaiza
 *
 * Mar 4, 2019 - 7:44:04 PM
 */
public class CentroAntencion {

	private int idCenAten;
	private String nombreCen;
	private String ubicacionCen;
	private String sectorCen;
	/**
	 * @param idCenAten
	 * @param nombreCen
	 * @param ubicacionCen
	 * @param sectorCen
	 */
	public CentroAntencion(int idCenAten, String nombreCen, String ubicacionCen, String sectorCen) {
		
		this.idCenAten = idCenAten;
		this.nombreCen = nombreCen;
		this.ubicacionCen = ubicacionCen;
		this.sectorCen = sectorCen;
	}
	/**
	 * @return the idCenAten
	 */
	public int getIdCenAten() {
		return idCenAten;
	}
	/**
	 * @param idCenAten the idCenAten to set
	 */
	public void setIdCenAten(int idCenAten) {
		this.idCenAten = idCenAten;
	}
	/**
	 * @return the nombreCen
	 */
	public String getNombreCen() {
		return nombreCen;
	}
	/**
	 * @param nombreCen the nombreCen to set
	 */
	public void setNombreCen(String nombreCen) {
		this.nombreCen = nombreCen;
	}
	/**
	 * @return the ubicacionCen
	 */
	public String getUbicacionCen() {
		return ubicacionCen;
	}
	/**
	 * @param ubicacionCen the ubicacionCen to set
	 */
	public void setUbicacionCen(String ubicacionCen) {
		this.ubicacionCen = ubicacionCen;
	}
	/**
	 * @return the sectorCen
	 */
	public String getSectorCen() {
		return sectorCen;
	}
	/**
	 * @param sectorCen the sectorCen to set
	 */
	public void setSectorCen(String sectorCen) {
		this.sectorCen = sectorCen;
	}


	
	
}
