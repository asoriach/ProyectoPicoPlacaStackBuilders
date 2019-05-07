/**
 * 
 */
package com.asoriach.agenda.control;

import java.util.List;

/**
 * Clase que representa el contrato aplicado para operaciones de negocio 
 * con memoria dinamica 
 * @author angelsoriachicaiza
 *
 * Mar 18, 2019 - 4:14:53 PM
 */
public interface ICrudC {

	public String guardar(Object registro) ;
	
	public String actualizar(Object registro) ;
	
	public String eliminar(Object registro) ;
	
	public List<?> consultarTodos() ;
	
	
}
