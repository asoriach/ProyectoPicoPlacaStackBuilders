/**
 * 
 */
package com.asoriach.agenda.form;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 20, 2019 - 6:27:58 PM
 */
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desPanPri;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FrmPrincipal frame = new
	 * FrmPrincipal(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	// El proyecto solo se ejecuta desde el formulario Login por razones de
	// seguridad

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setTitle(":: SYSMED Menu Principal ::");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menBarPri = new JMenuBar();
		setJMenuBar(menBarPri);

		JMenu menAdmin = new JMenu("Administracion");
		menBarPri.add(menAdmin);

		JMenuItem menuItem = new JMenuItem("New menu item");
		menAdmin.add(menuItem);

		JMenuItem menIteSal = new JMenuItem("Salir");
		menAdmin.add(menIteSal);

		JMenu menIngreso = new JMenu("Ingreso");
		menBarPri.add(menIngreso);

		JMenuItem menItePac = new JMenuItem("Paciente");
		menItePac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generar la nueva pantalla Reg.Paciente
				IFrmPaciente iFrmPac = new IFrmPaciente();
				iFrmPac.setVisible(true);
				desPanPri.add(iFrmPac);
			}
		});
		menIngreso.add(menItePac);

		JMenuItem menIteDoc = new JMenuItem("Doctor");
		menIngreso.add(menIteDoc);

		JMenuItem menIteCenAten = new JMenuItem("Centro Atencion");
		menIngreso.add(menIteCenAten);

		JMenu menAgenda = new JMenu("Agenda");
		menBarPri.add(menAgenda);

		JMenuItem menIteTipoCita = new JMenuItem("Tipo Cita");
		menIteTipoCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generar la nueva pantalla de Tipo de Cita
				IFrmTipoCita iFrmTipoCita = new IFrmTipoCita();
				iFrmTipoCita.setVisible(true);
				desPanPri.add(iFrmTipoCita);

			}
		});
		menAgenda.add(menIteTipoCita);

		JMenuItem menIteCita = new JMenuItem("Agendar Cita");
		menIteCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generar la nueva pantalla de Agenda Cita
				IFrmCita iFrmCita = new IFrmCita();
				iFrmCita.setVisible(true);
				desPanPri.add(iFrmCita);
			
			}
		});
		menAgenda.add(menIteCita);

		JMenu menCon = new JMenu("Consulta");
		menBarPri.add(menCon);

		JMenuItem menIteConEsp = new JMenuItem("Especialidades");
		menCon.add(menIteConEsp);

		JMenuItem menIteConCitaAgen = new JMenuItem("Citas Agendadas");
		menCon.add(menIteConCitaAgen);

		JMenuItem menIteConHis = new JMenuItem("Historia Clinica");
		menCon.add(menIteConHis);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desPanPri = new JDesktopPane();
		contentPane.add(desPanPri, BorderLayout.CENTER);
	}
}
