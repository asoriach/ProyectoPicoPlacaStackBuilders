/**
 * 
 */
package com.asoriach.agenda.form;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asoriach.agenda.modelo.Usuario;
import com.asoriach.agenda.negocio.UsuarioTrs;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 14, 2019 - 5:42:56 PM
 */
public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField ptxtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Set Look and feel
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
					// ubicar en el centro
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		/**
		 * 
		 */

		setTitle(":: SYSMED ::");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblUsu = new JLabel("Usuario :");
		GridBagConstraints gbc_lblUsu = new GridBagConstraints();
		gbc_lblUsu.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsu.gridx = 3;
		gbc_lblUsu.gridy = 2;
		panel.add(lblUsu, gbc_lblUsu);

		txtUsu = new JTextField();
		GridBagConstraints gbc_txtUsu = new GridBagConstraints();
		gbc_txtUsu.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsu.gridx = 5;
		gbc_txtUsu.gridy = 2;
		panel.add(txtUsu, gbc_txtUsu);
		txtUsu.setColumns(10);

		JLabel lblClave = new JLabel("Clave :");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.anchor = GridBagConstraints.EAST;
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 3;
		gbc_lblClave.gridy = 4;
		panel.add(lblClave, gbc_lblClave);

		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// 1.Verificar los campos en la BDD
					if (!txtUsu.getText().equals("") && !ptxtClave.getText().equals("")) {
						UsuarioTrs admUsu = new UsuarioTrs();
						Usuario usuario = admUsu.validarUsuario(txtUsu.getText(), ptxtClave.getText());

						if (usuario != null) {
							// Cerrar la pantalla login
							FrmLogin.this.dispose();
							FrmPrincipal frmPrincipal = new FrmPrincipal();
							frmPrincipal.setVisible(true);
							frmPrincipal.setExtendedState(MAXIMIZED_BOTH);

						} else {
							JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Errores",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Error credenciales", "Errores", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Error Ingreso" + e2.getMessage(),"Errores", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		ptxtClave = new JPasswordField();
		GridBagConstraints gbc_ptxtClave = new GridBagConstraints();
		gbc_ptxtClave.insets = new Insets(0, 0, 5, 5);
		gbc_ptxtClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_ptxtClave.gridx = 5;
		gbc_ptxtClave.gridy = 4;
		panel.add(ptxtClave, gbc_ptxtClave);
		GridBagConstraints gbc_btnIngreso = new GridBagConstraints();
		gbc_btnIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngreso.gridx = 5;
		gbc_btnIngreso.gridy = 6;
		panel.add(btnIngreso, gbc_btnIngreso);
	}

}
