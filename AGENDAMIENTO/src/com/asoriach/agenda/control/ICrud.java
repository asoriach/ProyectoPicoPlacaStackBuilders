/**
 * 
 */
package com.asoriach.agenda.control;

/**
 * Clase que representa el contrato de negocio para las operaciones de la bdd
 * @author angelsoriachicaiza
 *
 * Mar 5, 2019 - 8:39:10 PM
 */
public interface ICrud {

	public String guardar(Object registro);
	
	public String actualizar (int id, Object registro);

	public String eliminar(int id);
	
	public Object[] listar();
	
	public Object consultarPorId(int id);
	
}
