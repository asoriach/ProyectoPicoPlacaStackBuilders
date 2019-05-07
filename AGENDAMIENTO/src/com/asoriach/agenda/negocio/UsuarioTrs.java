/**
 * 
 */
package com.asoriach.agenda.negocio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.asoriach.agenda.modelo.ConexionBdd;
import com.asoriach.agenda.modelo.Usuario;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * Apr 22, 2019 - 12:49:54 PM
 */
public class UsuarioTrs implements ICrudC {

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.negocio.ICrudC#guardar(java.lang.Object)
	 */
	@Override
	public String guardar(Object registro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.negocio.ICrudC#actualizar(java.lang.Object)
	 */
	@Override
	public String actualizar(Object registro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.negocio.ICrudC#eliminar(java.lang.Object)
	 */
	@Override
	public String eliminar(Object registro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.negocio.ICrudC#consultarTodos()
	 */
	@Override
	public List<?> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario validarUsuario(String usuario, String clave) throws Exception {
		Usuario usuDev = null; 
		//1. Recuperar la conexion 
		Connection con = ConexionBdd.conectarBdd();
		//2. Establecer la operacion: DDL o DML 
		String sqlConUsu = "SELECT * FROM usuario\r\n" + "WHERE nombre_usu = '" + usuario + "' and \r\n"
				+ "      clave_usu = '" + clave + "';";
		//3. Elegir el tipo de objecto JDBC a utilizar
		Statement stConUsu = con.createStatement();
		
		//4. Proceder a ejecutar la sentencia SQL 
		ResultSet rs = stConUsu.executeQuery(sqlConUsu);
		
		//5. Procesar la informacion 
		
		if(rs.next()){
			usuDev = new Usuario ();
			usuDev.setNombreUsu(rs.getString(2)); // Pos de la columna
			usuDev.setClaveUsu(rs.getString("clave_usu")); // nombre columna
		}
		
		return usuDev;
		
	}
	
	
	
}
