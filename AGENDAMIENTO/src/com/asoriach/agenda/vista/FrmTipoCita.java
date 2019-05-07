/**
 * 
 */
package com.asoriach.agenda.vista;

import java.util.Date;

import com.asoriach.agenda.control.PacienteTrs;
import com.asoriach.agenda.control.TipoCitaTrs;
import com.asoriach.agenda.control.util.UtilLectura;
import com.asoriach.agenda.modelo.Paciente;
import com.asoriach.agenda.modelo.TipoCita;
import com.asoriach.agenda.modelo.Usuario;

/**
 * Clase que representa el tipo de cita
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 6, 2019 - 12:50:40 PM
 */
public class FrmTipoCita {

	private Usuario usuarioSesion;

	public FrmTipoCita() {
		crearMenuTipoCita();
	}

	/**
	 * Metodo para crear el men˙ tipo de Cita
	 */

	private void crearMenuTipoCita() {

		int opcion = 0;
		TipoCitaTrs adminTipoCita = new TipoCitaTrs();
		Object[] listaTipoCita = null;
		String mensaje = null;
		TipoCita tipoCita = null;

		String nombreCita = null;
		String sucursalCita = null;

		
		
		do {
			System.out.println("\n\n**************************************");
			System.out.println("      SYSMED V 1.0 -> TIPO CITA       ");
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
				listaTipoCita = adminTipoCita.listar();
				for (Object tipCita : listaTipoCita) {
					System.out.println(tipCita);
				}
				break;

			case 2:
				// 1.Recuperando los valores
				System.out.println("Ingresar los dato del tipo de Cita:");
				System.out.println("ID:");
				int id = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				System.out.print("Tipo de Cita:");
				nombreCita = UtilLectura.leerDesdeTeclado();
				System.out.print("Sucursal:");
				sucursalCita = UtilLectura.leerDesdeTeclado();
			
				// 2.Crear un registro (objeto de Paciente)
				tipoCita = new TipoCita();
				tipoCita.setId(id);
				tipoCita.setNombreCita(nombreCita);
				tipoCita.setSucursalCita(sucursalCita);
				
				// 3. Llamar al controlador (el tiene las operaciones)
				mensaje = adminTipoCita.guardar(tipoCita);

				// 4. Procesar la informacion
				System.out.println(mensaje);
				break;

			case 3:
				System.out.println("Que informacion del tipo de cita desea actualizar, Coloque el id:");
				int idTipoCita = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				// 1.Recibir info actualizada
				
				System.out.println("Ingresar los dato del tipo de Cita:");
				System.out.print("Tipo de Cita:");
				nombreCita = UtilLectura.leerDesdeTeclado();
				System.out.print("Sucursal:");
				sucursalCita = UtilLectura.leerDesdeTeclado();
			
				// 2.Crear un registro (objeto de Paciente)
				tipoCita = new TipoCita();
				tipoCita.setId(idTipoCita);
				tipoCita.setNombreCita(nombreCita);
				tipoCita.setSucursalCita(sucursalCita);
				
				// 3. Llamar al controlador (el tiene las operaciones)
				mensaje = adminTipoCita.actualizar(idTipoCita, tipoCita);

				// 4. Procesar la informacion
				System.out.println(mensaje);
				break;

			case 4:
				System.out.println("Seleccione Tipo de Cita desea eliminar:");
				listaTipoCita = adminTipoCita.listar();
				for (Object tipCita : listaTipoCita) {
					System.out.println(tipCita);
				}
				System.out.println("Ingrese el id:");
				int idTipCitaEli = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				mensaje = adminTipoCita.eliminar(idTipCitaEli);
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
