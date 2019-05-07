/**
 * 
 */
package com.asoriach.agenda.control.util;

import java.util.Scanner;

/**
 * Clase que representa operaciones utilitarias de lectura del 
 * teclado por el usuario paciente
 * 
 * @author angelsoriachicaiza
 *
 * Mar 6, 2019 - 10:57:00 AM
 */
public class UtilLectura {

	public static String leerDesdeTeclado(){
		
		String valorALeer = null; 
		
		Scanner lector = new Scanner(System.in);
		
		valorALeer = lector.next(); 
		
		return valorALeer; 
	
	}
}
