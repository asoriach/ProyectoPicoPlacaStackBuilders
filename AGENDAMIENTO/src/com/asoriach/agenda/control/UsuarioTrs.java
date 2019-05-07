/**
 * 
 */
package com.asoriach.agenda.control;

import com.asoriach.agenda.modelo.MemoriaBdd;
import com.asoriach.agenda.modelo.Usuario;

/**
 * Clase que representa operaciones de negocio Usuario
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 5, 2019 - 8:37:38 PM
 */
public class UsuarioTrs {

	public Usuario validarUsuario(String usuario, String clave) {
		Usuario usuarioRec = null;

		for (Usuario alias : MemoriaBdd.usuarios) {
			/*
			 *  Validacion Usuarios
			 */
			if (alias != null && alias.getNombreUsu().equals(usuario) && alias.getClaveUsu().equals(clave)) {
			usuarioRec = alias;
			break;
			}
		}

		return usuarioRec;

	}
}
