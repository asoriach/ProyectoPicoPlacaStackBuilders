/**
 * 
 */
package com.asoriach.agenda.vista;

import com.asoriach.agenda.control.util.UtilLectura;

import java.util.Date;

import com.asoriach.agenda.control.DoctorTrs;
import com.asoriach.agenda.modelo.Doctor;

/**
 * Clase que representa la tabla que interactua con el usuarion con respecto a
 * la Tabla Doctores
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 6, 2019 - 12:50:18 PM
 */
public class FrmDoctor {

	public FrmDoctor(){
		
		crearMenuDoctor();
	}

	public void crearMenuDoctor() {

		int opcion = 0;
		DoctorTrs adminDoc = new DoctorTrs();
		String mensaje = null;
		Doctor doctor = null;
		String nombre = null;
		String apellido = null;
		String especialidad = null;
		String sucursal = null;
		String horario = null;

		do {
			System.out.println("\n\n**************************************");
			System.out.println("      SYSMED V 1.0 -> DOCTOR          ");
			System.out.println("**************************************");
			System.out.println("1. Listar");
			System.out.println("2. Guardar");
			System.out.println("3. Actualizar");
			System.out.println("4. Eliminar");
			System.out.println("5. Regresar");
			System.out.print("... Seleccione una opcion:");

			opcion = Integer.parseInt(UtilLectura.leerDesdeTeclado());
			// Sentencias de DecisiÛn - switch
			switch (opcion) { // Entero o Cadena
			case 1:
					for (Object doc : adminDoc.consultarTodos()) {
						System.out.println(doc);
					}
					break;

			case 2:

				System.out.println("Ingresar los datos del doctor: ");
				System.out.println("Id:");
				int id = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				System.out.println("Nombre: ");
				nombre = UtilLectura.leerDesdeTeclado();
				System.out.println("Apellido: ");
				apellido = UtilLectura.leerDesdeTeclado();
				System.out.println("Especialidad: ");
				especialidad = UtilLectura.leerDesdeTeclado();
				System.out.println("Sucursal: ");
				sucursal = UtilLectura.leerDesdeTeclado();
				System.out.println("Horario: ");
				horario = UtilLectura.leerDesdeTeclado();

				doctor = new Doctor(id, nombre, apellido, especialidad, sucursal, horario);

				mensaje = adminDoc.guardar(doctor);

				System.out.println(mensaje);
				break;
			case 3:
				// 1. Registro a actualizar
				System.out.println("Cual registro se debe actualizar, colocar id: ");
				int idDoc = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				// 2. Recuperando los valores menos su id

				System.out.println("Ingresar los datos del doctor:");
				System.out.println("Nombre: ");
				nombre = UtilLectura.leerDesdeTeclado();
				System.out.println("Apellido: ");
				apellido = UtilLectura.leerDesdeTeclado();
				System.out.println("Especialidad: ");
				especialidad = UtilLectura.leerDesdeTeclado();
				System.out.println("Sucursal: ");
				sucursal = UtilLectura.leerDesdeTeclado();
				System.out.println("Horario: ");
				horario = UtilLectura.leerDesdeTeclado();

				doctor = new Doctor(idDoc, nombre, apellido, especialidad, sucursal, horario);

				mensaje = adminDoc.actualizar(doctor);

				System.out.println(mensaje);
				break;

			case 4:
				// 1. Registro a eliminar
				System.out.println("Cual registro de doctor desea eliminar: ");
				for (Object doc : adminDoc.consultarTodos()) {
					System.out.println(doc);
				}
				System.out.println("Ingrese el id:");
				int idDocEli = Integer.parseInt(UtilLectura.leerDesdeTeclado());
					Doctor docEli = adminDoc.consultarPorId(idDocEli);
					mensaje = adminDoc.eliminar(docEli); 
					System.out.println(mensaje);
					
				break;

			case 5:
				FrmPrincipal frmPrincipal = new FrmPrincipal();
				break;
			default:
				System.err.println("Opcion Incorrecta!!!");
				break;

			}
		} while (opcion != 5);
	}


}
