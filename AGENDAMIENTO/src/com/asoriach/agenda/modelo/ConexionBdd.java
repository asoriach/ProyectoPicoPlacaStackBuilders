/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que administra la conexion a la Base de Datos 
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 22, 2019 - 12:06:19 PM
 */
public class ConexionBdd {

	private static final String USER = "root";
	private static final String PASSWORD = "1408angel";

	private static final String CADENABDD_MYSQL = "jdbc:mysql://localhost:3306/sysmed?serverTimezone=UTC";

	public static Connection conectarBdd() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CADENABDD_MYSQL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Driver Incorrecto: " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("Credenciales o URL incorrecto: " + e.getMessage());

		}
		return con;
	}

}
