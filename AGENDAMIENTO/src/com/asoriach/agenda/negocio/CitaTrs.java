/**
 * 
 */
package com.asoriach.agenda.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.asoriach.agenda.modelo.Cita;
import com.asoriach.agenda.modelo.ConexionBdd;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         May 1, 2019 - 5:58:31 PM
 */
public class CitaTrs implements ICrudC {

	@Override
	public String guardar(Object registro) throws Exception {
		String mensaje = null;
		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlInsCita = "INSERT INTO `sysmed`.`cita`(`id_cita`,`especialidad_cita`,`fecha_cita`,\r\n"
					+ "`tipo_cita_id_tipo_cita`,`paciente_id_pac`) VALUES (0,?,?,?,?);";

			try (PreparedStatement ptInsCita = con.prepareStatement(sqlInsCita)) {
				Cita cita = (Cita) registro;
				ptInsCita.setString(1, cita.getEspecialidadCita());
				ptInsCita.setDate(2, new java.sql.Date(cita.getFechaCita().getTime()));
				ptInsCita.setInt(3, cita.getTipocita().getId());
				ptInsCita.setInt(4, cita.getPaciente().getIdPer());

				int numFilAfe = ptInsCita.executeUpdate();

				if (numFilAfe > 0) {
					// Queda pendiente poner el mansaje de guradado con el valor
					// a pagar
					mensaje = "La cita se agendado correctamente ";
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
	public String actualizar(Object registro) throws Exception {
		String mensaje = null;

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlUpdCita = "UPDATE `sysmed`.`cita`\r\n" + "SET\r\n" + "`especialidad_cita` = ?,\r\n"
					+ "`fecha_cita` = ?,\r\n" + "`tipo_cita_id_tipo_cita` = ?,\r\n" + "`paciente_id_pac` = ? \r\n"
					+ "WHERE `id_cita` = ?;";

			try (PreparedStatement ptUpdCita = con.prepareStatement(sqlUpdCita)) {
				Cita cita = (Cita) registro;
				ptUpdCita.setString(1, cita.getEspecialidadCita());
				ptUpdCita.setDate(2, new java.sql.Date(cita.getFechaCita().getTime()));
				ptUpdCita.setInt(3, cita.getTipocita().getId());
				ptUpdCita.setInt(4, cita.getPaciente().getIdPer());
				ptUpdCita.setInt(5, cita.getIdCita());

				int numFilAfe = ptUpdCita.executeUpdate();
				if (numFilAfe > 0) {
					// Queda pendiente poner el mansaje de guradado con el valor
					// a pagar
					mensaje = "La cita se agendada se actualizo correctamente ";
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
	public String eliminar(Object registro) throws Exception {
		String mensaje = null;

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlDelCita = "DELETE FROM `sysmed`.`cita` WHERE id_cita = ?;";
			try (PreparedStatement ptDelCita = con.prepareStatement(sqlDelCita)) {

				Cita cita = (Cita) registro;
				ptDelCita.setInt(1, cita.getIdCita());

				int numFilAfe = ptDelCita.executeUpdate();

				if (numFilAfe > 0) {
					// poner mensaje de valor a pagar tanto
					mensaje = "Cita agendada eliminada correctamente";
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
	public List<Cita> consultarTodos() throws Exception {
		TipoCitaTrs admTipoCita = new TipoCitaTrs();
		PacienteTrs admPac = new PacienteTrs();

		List<Cita> listaCitas = new ArrayList<>();

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConCita = "SELECT * FROM cita;";

			try (Statement stConCita = con.createStatement(); ResultSet rs = stConCita.executeQuery(sqlConCita);) {
				while (rs.next()) {
					Cita cita = new Cita();

					cita.setIdCita(rs.getInt(1));

					cita.setEspecialidadCita(rs.getString(2));

					cita.setFechaCita(rs.getDate(3));
					cita.setTipocita(admTipoCita.consultarPorId(rs.getInt(4)));
					cita.setPaciente(admPac.consultarPorId(rs.getInt(5)));
					listaCitas.add(cita);

				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: Rt" + e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST" + e.getMessage());
		}

		return listaCitas;
	}

	public List<Cita> consultarPorEspecialidad(String text) throws Exception {
		TipoCitaTrs admTipoCita = new TipoCitaTrs();
		PacienteTrs admPac = new PacienteTrs();

		List<Cita> listaCitas = new ArrayList<>();

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConCita = "SELECT * FROM sysmed.cita WHERE especialidad_cita LIKE ?;";

			try (PreparedStatement ptConCita = con.prepareStatement(sqlConCita)) {
				ptConCita.setString(1, "%" + text + "%");

				try {
					ResultSet rs = ptConCita.executeQuery();
					while (rs.next()) {
						Cita cita = new Cita();

						cita.setIdCita(rs.getInt(1));

						cita.setEspecialidadCita(rs.getString(2));

						cita.setFechaCita(rs.getDate(3));
						cita.setTipocita(admTipoCita.consultarPorId(rs.getInt(4)));
						cita.setPaciente(admPac.consultarPorId(rs.getInt(5)));
						listaCitas.add(cita);

					}
				} catch (Exception e) {
					throw new Exception("Error al cerrar conexion con la Base de Datos: Rt" + e.getMessage());
				}

			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: Rt" + e.getMessage());
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST" + e.getMessage());
		}

		return listaCitas;
	}

}
