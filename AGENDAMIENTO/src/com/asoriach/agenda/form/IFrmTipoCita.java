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
import javax.swing.table.TableModel;

import com.asoriach.agenda.negocio.TipoCitaTrs;
import com.asoriach.agenda.form.util.TableModelTipoCita;
import com.asoriach.agenda.modelo.TipoCita;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 22, 2019 - 4:36:49 PM
 */
public class IFrmTipoCita extends JInternalFrame {
	private JTextField txtNomTipoCita;
	private JTextField txtCenTipoCita;
	private JTabbedPane tabbedPane;
	private JButton btnEdiTipoCita;
	private JButton btnEliTipoCita;
	private TipoCita tipoCitaSel;
	private TableModelTipoCita modeloTipoCita;
	private JPanel tabIngTipoCita;
	private JPanel tabLisTipoCita;
	private JPanel pnlBusTipCita;
	private JTable tableTipoCita;

	/**
	 * Create the frame.
	 */
	public IFrmTipoCita() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);

		inicializar();

		setTitle(":: SYSMED Tipo Cita ::");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNueTipoCita = new JButton("Nuevo");
		btnNueTipoCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomTipoCita.setText("");
				txtCenTipoCita.setText("");
			}
		});
		btnNueTipoCita
				.setIcon(new ImageIcon(IFrmTipoCita.class.getResource("/com/asoriach/agenda/resourses/new24X24.png")));
		toolBar.add(btnNueTipoCita);

		JButton btnGuaTipoCita = new JButton("Guardar");
		btnGuaTipoCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNomTipoCita.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Ingrese el tipo cita");
					} else {
						TipoCita tipoCita = new TipoCita();
						tipoCita.setNombreCita(txtNomTipoCita.getText());
						tipoCita.setSucursalCita(txtCenTipoCita.getText());
						TipoCitaTrs admTipoCita = new TipoCitaTrs();
						String mensaje = null;

						if (tipoCitaSel == null) {
							mensaje = admTipoCita.guardar(tipoCita);
						} else {
							tipoCita.setId(tipoCitaSel.getId());
							mensaje = admTipoCita.actualizar(tipoCita);
						}
						JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);

						txtNomTipoCita.setText("");
						txtCenTipoCita.setText("");

						tipoCitaSel = null;
						inicializar();
						tableTipoCita.setModel(modeloTipoCita);
						btnEdiTipoCita.setEnabled(false);
						btnEliTipoCita.setEnabled(false);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al Guardar", "Errores", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuaTipoCita
				.setIcon(new ImageIcon(IFrmTipoCita.class.getResource("/com/asoriach/agenda/resourses/diskette.png")));
		toolBar.add(btnGuaTipoCita);

		btnEdiTipoCita = new JButton("Editar");
		btnEdiTipoCita.setEnabled(false);
		btnEdiTipoCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipoCitaSel != null) {
					tabbedPane.setSelectedIndex(0);
					txtNomTipoCita.setText(tipoCitaSel.getNombreCita());
					txtCenTipoCita.setText(tipoCitaSel.getSucursalCita());
				} else {
					JOptionPane.showMessageDialog(null, "No selecciono registro", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEdiTipoCita
				.setIcon(new ImageIcon(IFrmTipoCita.class.getResource("/com/asoriach/agenda/resourses/clipboard.png")));
		toolBar.add(btnEdiTipoCita);

		btnEliTipoCita = new JButton("Eliminar");
		btnEliTipoCita.setEnabled(false);
		btnEliTipoCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(tipoCitaSel != null){
					int valCon = JOptionPane.showConfirmDialog(null, "Desea eliminar el tipo de cita","Confirmacion", JOptionPane.YES_NO_OPTION );
					if(valCon == 0){
					TipoCitaTrs admTipocita = new TipoCitaTrs();
					String mensaje = admTipocita.eliminar(tipoCitaSel);
					JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
					tipoCitaSel = null;
					inicializar();
					tableTipoCita.setModel(modeloTipoCita);
					btnEdiTipoCita.setEnabled(false);
					btnEliTipoCita.setEnabled(false);
				}
				} else {
					JOptionPane.showMessageDialog(null,"No se ha seleccionado el tipo de cita","Error", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error al eliminar","Error",JOptionPane.ERROR_MESSAGE);
			}
				
			
			}
		});
		btnEliTipoCita
				.setIcon(new ImageIcon(IFrmTipoCita.class.getResource("/com/asoriach/agenda/resourses/trash.png")));
		toolBar.add(btnEliTipoCita);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabIngTipoCita = new JPanel();
		tabbedPane.addTab("Registro", null, tabIngTipoCita, null);
		GridBagLayout gbl_tabIngTipoCita = new GridBagLayout();
		gbl_tabIngTipoCita.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_tabIngTipoCita.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_tabIngTipoCita.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_tabIngTipoCita.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		tabIngTipoCita.setLayout(gbl_tabIngTipoCita);

		JLabel lblNomTipoCita = new JLabel("Tipo de Cita : ");
		GridBagConstraints gbc_lblNomTipoCita = new GridBagConstraints();
		gbc_lblNomTipoCita.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomTipoCita.gridx = 2;
		gbc_lblNomTipoCita.gridy = 1;
		tabIngTipoCita.add(lblNomTipoCita, gbc_lblNomTipoCita);

		txtNomTipoCita = new JTextField();
		GridBagConstraints gbc_txtNomTipoCita = new GridBagConstraints();
		gbc_txtNomTipoCita.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomTipoCita.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomTipoCita.gridx = 4;
		gbc_txtNomTipoCita.gridy = 1;
		tabIngTipoCita.add(txtNomTipoCita, gbc_txtNomTipoCita);
		txtNomTipoCita.setColumns(10);

		JLabel lblCenTipoCita = new JLabel("Centro de Atencion :");
		GridBagConstraints gbc_lblCenTipoCita = new GridBagConstraints();
		gbc_lblCenTipoCita.insets = new Insets(0, 0, 0, 5);
		gbc_lblCenTipoCita.gridx = 2;
		gbc_lblCenTipoCita.gridy = 2;
		tabIngTipoCita.add(lblCenTipoCita, gbc_lblCenTipoCita);

		txtCenTipoCita = new JTextField();
		GridBagConstraints gbc_txtCenTipoCita = new GridBagConstraints();
		gbc_txtCenTipoCita.insets = new Insets(0, 0, 0, 5);
		gbc_txtCenTipoCita.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenTipoCita.gridx = 4;
		gbc_txtCenTipoCita.gridy = 2;
		tabIngTipoCita.add(txtCenTipoCita, gbc_txtCenTipoCita);
		txtCenTipoCita.setColumns(10);

		tabLisTipoCita = new JPanel();
		tabbedPane.addTab("Listar", null, tabLisTipoCita, null);
		tabLisTipoCita.setLayout(new BorderLayout(0, 0));

		pnlBusTipCita = new JPanel();
		tabLisTipoCita.add(pnlBusTipCita, BorderLayout.NORTH);

		tableTipoCita = new JTable();
		tableTipoCita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTipoCita.setModel(modeloTipoCita);
		JScrollPane spTipoCita = new JScrollPane(tableTipoCita);
		tabLisTipoCita.add(spTipoCita, BorderLayout.CENTER);
		
//		tabLisTipoCita.add(tableTipoCita, BorderLayout.CENTER);
		tableTipoCita.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				int indSel = lsm.getMaxSelectionIndex();
				if( indSel >= 0){
					TableModelTipoCita modelo = (TableModelTipoCita) tableTipoCita.getModel();
					tipoCitaSel = modelo.obtenerFilaSeleccionada(indSel);
					btnEdiTipoCita.setEnabled(true);
					btnEliTipoCita.setEnabled(true);
				}
				
			}
		});
		
		
	}

	private void inicializar() {
		try {
			List<String> columnas = new ArrayList<>();
			columnas.add("Id");
			columnas.add("Tipo Cita");
			columnas.add("Sucursal");

			List<TipoCita> filas = new ArrayList<TipoCita>();
			TipoCitaTrs admTipoCita = new TipoCitaTrs();
			filas = admTipoCita.consultarTodos();

			modeloTipoCita = new TableModelTipoCita(columnas, filas);
		} catch (Exception e) {

		}

	}

}
