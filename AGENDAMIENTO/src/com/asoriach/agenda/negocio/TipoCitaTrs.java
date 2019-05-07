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

import com.asoriach.agenda.modelo.ConexionBdd;
import com.asoriach.agenda.modelo.TipoCita;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 22, 2019 - 12:50:10 PM
 */
public class TipoCitaTrs implements ICrudC {

	@Override
	public String guardar(Object registro) throws Exception {

		String mensaje = null;

		// 1. Recuperar Conexion
		try (Connection con = ConexionBdd.conectarBdd()) {

			// 2. Establecer operacion: DDL o DML
			String sqlInsTipoCita = "INSERT INTO `sysmed`.`tipo_cita`(`id_tipo_cita`,`nombre_tipo_cita`,`cen_tipo_cita`) VALUES (0,?,?);";

			// 3. Usar Prepared o Statement from JDBC
			try (PreparedStatement ptInsTipoCita = con.prepareStatement(sqlInsTipoCita)) {
				TipoCita tipoCita = (TipoCita) registro;
				ptInsTipoCita.setString(1, tipoCita.getNombreCita());
				ptInsTipoCita.setString(2, tipoCita.getSucursalCita());
				int numFilAfe = ptInsTipoCita.executeUpdate();
				if (numFilAfe > 0) {
					mensaje = "Registro guardado conrrectamente";
				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: P-St");
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST");
		}
		return mensaje;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.negocio.ICrudC#actualizar(java.lang.Object)
	 */
	@Override
	public String actualizar(Object registro) throws Exception {

		String mensaje = null;

		// 1. Recuperar Conexion
		try (Connection con = ConexionBdd.conectarBdd()) {

			// 2. Establecer operacion: DDL o DML
			String sqlUpdTipoCita = "UPDATE `sysmed`.`tipo_cita` SET `nombre_tipo_cita` = ?,`cen_tipo_cita` = ? WHERE `id_tipo_cita` = ?;";

			// 3. Usar Prepared o Statement from JDBC
			try (PreparedStatement ptUpdTipoCita = con.prepareStatement(sqlUpdTipoCita)) {
				TipoCita tipoCita = (TipoCita) registro;
				ptUpdTipoCita.setString(1, tipoCita.getNombreCita());
				ptUpdTipoCita.setString(2, tipoCita.getSucursalCita());
				ptUpdTipoCita.setInt(3, tipoCita.getId());

				int numFilAfe = ptUpdTipoCita.executeUpdate();

				if (numFilAfe > 0) {
					mensaje = "Registro actualizado conrrectamente";
				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: P-St");
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST");
		}
		return mensaje;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.negocio.ICrudC#eliminar(java.lang.Object)
	 */
	@Override
	public String eliminar(Object registro) throws Exception {

		String mensaje = null;

		// 1. Recuperar Conexion
		try (Connection con = ConexionBdd.conectarBdd()) {

			// 2. Establecer operacion: DDL o DML
			String sqlDelTipoCita = "DELETE FROM `sysmed`.`tipo_cita` WHERE id_tipo_cita = ?;";

			// 3. Usar Prepared o Statement from JDBC
			try (PreparedStatement ptDelTipoCita = con.prepareStatement(sqlDelTipoCita)) {

				TipoCita tipoCita = (TipoCita) registro;
				ptDelTipoCita.setInt(1, tipoCita.getId());

				int numFilAfe = ptDelTipoCita.executeUpdate();

				if (numFilAfe > 0) {
					mensaje = "Registro eliminado correctamente";
				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: P-St");
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar la conexion con la Base de Datos: ST");
		}
		return mensaje;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.negocio.ICrudC#consultarTodos()
	 */
	@Override
	public List<TipoCita> consultarTodos() throws Exception {

		List<TipoCita> listaTipoCitas = new ArrayList<>();
		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConTipoCita = "SELECT * FROM tipo_cita;";
			try (Statement stConTipoCita = con.createStatement()) {
				ResultSet rs = stConTipoCita.executeQuery(sqlConTipoCita);
				while (rs.next()) {
					TipoCita tipoCita = new TipoCita();
					tipoCita.setId(rs.getInt(1));
					tipoCita.setNombreCita(rs.getString(2));
					tipoCita.setSucursalCita(rs.getString(3));
					listaTipoCitas.add(tipoCita);
				}
			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: RS");
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar conexion con la Base de Datos: PT - ST");
		}
		return listaTipoCitas;
	}

	public TipoCita consultarPorId(int idTipoCita) throws Exception {

		TipoCita tipoCita = null;

		try (Connection con = ConexionBdd.conectarBdd()) {
			String sqlConTipoCita = "SELECT * FROM sysmed.tipo_cita WHERE id_tipo_cita = ?;";
			try (PreparedStatement stConTipoCita = con.prepareStatement(sqlConTipoCita)) {
				stConTipoCita.setInt(1, idTipoCita);
				try {

					ResultSet rs = stConTipoCita.executeQuery();

					if (rs.next()) {
						tipoCita = new TipoCita();
						tipoCita.setId(rs.getInt(1));
						tipoCita.setNombreCita(rs.getString(2));
						tipoCita.setSucursalCita(rs.getString(3));

					}
				} catch (Exception e) {
					throw new Exception("Error al cerrar conexion con la Base de Datos: RS");
				}

			} catch (Exception e) {
				throw new Exception("Error al cerrar conexion con la Base de Datos: PT");
			}
		} catch (Exception e) {
			throw new Exception("Error al cerrar conexion con la Base de Datos ");
		}
		return tipoCita;

	}

}
