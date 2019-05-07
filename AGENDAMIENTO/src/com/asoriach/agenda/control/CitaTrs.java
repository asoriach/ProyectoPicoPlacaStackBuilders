/**
 * 
 */
package com.asoriach.agenda.control;

import java.util.List;

import com.asoriach.agenda.modelo.Cita;
import com.asoriach.agenda.modelo.MemoriaBdd;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 21, 2019 - 6:22:58 PM
 */
public class CitaTrs implements ICrudC {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrudC#guardar(java.lang.Object)
	 */
	@Override
	public String guardar(Object registro) {

		if (registro != null) {
			/*
			 * Verificar la posición del registro
			 */
			int pos = MemoriaBdd.citas.indexOf(registro);
			if (pos >= 0) {
				return "Registro duplicado";
			} else {
				MemoriaBdd.citas.add((Cita) registro);
				return "Registro guardado correctamente";
			}
		} else {
			return "Debe llenar todos los datos";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrudC#actualizar(java.lang.Object)
	 */
	@Override
	public String actualizar(Object registro) {

		if (registro != null) {
			
			int pos = MemoriaBdd.citas.lastIndexOf(registro);
			if (pos >= 0) {
				MemoriaBdd.citas.set(pos, (Cita) registro);
				return "Registro actualizado correctamente";
				
			} else {
				return "No se encontró el registro";
			}
		} else {
			return "Debe llenar todos los datos";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrudC#eliminar(java.lang.Object)
	 */
	@Override
	public String eliminar(Object registro) {

		if (registro != null) {
			
			int pos = MemoriaBdd.citas.lastIndexOf(registro);
			if (pos >= 0) {
				// Actualiza la lista en una posición; es decir se reemplaza
				MemoriaBdd.citas.remove(pos);		
				return "Registro eliminado correctamente";
			} 
			else {
				return "No se encontró el registro";
			}
			
		} else {
			return "Debe llenar todos los datos";
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrudC#consultarTodos()
	 */
	@Override
	public List<?> consultarTodos() {
		return MemoriaBdd.citas;
	}

	
	public Cita consultarPorId(int idCitaEli) {
		Cita citaEnc = null;
		for (Cita citaTmp : MemoriaBdd.citas) {
			if (citaTmp.getIdCita() == idCitaEli) {
				citaEnc = citaTmp;
			}

		}

		return citaEnc;

	}

}
