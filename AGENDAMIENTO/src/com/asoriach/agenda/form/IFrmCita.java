/**
 * 
 */
package com.asoriach.agenda.form;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.asoriach.agenda.negocio.CitaTrs;
import com.asoriach.agenda.form.util.ComboBoxModelPaciente;
import com.asoriach.agenda.form.util.ComboBoxModelTipoCita;
import com.asoriach.agenda.form.util.TableModelCita;
import com.asoriach.agenda.modelo.Cita;
import com.asoriach.agenda.modelo.Paciente;
import com.asoriach.agenda.modelo.TipoCita;
import com.asoriach.agenda.negocio.PacienteTrs;
import com.asoriach.agenda.negocio.TipoCitaTrs;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * May 1, 2019 - 4:57:05 PM
 */
public class IFrmCita extends JInternalFrame {
	private JTextField txtEspCita;
	private JDateChooser datChoFecCita;
	private JComboBox<Paciente> cmbPac;
	private JComboBox<TipoCita> cmbTipoCita;
	private JTable tableCita;
	private JButton btnEliCita;
	private JButton btnEdiCita;
	private Paciente pacSel;
	private TipoCita tipoCitaSel;
	private Cita citaSel;
	private ComboBoxModelTipoCita modeloComboTipoCita;
	private ComboBoxModelPaciente modeloComboPac;
	private TableModelCita modeloCita;
	private JTabbedPane tabbedPane;
	/**
	 * Componente Vacio para incializar comboBox 
	 */
	private Paciente pacVacio ; 
	private TipoCita tipoCitaVacio;
	
	
	
	


	/**
	 * Create the frame.
	 */
	public IFrmCita() {
		/**
		 * Inicializo el objeto Vacio Paciente 
		 */
		pacVacio = new Paciente();
		pacVacio.setIdPer(-1);
		pacVacio.setNombrePer("Seleccionar el paciente");
		pacVacio.setApellidoPer("");
		pacVacio.setIdentificacionPer("A");
		pacVacio.setFechaNacPer(null);
		pacVacio.setDireccionPer("A");
		pacVacio.setTelefonoPer("A");
		pacVacio.setCorreoPer("A");
		pacVacio.setGeneroPer("A");
		pacVacio.setSeguroPer("A");
		pacVacio.setCitas(null);
		
		/**
		 * Inicializar el objeto vacio de Tipo Cita
		 */
		tipoCitaVacio = new TipoCita();
		tipoCitaVacio.setId(-1);
		tipoCitaVacio.setNombreCita("Seleccione su tipo de cita y centro de atencion");
		tipoCitaVacio.setSucursalCita(" ");
		tipoCitaVacio.setCitas(null);
		/**
		 * 
		 ***********************************************************/
		
	
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		inicializar();
		setTitle(":: SYSMED Agendar Cita::");
		setBounds(100, 100, 450, 300);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNueCita = new JButton("Nuevo");
		btnNueCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtEspCita.setText("");
			datChoFecCita.setDate(null);
			inicializarComboTipo();
			inicializarComboPac();
			}
		});
		btnNueCita.setIcon(new ImageIcon(IFrmCita.class.getResource("/com/asoriach/agenda/resourses/new24X24.png")));
		toolBar.add(btnNueCita);
		
		JButton btnGuaCita = new JButton("Guardar");
		btnGuaCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Cita cita = new Cita();
				cita.setEspecialidadCita(txtEspCita.getText());
				cita.setFechaCita(datChoFecCita.getDate());
				/**
				 * Bloque para tipo Cita 	
				 */
				cita.setTipocita(tipoCitaSel);
				/**
				 * Bloque para paciente 	
				 */
				cita.setPaciente(pacSel);
				
				CitaTrs admCita = new CitaTrs();
				String mensaje = null;
				if(citaSel == null){
					mensaje = admCita.guardar(cita);
				}else{
					cita.setIdCita(citaSel.getIdCita());
					mensaje = admCita.actualizar(cita);
				}
				JOptionPane.showMessageDialog(null, mensaje,"Informacion", JOptionPane.INFORMATION_MESSAGE);
				
				txtEspCita.setText("");
				datChoFecCita.setDate(null);
				citaSel = null;
				tipoCitaSel = null;
				pacSel = null;
				
				inicializar();
				cmbTipoCita.setModel(modeloComboTipoCita);
				cmbPac.setModel(modeloComboPac);
				tableCita.setModel(modeloCita);
				
				btnEdiCita.setEnabled(false);
				btnEliCita.setEnabled(false);
				
				
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al guardar" + e2.getMessage(), "Errores", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuaCita.setIcon(new ImageIcon(IFrmCita.class.getResource("/com/asoriach/agenda/resourses/diskette.png")));
		toolBar.add(btnGuaCita);
		
		btnEdiCita = new JButton("Editar");
		btnEdiCita.setEnabled(false);
		btnEdiCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(citaSel != null){
					tabbedPane.setSelectedIndex(0);
					txtEspCita.setText(citaSel.getEspecialidadCita());
					datChoFecCita.setDate(citaSel.getFechaCita());
					modeloComboTipoCita.setSelectedItem(citaSel.getTipocita());
					cmbTipoCita.setSelectedItem(modeloComboTipoCita.getSelectedItem());
					
					modeloComboPac.setSelectedItem(citaSel.getPaciente());
					cmbPac.setSelectedItem(modeloComboPac.getSelectedItem());
					
				}else {
				JOptionPane.showMessageDialog(null, "No ha seleccionado una cita regitrada", "Error", JOptionPane.ERROR_MESSAGE);	
				}
				
			}
		});
		btnEdiCita.setIcon(new ImageIcon(IFrmCita.class.getResource("/com/asoriach/agenda/resourses/clipboard.png")));
		toolBar.add(btnEdiCita);
		
		btnEliCita = new JButton("Eliminar");
		btnEliCita.setEnabled(false);
		btnEliCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(citaSel != null) {
					int valCon = JOptionPane.showConfirmDialog(null, "Desea Eliminar su cita agendada","Informacion",JOptionPane.YES_NO_OPTION);
					if(valCon == 0){
					CitaTrs admCita = new CitaTrs();
					String mensaje = admCita.eliminar(citaSel);
					JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
					
					citaSel = null;
					tipoCitaSel = null;
					pacSel = null;
					
					inicializar();
					cmbTipoCita.setModel(modeloComboTipoCita);
					cmbPac.setModel(modeloComboPac);
					tableCita.setModel(modeloCita);
					
					btnEdiCita.setEnabled(false);
					btnEliCita.setEnabled(false);
						
					}
				}else {
					JOptionPane.showMessageDialog(null,"Nose ha seleccionado una cita a eliminar", "Errores", JOptionPane.ERROR_MESSAGE);
				}
					
					
				} catch (Exception e2) {
		JOptionPane.showMessageDialog(null, "Error al eliminar","Errores", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliCita.setIcon(new ImageIcon(IFrmCita.class.getResource("/com/asoriach/agenda/resourses/trash.png")));
		toolBar.add(btnEliCita);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabCreCita = new JPanel();
		tabbedPane.addTab("Agendar Cita", null, tabCreCita, null);
		GridBagLayout gbl_tabCreCita = new GridBagLayout();
		gbl_tabCreCita.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_tabCreCita.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tabCreCita.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_tabCreCita.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		tabCreCita.setLayout(gbl_tabCreCita);
		
		JLabel lblTipoCIta = new JLabel("Tipo de Cita :");
		GridBagConstraints gbc_lblTipoCIta = new GridBagConstraints();
		gbc_lblTipoCIta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoCIta.gridx = 3;
		gbc_lblTipoCIta.gridy = 1;
		tabCreCita.add(lblTipoCIta, gbc_lblTipoCIta);
		
		cmbTipoCita = new JComboBox<>();
		cmbTipoCita.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			tipoCitaSel = (TipoCita) modeloComboTipoCita.getSelectedItem();
			System.out.println(tipoCitaSel);
			}
		});
		inicializarComboTipo();
		cmbTipoCita.setModel(modeloComboTipoCita);
		cmbTipoCita.setSelectedIndex(1);
		
		GridBagConstraints gbc_cmbTipoCita = new GridBagConstraints();
		gbc_cmbTipoCita.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoCita.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoCita.gridx = 5;
		gbc_cmbTipoCita.gridy = 1;
		tabCreCita.add(cmbTipoCita, gbc_cmbTipoCita);
		
		JLabel lblPaciente = new JLabel("Paciente :");
		GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaciente.gridx = 3;
		gbc_lblPaciente.gridy = 2;
		tabCreCita.add(lblPaciente, gbc_lblPaciente);
		
		cmbPac = new JComboBox<>();
		cmbPac.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			pacSel = (Paciente) modeloComboPac.getSelectedItem();
			System.out.println(pacSel);
			}
		});
		inicializarComboPac();
		cmbPac.setModel(modeloComboPac);
		cmbPac.setSelectedIndex(1);
		
		GridBagConstraints gbc_cmbPac = new GridBagConstraints();
		gbc_cmbPac.insets = new Insets(0, 0, 5, 0);
		gbc_cmbPac.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPac.gridx = 5;
		gbc_cmbPac.gridy = 2;
		tabCreCita.add(cmbPac, gbc_cmbPac);
		
		JLabel lblFechaCita = new JLabel("Fecha Cita :");
		GridBagConstraints gbc_lblFechaCita = new GridBagConstraints();
		gbc_lblFechaCita.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaCita.gridx = 3;
		gbc_lblFechaCita.gridy = 3;
		tabCreCita.add(lblFechaCita, gbc_lblFechaCita);
		
		datChoFecCita = new JDateChooser();
		GridBagConstraints gbc_datChoFecCita = new GridBagConstraints();
		gbc_datChoFecCita.insets = new Insets(0, 0, 5, 0);
		gbc_datChoFecCita.fill = GridBagConstraints.BOTH;
		gbc_datChoFecCita.gridx = 5;
		gbc_datChoFecCita.gridy = 3;
		tabCreCita.add(datChoFecCita, gbc_datChoFecCita);
		
		JLabel lblEspCIta = new JLabel("Especialidad :");
		GridBagConstraints gbc_lblEspCIta = new GridBagConstraints();
		gbc_lblEspCIta.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspCIta.gridx = 3;
		gbc_lblEspCIta.gridy = 4;
		tabCreCita.add(lblEspCIta, gbc_lblEspCIta);
		
		txtEspCita = new JTextField();
		GridBagConstraints gbc_txtEspCita = new GridBagConstraints();
		gbc_txtEspCita.insets = new Insets(0, 0, 5, 0);
		gbc_txtEspCita.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspCita.gridx = 5;
		gbc_txtEspCita.gridy = 4;
		tabCreCita.add(txtEspCita, gbc_txtEspCita);
		txtEspCita.setColumns(10);
		
		JPanel tabConCita = new JPanel();
		tabbedPane.addTab("Consultar Citas", null, tabConCita, null);
		tabConCita.setLayout(new BorderLayout(0, 0));
		
		tableCita = new JTable();
		tableCita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCita.setModel(modeloCita);
		JScrollPane scrPanCita = new JScrollPane(tableCita);
		tabConCita.add(scrPanCita, BorderLayout.CENTER);
		
		tableCita.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				int indSel = lsm.getMaxSelectionIndex();
				if(indSel >= 0){
					TableModelCita modelo = (TableModelCita) tableCita.getModel();
					citaSel = modelo.obtenerCitaSeleccionada(indSel);
					
					btnEdiCita.setEnabled(true);
					btnEliCita.setEnabled(true);
					cmbPac.setSelectedIndex(1);
					cmbTipoCita.setSelectedIndex(1);
					
				}
				
				
			}
		});
		
		
		JPanel panel = new JPanel();
		tabConCita.add(panel, BorderLayout.NORTH);
		
		JLabel lblBusCitaPor = new JLabel("Buscar por Especialidad :");
		panel.add(lblBusCitaPor);
		
		JTextField txtConCita = new JTextField();
		panel.add(txtConCita);
		txtConCita.setColumns(10);
		
		JButton btnConCita = new JButton("Consultar");
		btnConCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			CitaTrs admCita = new CitaTrs();		
			List<String> columnas = new ArrayList<>();
			columnas.add("ID");
			columnas.add("Especialidad");
			columnas.add("Fecha Cita");
			columnas.add("Tipo CIta");
			columnas.add("Paciente");
			
			List<Cita> filas = admCita.consultarPorEspecialidad(txtConCita.getText());
			modeloCita = new TableModelCita(columnas, filas);
			tableCita.setModel(modeloCita);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Nose encuetra una cita registrada en esa especialidad" + e2.getMessage(),"Errores",JOptionPane.ERROR_MESSAGE);
			}
						
			}
		});
		btnConCita.setIcon(new ImageIcon(IFrmCita.class.getResource("/com/asoriach/agenda/resourses/archive.png")));
		panel.add(btnConCita);

	}

	public void inicializarComboTipo(){
		try {
			List<TipoCita> filas = new ArrayList<>();
			TipoCitaTrs admTipo = new TipoCitaTrs();
			filas = admTipo.consultarTodos();
			filas.add(tipoCitaVacio);
			modeloComboTipoCita = new ComboBoxModelTipoCita(filas);
			
		} catch (Exception e) {
			
		}
	}
	
	public void inicializarComboPac(){
		try {
			List<Paciente> filas = new ArrayList<>();
			PacienteTrs admPac = new PacienteTrs();
			filas = admPac.consultarTodos();
			filas.add(pacVacio);
			modeloComboPac = new ComboBoxModelPaciente(filas);
			
		} catch (Exception e) {
			
		}
	}
	
	
	private void inicializar(){
		try {
			// Inicializo Tipo Cita CBM
		//	List<TipoCita> filasTipo = new ArrayList<TipoCita>();
		//	TipoCitaTrs admTipoCita = new TipoCitaTrs();
		//	filasTipo = admTipoCita.consultarTodos();			
		//	modeloComboTipoCita = new ComboBoxModelTipoCita(filasTipo);
			inicializarComboTipo();
			// Inicializo Paciente CBM
		//	List<Paciente> filasPac = new ArrayList<Paciente>();
		//	PacienteTrs admPac = new PacienteTrs();
		//	filasPac = admPac.consultarTodos();
		//	modeloComboPac = new ComboBoxModelPaciente(filasPac);
			inicializarComboPac();
			
			// inicializar tabla de Citas
			List<String> columnas = new ArrayList<>();
			columnas.add("ID");
			columnas.add("Especialidad");
			columnas.add("Fecha Cita");
			columnas.add("Tipo CIta");
			columnas.add("Paciente");
			
			List<Cita> filasTabla = new ArrayList<Cita>();
			CitaTrs admCita = new CitaTrs();
			filasTabla = admCita.consultarTodos();
			
			modeloCita = new TableModelCita(columnas, filasTabla);
			
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se pudo inicializar estructuras de datos" + e.getMessage(),"Errores",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	
	
}
