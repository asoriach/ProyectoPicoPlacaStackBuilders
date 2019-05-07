/**
 * 
 */
package com.asoriach.agenda.form;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.asoriach.agenda.form.util.TableModelPaciente;
import com.asoriach.agenda.modelo.Paciente;
import com.asoriach.agenda.negocio.PacienteTrs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.toedter.calendar.JCalendar;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 30, 2019 - 2:30:37 PM
 */
public class IFrmPaciente extends JInternalFrame {
	private JTextField txtNomPac;
	private JTextField txtApePac;
	private JTextField txtDirPac;
	private JTextField txtIdePac;
	private JTextField txtCorPac;
	private JTextField txtSegPac;
	private JTextField txtTelPac;
	private JTextField txtGenPac;

	private TableModelPaciente modeloPac;
	private Paciente pacSel;
	private JPanel tabLisPac;
	private JPanel tabIngPac;
	private JButton btnNuePac;
	private JButton bntGuaPac;
	private JButton bntEdiPac;
	private JTable tablePac;
	private JDateChooser dateChooser;
	private JButton bntEliPac;
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 */
	public IFrmPaciente() {
		setTitle(":: Ingreso Paciente ::");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);

		inicializar();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);

		btnNuePac = new JButton("Nuevo");
		btnNuePac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomPac.setText("");
				txtApePac.setText("");
				txtIdePac.setText("");
				txtDirPac.setText("");
				txtCorPac.setText("");
				txtGenPac.setText("");
				txtSegPac.setText("");
				txtTelPac.setText("");
				dateChooser.setDate(null);
			}
		});
		btnNuePac.setIcon(new ImageIcon(IFrmPaciente.class.getResource("/com/asoriach/agenda/resourses/new24X24.png")));
		toolBar.add(btnNuePac);

		bntGuaPac = new JButton("Guardar");
		bntGuaPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNomPac.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Ingrese el nombre del Paciente");
					} else {
						Paciente pac = new Paciente();
						pac.setNombrePer(txtNomPac.getText());
						pac.setApellidoPer(txtApePac.getText());
						pac.setIdentificacionPer(txtIdePac.getText());
						pac.setFechaNacPer(dateChooser.getDate());
						pac.setDireccionPer(txtDirPac.getText());
						pac.setCorreoPer(txtCorPac.getText());
						pac.setGeneroPer(txtGenPac.getText());
						pac.setSeguroPer(txtSegPac.getText());
						pac.setTelefonoPer(txtTelPac.getText());
						PacienteTrs admPac = new PacienteTrs();
						String mensaje = null;

						if (pacSel == null) {
							mensaje = admPac.guardar(pac);
						} else {
							pac.setIdPer(pacSel.getIdPer());
							mensaje = admPac.actualizar(pac);
						}
						JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
						txtNomPac.setText("");
						txtApePac.setText("");
						txtIdePac.setText("");
						txtDirPac.setText("");
						txtCorPac.setText("");
						txtGenPac.setText("");
						txtSegPac.setText("");
						txtTelPac.setText("");
						dateChooser.setDate(null);

						pacSel = null;
						inicializar();
						tablePac.setModel(modeloPac);
						bntEdiPac.setEnabled(false);
						bntEliPac.setEnabled(false);

					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al Guardar paciente", "Errores",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		bntGuaPac.setIcon(new ImageIcon(IFrmPaciente.class.getResource("/com/asoriach/agenda/resourses/diskette.png")));
		toolBar.add(bntGuaPac);

		bntEdiPac = new JButton("Editar");
		bntEdiPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pacSel != null) {
					tabbedPane.setSelectedIndex(0);
					txtNomPac.setText(pacSel.getNombrePer());
					txtApePac.setText(pacSel.getApellidoPer());
					txtIdePac.setText(pacSel.getIdentificacionPer());
					txtDirPac.setText(pacSel.getDireccionPer());
					txtCorPac.setText(pacSel.getCorreoPer());
					txtGenPac.setText(pacSel.getGeneroPer());
					txtSegPac.setText(pacSel.getSeguroPer());
					txtTelPac.setText(pacSel.getTelefonoPer());
					dateChooser.setDate(pacSel.getFechaNacPer());
				} else {
					JOptionPane.showMessageDialog(null, "No selecciono registro", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		bntEdiPac
				.setIcon(new ImageIcon(IFrmPaciente.class.getResource("/com/asoriach/agenda/resourses/clipboard.png")));
		toolBar.add(bntEdiPac);

		bntEliPac = new JButton("Eliminar");
		bntEliPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (pacSel != null) {
						int valEli = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro de paciente",
								"Confirmacion", JOptionPane.YES_NO_CANCEL_OPTION);
						if (valEli == 0) {
							PacienteTrs admPac = new PacienteTrs();
							String mensaje = admPac.eliminar(pacSel);
							JOptionPane.showMessageDialog(null, mensaje, "Informacion",
									JOptionPane.INFORMATION_MESSAGE);

							pacSel = null;
							inicializar();
							tablePac.setModel(modeloPac);
							bntEdiPac.setEnabled(false);
							bntEliPac.setEnabled(false);
						}
					} else {
						JOptionPane.showMessageDialog(null, "No se ha seleccionado el paciente a eliminar", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al eliminar al paciente" + e2.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		bntEliPac.setIcon(new ImageIcon(IFrmPaciente.class.getResource("/com/asoriach/agenda/resourses/trash.png")));
		toolBar.add(bntEliPac);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabIngPac = new JPanel();
		tabbedPane.addTab("Registro", null, tabIngPac, null);
		GridBagLayout gbl_tabIngPac = new GridBagLayout();
		gbl_tabIngPac.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_tabIngPac.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_tabIngPac.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_tabIngPac.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		tabIngPac.setLayout(gbl_tabIngPac);

		JLabel lblNomPac = new JLabel("Nombre :");
		GridBagConstraints gbc_lblNomPac = new GridBagConstraints();
		gbc_lblNomPac.anchor = GridBagConstraints.EAST;
		gbc_lblNomPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomPac.gridx = 1;
		gbc_lblNomPac.gridy = 1;
		tabIngPac.add(lblNomPac, gbc_lblNomPac);

		txtNomPac = new JTextField();
		GridBagConstraints gbc_txtNomPac = new GridBagConstraints();
		gbc_txtNomPac.gridwidth = 4;
		gbc_txtNomPac.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomPac.gridx = 2;
		gbc_txtNomPac.gridy = 1;
		tabIngPac.add(txtNomPac, gbc_txtNomPac);
		txtNomPac.setColumns(10);

		JLabel lblApePac = new JLabel("Apellido :");
		GridBagConstraints gbc_lblApePac = new GridBagConstraints();
		gbc_lblApePac.anchor = GridBagConstraints.EAST;
		gbc_lblApePac.insets = new Insets(0, 0, 5, 5);
		gbc_lblApePac.gridx = 7;
		gbc_lblApePac.gridy = 1;
		tabIngPac.add(lblApePac, gbc_lblApePac);

		txtApePac = new JTextField();
		GridBagConstraints gbc_txtApePac = new GridBagConstraints();
		gbc_txtApePac.insets = new Insets(0, 0, 5, 0);
		gbc_txtApePac.gridwidth = 3;
		gbc_txtApePac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApePac.gridx = 8;
		gbc_txtApePac.gridy = 1;
		tabIngPac.add(txtApePac, gbc_txtApePac);
		txtApePac.setColumns(10);

		JLabel lblIdenPac = new JLabel("Identificacion :");
		GridBagConstraints gbc_lblIdenPac = new GridBagConstraints();
		gbc_lblIdenPac.anchor = GridBagConstraints.EAST;
		gbc_lblIdenPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdenPac.gridx = 1;
		gbc_lblIdenPac.gridy = 2;
		tabIngPac.add(lblIdenPac, gbc_lblIdenPac);

		txtIdePac = new JTextField();
		GridBagConstraints gbc_txtIdePac = new GridBagConstraints();
		gbc_txtIdePac.gridwidth = 4;
		gbc_txtIdePac.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdePac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdePac.gridx = 2;
		gbc_txtIdePac.gridy = 2;
		tabIngPac.add(txtIdePac, gbc_txtIdePac);
		txtIdePac.setColumns(10);

		JLabel lblDirPac = new JLabel("Dirreccion :");
		GridBagConstraints gbc_lblDirPac = new GridBagConstraints();
		gbc_lblDirPac.anchor = GridBagConstraints.EAST;
		gbc_lblDirPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirPac.gridx = 7;
		gbc_lblDirPac.gridy = 2;
		tabIngPac.add(lblDirPac, gbc_lblDirPac);

		txtDirPac = new JTextField();
		GridBagConstraints gbc_txtDirPac = new GridBagConstraints();
		gbc_txtDirPac.gridwidth = 3;
		gbc_txtDirPac.insets = new Insets(0, 0, 5, 0);
		gbc_txtDirPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDirPac.gridx = 8;
		gbc_txtDirPac.gridy = 2;
		tabIngPac.add(txtDirPac, gbc_txtDirPac);
		txtDirPac.setColumns(10);

		JLabel lblTelPac = new JLabel("Telefono :");
		GridBagConstraints gbc_lblTelPac = new GridBagConstraints();
		gbc_lblTelPac.anchor = GridBagConstraints.EAST;
		gbc_lblTelPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelPac.gridx = 1;
		gbc_lblTelPac.gridy = 3;
		tabIngPac.add(lblTelPac, gbc_lblTelPac);

		txtTelPac = new JTextField();
		GridBagConstraints gbc_txtTelPac = new GridBagConstraints();
		gbc_txtTelPac.gridwidth = 4;
		gbc_txtTelPac.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelPac.gridx = 2;
		gbc_txtTelPac.gridy = 3;
		tabIngPac.add(txtTelPac, gbc_txtTelPac);
		txtTelPac.setColumns(10);

		JLabel lblCorPac = new JLabel("Correo :");
		GridBagConstraints gbc_lblCorPac = new GridBagConstraints();
		gbc_lblCorPac.anchor = GridBagConstraints.EAST;
		gbc_lblCorPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorPac.gridx = 7;
		gbc_lblCorPac.gridy = 3;
		tabIngPac.add(lblCorPac, gbc_lblCorPac);

		txtCorPac = new JTextField();
		GridBagConstraints gbc_txtCorPac = new GridBagConstraints();
		gbc_txtCorPac.gridwidth = 3;
		gbc_txtCorPac.insets = new Insets(0, 0, 5, 0);
		gbc_txtCorPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorPac.gridx = 8;
		gbc_txtCorPac.gridy = 3;
		tabIngPac.add(txtCorPac, gbc_txtCorPac);
		txtCorPac.setColumns(10);

		JLabel lblGenPac = new JLabel("Genero:");
		GridBagConstraints gbc_lblGenPac = new GridBagConstraints();
		gbc_lblGenPac.anchor = GridBagConstraints.EAST;
		gbc_lblGenPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenPac.gridx = 1;
		gbc_lblGenPac.gridy = 4;
		tabIngPac.add(lblGenPac, gbc_lblGenPac);

		txtGenPac = new JTextField();
		GridBagConstraints gbc_txtGenPac = new GridBagConstraints();
		gbc_txtGenPac.gridwidth = 4;
		gbc_txtGenPac.insets = new Insets(0, 0, 5, 5);
		gbc_txtGenPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGenPac.gridx = 2;
		gbc_txtGenPac.gridy = 4;
		tabIngPac.add(txtGenPac, gbc_txtGenPac);
		txtGenPac.setColumns(10);

		JLabel lblSegPac = new JLabel("Seguro :");
		GridBagConstraints gbc_lblSegPac = new GridBagConstraints();
		gbc_lblSegPac.anchor = GridBagConstraints.EAST;
		gbc_lblSegPac.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegPac.gridx = 7;
		gbc_lblSegPac.gridy = 4;
		tabIngPac.add(lblSegPac, gbc_lblSegPac);

		txtSegPac = new JTextField();
		GridBagConstraints gbc_txtSegPac = new GridBagConstraints();
		gbc_txtSegPac.gridwidth = 3;
		gbc_txtSegPac.insets = new Insets(0, 0, 5, 0);
		gbc_txtSegPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSegPac.gridx = 8;
		gbc_txtSegPac.gridy = 4;
		tabIngPac.add(txtSegPac, gbc_txtSegPac);
		txtSegPac.setColumns(10);

		JLabel lblFecNacPAc = new JLabel("Fecha Nacimiento :");
		GridBagConstraints gbc_lblFecNacPAc = new GridBagConstraints();
		gbc_lblFecNacPAc.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFecNacPAc.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecNacPAc.gridx = 1;
		gbc_lblFecNacPAc.gridy = 5;
		tabIngPac.add(lblFecNacPAc, gbc_lblFecNacPAc);

		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridwidth = 4;
		gbc_dateChooser.anchor = GridBagConstraints.NORTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 5;
		tabIngPac.add(dateChooser, gbc_dateChooser);

		tabLisPac = new JPanel();
		tabbedPane.addTab("Consultar", null, tabLisPac, null);
		tabLisPac.setLayout(new BorderLayout(0, 0));

		tablePac = new JTable();
		tablePac.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePac.setModel(modeloPac);
		JScrollPane spPac = new JScrollPane(tablePac);
		tabLisPac.add(spPac, BorderLayout.CENTER);

		tablePac.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				int indSel = lsm.getMaxSelectionIndex();
				if (indSel >= 0) {
					TableModelPaciente modelo = (TableModelPaciente) tablePac.getModel();
					pacSel = modelo.obtenerFilaSeleccionada(indSel);
					bntEdiPac.setEnabled(true);
					bntEliPac.setEnabled(true);
				}

			}
		});

	}

	private void inicializar() {
		try {
			List<String> columnas = new ArrayList<>();
			columnas.add("Id");
			columnas.add("Nombre");
			columnas.add("Apellido");
			columnas.add("Identificacion");
			columnas.add("Fecha Nac");
			columnas.add("Direccion");
			columnas.add("Telefono");
			columnas.add("Correo");
			columnas.add("Genero");
			columnas.add("seguro");

			List<Paciente> filas = new ArrayList<Paciente>();
			PacienteTrs admPac = new PacienteTrs();
			filas = admPac.consultarTodos();
			modeloPac = new TableModelPaciente(columnas, filas);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
