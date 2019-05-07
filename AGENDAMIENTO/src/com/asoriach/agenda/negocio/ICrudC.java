/**
 * 
 */
package com.asoriach.agenda.negocio;

import java.util.List;

/**
 * Clase que representa el contrato aplicado para operaciones de negocio 
 * con memoria dinamica 
 * @author angelsoriachicaiza
 *
 * Mar 18, 2019 - 4:14:53 PM
 */
public interface ICrudC {

	public String guardar(Object registro) throws Exception ;
	
	public String actualizar(Object registro) throws Exception ;
	
	public String eliminar(Object registro) throws Exception ;
	
	public List<?> consultarTodos() throws Exception ;
	
	
}
