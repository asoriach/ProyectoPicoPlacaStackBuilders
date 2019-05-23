package com.pico.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;

import com.pico.negocio.ImplementacionTrs;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase que representa el formulario de presentacion del sistema basado en SWING 
 * @author angelsoriachicaiza
 *
 */

public class FrmPicoPlaca extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtHora;
	private JTextField txtFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPicoPlaca frame = new FrmPicoPlaca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPicoPlaca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPlaca = new JLabel("Placa (Ej: PBX0124) :");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 2;
		gbc_lblPlaca.gridy = 2;
		panel.add(lblPlaca, gbc_lblPlaca);
		
		txtPlaca = new JTextField();
		GridBagConstraints gbc_txtPlaca = new GridBagConstraints();
		gbc_txtPlaca.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlaca.gridx = 3;
		gbc_txtPlaca.gridy = 2;
		panel.add(txtPlaca, gbc_txtPlaca);
		txtPlaca.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha (Ej: 31/04/2019):");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 2;
		gbc_lblFecha.gridy = 3;
		panel.add(lblFecha, gbc_lblFecha);
		
		txtFecha = new JTextField();
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.insets = new Insets(0, 0, 5, 0);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 3;
		gbc_txtFecha.gridy = 3;
		panel.add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hora (Ej 21:40) :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtHora = new JTextField();
		GridBagConstraints gbc_txtHora = new GridBagConstraints();
		gbc_txtHora.insets = new Insets(0, 0, 5, 0);
		gbc_txtHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHora.gridx = 3;
		gbc_txtHora.gridy = 4;
		panel.add(txtHora, gbc_txtHora);
		txtHora.setColumns(10);
		
		JButton btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if( !txtPlaca.getText().equals("") && !txtFecha.getText().equals("") && !txtHora.getText().equals("")){
						ImplementacionTrs admPico = new ImplementacionTrs();
						//char digito = admPico.obtenerPlaca(txtPlaca.getText());
						String digito = admPico.obtenerPlaca(txtPlaca.getText());	
						boolean verDia = admPico.validarDia(digito, txtFecha.getText());
						boolean verhora = admPico.validarHora(txtHora.getText());
						String mensaje = admPico.validarPicoPlaca(verDia, verhora);
							
						JOptionPane.showMessageDialog(null, mensaje,"Informacion",JOptionPane.INFORMATION_MESSAGE);
						txtPlaca.setText("");
						txtFecha.setText("");
						txtHora.setText("");
						mensaje = null;
						
					}else{
						JOptionPane.showMessageDialog(null, "Por favor llene todos los campos","Errores",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error programa por /n"+e2.getMessage(),"Errores",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnConsulta = new GridBagConstraints();
		gbc_btnConsulta.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsulta.gridx = 3;
		gbc_btnConsulta.gridy = 6;
		panel.add(btnConsulta, gbc_btnConsulta);
	}
	

}
