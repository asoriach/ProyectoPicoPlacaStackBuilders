/**
 * 
 */
package com.asoriach.agenda.vista;

import java.math.BigDecimal;

import com.asoriach.agenda.control.DoctorTrs;
import com.asoriach.agenda.control.TipoCitaTrs;
import com.asoriach.agenda.control.CitaTrs;
import com.asoriach.agenda.control.PacienteTrs;

import com.asoriach.agenda.control.util.UtilLectura;

import com.asoriach.agenda.modelo.Doctor;
import com.asoriach.agenda.modelo.Paciente;
import com.asoriach.agenda.modelo.TipoCita;
import com.asoriach.agenda.modelo.Cita;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 6, 2019 - 12:50:48 PM
 */
public class FrmCita {

	public FrmCita() {
		crearMenuCita();
	}

	/**
	 * Método para crear el menú de producto
	 */
	private void crearMenuCita() {

		int opcion = 0;
		PacienteTrs adminPac = new PacienteTrs();
		TipoCitaTrs adminTipoCita = new TipoCitaTrs();
		DoctorTrs adminDoc = new DoctorTrs();
		CitaTrs adminCita = new CitaTrs();

		Object[] listaCitas = null;

		String mensaje = null;
		Cita cita = null;

		String nombre = null;
		String fecha = null;
		String sucursal = null;
		int seguro = 0;
		// boolean confirmSeg = false;
		// BigDecimal precio = null;

		do {
			System.out.println("\n\n*************************************");
			System.out.println("* E-COMMERCE V 1.0 -> Cita          *");
			System.out.println("*************************************");
			System.out.println("1. Listar");
			System.out.println("2. Guardar");
			System.out.println("3. Actualizar");
			System.out.println("4. Eliminar");
			System.out.println("5. Regresar");
			System.out.print("... Seleccione una opción:");
			opcion = Integer.parseInt(UtilLectura.leerDesdeTeclado());
			switch (opcion) {
			case 1:
				for (Object tipCita : adminCita.consultarTodos()) {
					System.out.println(tipCita);
				}

				break;
			case 2:
				// 1.Recuperando los valores
				System.out.println("Ingresar los datos de su cita:");
				int id = 0;
				TipoCita tipoCita = null;
				Paciente paciente = null;
				Doctor doctor = null;

				System.out.print("Id:");
				id = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				System.out.print("Especialidad:");
				nombre = UtilLectura.leerDesdeTeclado();
				System.out.println("Fecha:");
				fecha = UtilLectura.leerDesdeTeclado();
				System.out.println("Sucursal:");
				sucursal = UtilLectura.leerDesdeTeclado();
				System.out.println("Si posee seguro imgrese 1, si no lo posee ingrese 0 :");
				seguro = Integer.parseInt(UtilLectura.leerDesdeTeclado());

				/******************************************************
				 * Bloque para relacionar el objeto
				 ********************************************************/
				System.out.print("Tipos de Citas:");
				System.out.println(adminTipoCita.imprimirListaFormateada());
				System.out.print("Ingreso el Tipo de Cita:");
				int idTipoCita = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				tipoCita = (TipoCita) adminTipoCita.consultarPorId(idTipoCita);
				/*******************************************************************************/
				// 2.Crear un registro (objeto de TipoProducto)

				/******************************************************
				 * Bloque para relacionar el objeto
				 ********************************************************/
				System.out.print(" Con que doctor-especialidad desea atenderse  :");
				System.out.println(adminDoc.imprimirListaFormateada());
				System.out.print("Ingrese el ID del doctor:");
				int idDoctor = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				doctor = (Doctor) adminDoc.consultarPorId(idDoctor);
				/*******************************************************************************/

				/******************************************************
				 * Bloque para relacionar el objeto
				 ********************************************************/
				System.out.print("Verifique el paciente:");
				System.out.println(adminPac.imprimirListaFormateada());
				System.out.print("Ingreso el ID paciente:");
				int idPac = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				paciente = (Paciente) adminPac.consultarPorId(idPac);
				/*******************************************************************************/

				cita = new Cita(id, nombre, fecha, sucursal, seguro, tipoCita, doctor, paciente);

				// 3. Llamar al controlador (el tiene las operaciones)
				mensaje = adminCita.guardar(cita);
				// 4. Procesar la información
				if (doctor.getSucursalDoc().equals(cita.getSurcursalCita()) && doctor.getEspecialidadDoc().equals(cita.getEspecialidadCita())) {
					System.out.println("La surcursal dispone de un doctor en la especialidad deseada por el paciente");
				} else {
					System.err.println("No disponemos de la especialidad en el Centro de Atencion por favor seleccione otro");
					break;
				}

				if (seguro != 0) {
					System.out.println(mensaje);
					System.out.println("El valor a pagar de su cita es de 4.50 $ ");
				} else {
					System.out.println(mensaje);
					System.out.println("El valor a pagar de su cita es de 24.00 $ ");
				}

				break;
			case 3:

				// 1. A que registro le van a actualizar
				System.out.print("Desea actualizar su cita, Ingrese el ID de la cita a modificarse:");
				int idCitaAct = Integer.parseInt(UtilLectura.leerDesdeTeclado());

				// 2.Recuperando los valores menos su id
				System.out.println("Ingresar los datos:");
				System.out.print("Especialidad:");
				nombre = UtilLectura.leerDesdeTeclado();
				System.out.println("Fecha:");
				fecha = UtilLectura.leerDesdeTeclado();
				System.out.println("Sucursal:");
				sucursal = UtilLectura.leerDesdeTeclado();
				System.out.println("Si posee seguro imgrese 1, si no lo posee ingrese 0 :");
				seguro = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				/******************************************************
				 * Bloque para relacionar el objeto
				 ********************************************************/
				System.out.print("Tipos de Citas:");
				System.out.println(adminTipoCita.imprimirListaFormateada());
				System.out.print("Ingreso el tipo de producto:");
				int idTipCita = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				tipoCita = (TipoCita) adminTipoCita.consultarPorId(idTipCita);
				/*******************************************************************************/
				// 2.Crear un registro (objeto de TipoProducto)

				/******************************************************
				 * Bloque para relacionar el objeto
				 ********************************************************/
				System.out.print(" Con que doctor-especialidad desea atenderse  :");
				System.out.println(adminDoc.imprimirListaFormateada());
				System.out.print("Ingrese el ID del Doctor:");
				int idDoc = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				doctor = (Doctor) adminDoc.consultarPorId(idDoc);
				/*******************************************************************************/

				/******************************************************
				 * Bloque para relacionar el objeto
				 ********************************************************/
				System.out.print("Verifique el paciente:");
				System.out.println(adminPac.imprimirListaFormateada());
				System.out.print("Ingreso el ID del paciente:");
				int idPaciente = Integer.parseInt(UtilLectura.leerDesdeTeclado());
				paciente = (Paciente) adminPac.consultarPorId(idPaciente);
				/*******************************************************************************/

				// 3.Crear un registro para actualizar (objeto de TipoProducto)
				cita = new Cita(idCitaAct, nombre, fecha, sucursal, seguro, tipoCita, doctor, paciente);
				// 4. Llamar al controlador (el tiene las operaciones)
				
				mensaje = adminCita.actualizar(cita);
				
				if (doctor.getSucursalDoc().equals(cita.getSurcursalCita()) && doctor.getEspecialidadDoc().equals(cita.getEspecialidadCita())) {
					System.out.println("La surcursal dispone de un doctor en la especialidad deseada por el paciente");
				} else {
					System.err.println("No disponemos de la especialidad en el Centro de Atencion por favor seleccione otro");
					break;
				}

				if (seguro != 0) {
					System.out.println(mensaje);
					System.out.println("El valor a pagar de su cita es de 4.50 $ ");
				} else {
					System.out.println(mensaje);
					System.out.println("El valor a pagar de su cita es de 24.00 $ ");
				}

				break;
				
			case 4:

				// 1.Mostramos todo lo que tenemos
				System.out.println("¿Que cita requiere eliminar?");

				for (Object citaRead : adminCita.consultarTodos()) {
					System.out.println(citaRead);
				}
				// 2.Recuperamos el identificador del tipo de producto a
				// eliminar
				System.out.print("Ingrese el id:");
				int idCitaEli = Integer.parseInt(UtilLectura.leerDesdeTeclado());

				Cita citaEli = adminCita.consultarPorId(idCitaEli);

				// 3.Llamar al controlar para eliminar
				mensaje = adminCita.eliminar(citaEli);
				System.out.println(mensaje);

				break;
			case 5:
				FrmPrincipal frmPrincipal = new FrmPrincipal();
			default:
				System.err.println("Opción Incorrecta!!!");
				break;

			}
		} while (opcion != 5);
	}

}
