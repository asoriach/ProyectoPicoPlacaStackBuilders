/**
 * 
 */
package com.asoriach.agenda.control;

import java.util.List; 

import com.asoriach.agenda.modelo.Doctor;
import com.asoriach.agenda.modelo.MemoriaBdd;

/**
 * Clase que representa la tabla de negocio para Doctores
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 18, 2019 - 5:28:14 PM
 */
public class DoctorTrs implements ICrudC {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrudC#guardar(java.lang.Object)
	 */
	@Override
	public String guardar(Object registro)  {
		if (registro != null) {
			
			int pos = MemoriaBdd.doctores.indexOf(registro); 
			if(pos>= 0){
				return "Registro Duplicado";
			}else {
				MemoriaBdd.doctores.add((Doctor) registro);
				return "Registro guardado correctamente";
			}
		}else{
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
			
			int pos = MemoriaBdd.doctores.lastIndexOf(registro);

			if (pos >= 0) {
				MemoriaBdd.doctores.set(pos, (Doctor) registro);
				return "Registro de Doctor actualizado correctamente";
			} else {
				return "No se encontro registro de Doctor";
			}
		} else {
			return "Debe llenar todos los campos";
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
			int pos = MemoriaBdd.doctores.lastIndexOf(registro);
			if (pos >= 0) {
				MemoriaBdd.doctores.remove(pos);
				return "Registro de Doctor eliminado correctamente";
			} else {
				return "No se encontro el registro de Doctor";
			}
		} else {
			return "Debe llenar todos los datos";
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrudC#ConsultarTodos()
	 */
	@Override
	public List<?> consultarTodos() {
		return MemoriaBdd.doctores; 

	}
	
	public Doctor consultarPorId(int idDocEli){
		Doctor docEnc = null;
		for(Doctor docTmp : MemoriaBdd.doctores){
			if (docTmp.getIdDoc() == idDocEli){
				docEnc = docTmp;
			}
			
		}
		
		return docEnc;
		
	}
	
	
	
	
	
	
	
	
	

	public String imprimirListaFormateada() {
		StringBuilder docLis = new StringBuilder();
		for (Doctor docTmp : MemoriaBdd.doctores) {
			if (docTmp != null) {
				docLis.append(docTmp.getIdDoc()).append("-").append(docTmp.getNombreDoc())
				.append(" - ").append(docTmp.getApellidoDoc()).append(" - ").append(docTmp.getEspecialidadDoc()).append("-").append(docTmp.getHorarioDoc()).append("-").append(docTmp.getSucursalDoc()).append("!!");
			}
		}
		return docLis.toString();
	}
	
	
	
	

}
