/**
 * 
 */
package com.asoriach.agenda.vista;

import java.util.Date;

import com.asoriach.agenda.control.PacienteTrs;

import com.asoriach.agenda.control.util.UtilLectura;
import com.asoriach.agenda.modelo.Usuario;
import com.asoriach.agenda.modelo.Paciente;

/**
 * Clase que representa el formulario de paciente
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 6, 2019 - 12:50:05 PM
 */
public class FrmPaciente {

	private Usuario usuarioSesion;

	public FrmPaciente() {
		crearMenuPaciente();
	}

	/**
	 * Metodo para crear el menu de paciente
	 */

	private void crearMenuPaciente() {

		int opcion = 0;
		PacienteTrs adminPaciente = new PacienteTrs();
		Object[] listaPaciente = null;
		String mensaje = null;
		Paciente paciente = null;

		String nombre = null;
		String apellido = null;
		String identificacion = null;
		String fechaNac = null;
		String direccion = null;
		String telefono = null;
		String correo = null;
		String genero = null;
		String seguro = null;

		do {
			System.out.println("\n\n**************************************");
			System.out.println("      SYSMED V 1.0 -> PACIENTE        ");
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
				listaPaciente = adminPaciente.listar();
				for (Object pac : listaPaciente) {
					System.out.println(pac);
				}
				break;

			case 2:
				// 1.Recuperando los valores
				System.out.println("Ingresar los datos:");
				System.out.print("Nombre:");
				nombre = UtilLectura.leerDesdeTeclado();
				System.out.print("Apellido:");
				apellido = UtilLectura.leerDesdeTeclado();
				System.out.println("Cedula:");
				identificacion = UtilLectura.leerDesdeTeclado();
				System.out.println("Fecha de Nacimiento:");
				fechaNac = UtilLectura.leerDesdeTeclado();
				System.out.println("Direccion:");
				direccion = UtilLectura.leerDesdeTeclado();
				System.out.println("Telefono o Celular:");
				telefono = UtilLectura.leerDesdeTeclado();
				System.out.println("Correo:");
				correo = UtilLectura.leerDesdeTeclado();
				System.out.println("Genero:");
				genero = UtilLectura.leerDesdeTeclado();
				System.out.println("Seguro:");
				seguro = UtilLectura.leerDesdeTeclado();
				System.out.println("Id:");
				int id = Integer.parseInt(UtilLectura.leerDesdeTeclado());

				// 2.Crear un registro (objeto de Paciente)
				paciente = new Paciente(nombre, apellido, identificacion, fechaNac, direccion, telefono, correo, genero, seguro, id);
				paciente.setNombrePer(nombre);
				paciente.setApellidoPer(apellido);
				paciente.setIdentificacionPer(identificacion);
				paciente.setFechaNacPer(fechaNac);
				paciente.setDireccionPer(direccion);
				paciente.setTelefonoPer(telefono);
				paciente.setCorreoPer(correo);
				paciente.setGeneroPer(genero);
				paciente.setSeguroPer(seguro);
				paciente.setIdPer(id);

				// 3. Llamar al controlador (el tiene las operaciones)
				mensaje = adminPaciente.guardar(paciente);

				// 4. Procesar la informacion
				System.out.println(mensaje);
				break;

			case 3:
				System.out.println("Que informacion del paciente desea actualizar, Coloque el id:");
				int idPaciente = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				// 1.Recibir info actualizada
				System.out.println("Ingresar los datos:");
				System.out.print("Nombre:");
				nombre = UtilLectura.leerDesdeTeclado();
				System.out.print("Apellido:");
				apellido = UtilLectura.leerDesdeTeclado();
				System.out.println("Cedula:");
				identificacion = UtilLectura.leerDesdeTeclado();
				System.out.println("Fecha de Nacimiento:");
				fechaNac = UtilLectura.leerDesdeTeclado();
				System.out.println("Direccion:");
				direccion = UtilLectura.leerDesdeTeclado();
				System.out.println("Telefono o Celular:");
				telefono = UtilLectura.leerDesdeTeclado();
				System.out.println("Correo:");
				correo = UtilLectura.leerDesdeTeclado();
				System.out.println("Genero:");
				genero = UtilLectura.leerDesdeTeclado();
				System.out.println("Seguro:");
				seguro = UtilLectura.leerDesdeTeclado();

				// 2.Crear un registro (objeto de TipoProducto)
				paciente = new Paciente(nombre, apellido, identificacion, fechaNac, direccion, telefono, correo, genero, seguro, idPaciente);
				paciente.setNombrePer(nombre);
				paciente.setApellidoPer(apellido);
				paciente.setIdentificacionPer(identificacion);
				paciente.setFechaNacPer(fechaNac);
				paciente.setDireccionPer(direccion);
				paciente.setTelefonoPer(telefono);
				paciente.setCorreoPer(correo);
				paciente.setGeneroPer(genero);
				paciente.setSeguroPer(seguro);
				paciente.setIdPer(idPaciente);

				// 3.

				mensaje = adminPaciente.actualizar(idPaciente, paciente);
				// 4.

				System.out.println(mensaje);

				break;

			case 4:
				System.out.println("Seleccione paciente a eliminar:");
				listaPaciente = adminPaciente.listar();
				for (Object pac : listaPaciente) {
					System.out.println(pac);
				}
				System.out.println("Ingrese el id:");
				int idPacEli = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				mensaje = adminPaciente.eliminar(idPacEli);
				System.out.println(mensaje);

				break;

			case 5:
				FrmPrincipal frmPrincipal = new FrmPrincipal();
			default:
				System.err.println("Opcion Incorrecta!!!");
				break;

			}
		} while (opcion != 5);
	}

}
