/**mchicaiza
 * 
 */
package com.asoriach.agenda.vista;

import com.asoriach.agenda.control.UsuarioTrs;
import com.asoriach.agenda.control.util.UtilLectura;
import com.asoriach.agenda.modelo.Usuario;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * Mar 6, 2019 - 11:01:14 AM
 */
public class FrmLogin {

	public static Usuario usuarioSesion; 
	
	public static void main(String[] args){
		System.out.println("\n\n**************************************");
		System.out.println("    SYSMED Red de servicios medicos   ");
		System.out.println("**************************************");
		// Adquirir valores 
		System.out.print("Usuario:");
		String usuario = UtilLectura.leerDesdeTeclado();
		System.out.print("Clave:");
		String clave = UtilLectura.leerDesdeTeclado();
		//2. 
		UsuarioTrs adminUsuario = new UsuarioTrs(); 
		usuarioSesion = adminUsuario.validarUsuario(usuario, clave); 
		
		//3.
		if(usuarioSesion != null){
			FrmPrincipal frmPrincipal = new FrmPrincipal(); 
		}
		else{
			System.err.println("Usuario no encontrado!!!!"); 
		}
	
	}
}
