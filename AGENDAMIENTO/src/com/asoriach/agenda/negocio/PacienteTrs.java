/**
 * 
 */
package com.asoriach.agenda.negocio;

//import java.io.LineNumberInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asoriach.agenda.modelo.ConexionBdd;
import com.asoriach.agenda.modelo.Paciente;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 30, 2019 - 7:38:56 PM
 */
public class PacienteTrs implements ICrudC {

	@Override
	public String guardar(Object registro) throws Exception {
		String mensaje = null;
		try (Connection con = ConexionBdd.conectarBdd()) { // 1
			// 2
			String sqlInsPac = "INSERT INTO `sysmed`.`paciente`(`id_pac`,`nombre_pac`,`apellido_pac`,`identification_pac`,\r\n"
					+ "`fecha_nac_pac`,`direccion_pac`,`telefono_pac`,`correo_pac`,`genero_pac`,`seguro_pac`) VALUES (0,?,?,?,?,?,?,?,?,?);";
			try (PreparedStatement ptInsPac = con.prepareStatement(sqlInsPac)) {
				Paciente pac = (Paciente) registro;
				ptInsPac.setString(1, pac.getNombrePer());
				ptInsPac.setString(2, pac.getApellidoPer());
				ptInsPac.setString(3, pac.getIdentificacionPer());
				ptInsPac.setDate(4, new java.sql.Date(pac.getFechaNacPer().getTime()));
				ptInsPac.setString(5, pac.getDireccionPer());
				ptInsPac.setString(6, pac.getTelefonoPer());
				ptInsPac.setString(7, pac.getCorreoPer());
				ptInsPac.setString(8, pac.getGeneroPer());
				ptInsPac.setString(9, pac.getSeguroPer());

				int numFilAfe = ptInsPac.executeUpdate();
				if (numFilAfe > 0) {
					mensaje = "Registro de Paciente guardado correctamente";
				}

			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: P-St");

			}

		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST");
		}
		return mensaje;

	}

	@Override
	public String actualizar(Object registro) throws Exception {

		String mensaje = null;
		try (Connection con = ConexionBdd.conectarBdd()) { // 1
			// 2
			String sqlUpdPac = "UPDATE `sysmed`.`paciente` SET `nombre_pac` = ?,`apellido_pac` = ?,\r\n"
					+ "`identification_pac` = ?,`fecha_nac_pac` = ?,`direccion_pac` = ?,`telefono_pac` = ?,`correo_pac` = ?,`genero_pac` = ?,`seguro_pac` = ? WHERE `id_pac` = ?;";

			try (PreparedStatement ptUpdPac = con.prepareStatement(sqlUpdPac)) {
				Paciente pac = (Paciente) registro;
				ptUpdPac.setString(1, pac.getNombrePer());
				ptUpdPac.setString(2, pac.getApellidoPer());
				ptUpdPac.setString(3, pac.getIdentificacionPer());
				ptUpdPac.setDate(4, new java.sql.Date(pac.getFechaNacPer().getTime()));
				ptUpdPac.setString(5, pac.getDireccionPer());
				ptUpdPac.setString(6, pac.getTelefonoPer());
				ptUpdPac.setString(7, pac.getCorreoPer());
				ptUpdPac.setString(8, pac.getGeneroPer());
				ptUpdPac.setString(9, pac.getSeguroPer());
				ptUpdPac.setInt(10, pac.getIdPer());

				int numFilAfe = ptUpdPac.executeUpdate();
				if (numFilAfe > 0) {
					mensaje = "Registro de Paciente actualizado correctamente";
				}

			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: P-St");
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST");
		}
		return mensaje;

	}

	@Override
	public String eliminar(Object registro) throws Exception {
		String mensaje = null;
		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlDelPac = "DELETE FROM `sysmed`.`paciente` WHERE id_pac = ?;";
			try (PreparedStatement ptDelPac = con.prepareStatement(sqlDelPac)) {

				Paciente pac = (Paciente) registro;
				ptDelPac.setInt(1, pac.getIdPer());

				int numFilAfe = ptDelPac.executeUpdate();

				if (numFilAfe > 0) {
					mensaje = "Registro de paciente eliminado correctamente";
				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: P-St" + e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST" + e.getMessage());
		}
		return mensaje;

	}

	@Override
	public List<Paciente> consultarTodos() throws Exception {

		List<Paciente> listaPac = new ArrayList<>();
		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConPac = "SELECT * FROM paciente;";
			try (Statement stConPac = con.createStatement()) {
				ResultSet rs = stConPac.executeQuery(sqlConPac);
				while (rs.next()) {
					Paciente pac = new Paciente();
					pac.setIdPer(rs.getInt(1));
					pac.setNombrePer(rs.getString(2));
					pac.setApellidoPer(rs.getString(3));
					pac.setIdentificacionPer(rs.getString(4));
					pac.setFechaNacPer(rs.getDate(5));
					pac.setDireccionPer(rs.getString(6));
					pac.setTelefonoPer(rs.getString(7));
					pac.setCorreoPer(rs.getString(8));
					pac.setGeneroPer(rs.getString(9));
					pac.setSeguroPer(rs.getString(10));
					listaPac.add(pac);

				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: RS");
			}

		} catch (Exception e) {
			throw new Exception("Error al cerrar conexion con la Base de Datos: PT - ST");
		}
		return listaPac;
	}

	public List<Paciente> consultarPorNombreIdentificacion( String text) throws Exception {
		List<Paciente> listPac = new ArrayList<>();

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConPac = "SELECT * FROM sysmed.paciente WHERE nombre_pac LIKE ? or identification_pac LIKE ?;";
			try (PreparedStatement ptConPac = con.prepareStatement(sqlConPac)) {
				ptConPac.setString(1,"%" + text + "%");
				ptConPac.setString(2, "%" + text + "%");
				try {
					ResultSet rs = ptConPac.executeQuery();
					while (rs.next()) {
						Paciente pac = new Paciente();
						pac.setIdPer(rs.getInt(1));
						pac.setNombrePer(rs.getString(2));
						pac.setApellidoPer(rs.getString(3));
						pac.setIdentificacionPer(rs.getString(4));
						pac.setFechaNacPer(rs.getDate(5));
						pac.setDireccionPer(rs.getString(6));
						pac.setTelefonoPer(rs.getString(7));
						pac.setCorreoPer(rs.getString(8));
						pac.setGeneroPer(rs.getString(9));
						pac.setSeguroPer(rs.getString(10));
						listPac.add(pac);

					}
				} catch (Exception e) {
					throw new Exception("Error al cerrar conexion con la Base de Datos: RS");
				}
		} catch (Exception e) {
			throw new Exception("Error al cerrar conexion con la Base de Datos: PT");
		}

	}catch (Exception e) {
		throw new Exception("Error al cerrar conexion con la Base de Datos");
	}
	return listPac;

	}

	public Paciente consultarPorId(int idPac) throws Exception {
		Paciente pac = null;

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConIdPac = "SELECT * FROM sysmed.paciente WHERE id_pac = ?;";
			try (PreparedStatement ptConIdPac = con.prepareStatement(sqlConIdPac)) {
				ptConIdPac.setInt(1, idPac);
				try {
					ResultSet rs = ptConIdPac.executeQuery();
					if (rs.next()) {
						pac = new Paciente();
						pac.setIdPer(rs.getInt(1));
						pac.setNombrePer(rs.getString(2));
						pac.setApellidoPer(rs.getString(3));
						pac.setIdentificacionPer(rs.getString(4));
						pac.setFechaNacPer(rs.getDate(5));
						pac.setDireccionPer(rs.getString(6));
						pac.setTelefonoPer(rs.getString(7));
						pac.setCorreoPer(rs.getString(8));
						pac.setGeneroPer(rs.getString(9));
						pac.setSeguroPer(rs.getString(10));
					}
				} catch (Exception e) {
					throw new Exception("Error al cerrar conexion con la Base de Datos: RS" + e.getMessage());
				}
			} catch (Exception e) {

				throw new Exception("Error al cerrar conexion con la Base de Datos: PT" + e.getMessage());
			}
		} catch (Exception e) {

			throw new Exception("Error al cerrar conexion con la Base de Datos" + e.getMessage());
		}

		return pac;
	}

}
