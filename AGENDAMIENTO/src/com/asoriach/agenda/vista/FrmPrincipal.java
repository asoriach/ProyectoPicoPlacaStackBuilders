/**
 * 
 */
package com.asoriach.agenda.vista;

import com.asoriach.agenda.control.util.UtilLectura;
import com.asoriach.agenda.modelo.Usuario;

/**
 * Clase que representa el formulario principal 
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 6, 2019 - 11:56:16 AM
 */
public class FrmPrincipal {

	public FrmPrincipal() {
		crearMenuPrincipal();
	}

	/*
	 * Metodo crear menu principal
	 */
	private void crearMenuPrincipal() {

		int opcion = 0;
		System.out.println("**************************************");
		System.out.println("    SYSMED Red de servicios medicos   ");
		System.out.println("**************************************");
		System.out.println("1. PACIENTE ");
		System.out.println("2. DOCTORES");
		System.out.println("3. CENTROS DE ATENCION");
		System.out.println("4. TIPO CITA");
		System.out.println("5. AGENDAR CITA");
		System.out.println("6. SALIR");
		System.out.println("... Seleccione un opcion: ");

		opcion = Integer.parseInt(UtilLectura.leerDesdeTeclado());
		switch (opcion) {
		case 1:
			FrmPaciente frmPaciente = new FrmPaciente();
			break;
		case 2:
			FrmDoctor frmDoctor = new FrmDoctor();
			break;
		case 3:
			FrmCenAten frmCenAten = new FrmCenAten();
			break;
		case 4:
			FrmTipoCita frmTipoCita = new FrmTipoCita();
			break;
		case 5:
			FrmCita frmCita = new FrmCita();
			break;
		case 6:
			System.exit(0);
			default:
			System.err.println("Opcion Incorrecta!!!!!");
			break;
			
		}

	}

}
