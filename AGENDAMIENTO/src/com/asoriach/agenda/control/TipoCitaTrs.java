/**
 * 
 */
package com.asoriach.agenda.control;

import com.asoriach.agenda.modelo.MemoriaBdd;
import com.asoriach.agenda.modelo.Paciente;
import com.asoriach.agenda.modelo.TipoCita;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * Mar 5, 2019 - 8:37:15 PM
 */
public class TipoCitaTrs implements ICrud {

	@Override
	public String guardar(Object registro) {

		boolean banIng = false;
		if (registro != null) {
			for(int i= 0 ;i<MemoriaBdd.tipoCitas.length;i++){
				if(MemoriaBdd.tipoCitas[i] == null){
					MemoriaBdd.tipoCitas[i] = (TipoCita) registro;
					banIng = true;
					break; 
				}	
			}
				if(banIng){
					return "Tipo Cita registrado correctamente";
					}	
				else{
					return "El numero maximo de Tipo de Citas es de 5";
				}
				}else{
					return "Debe llenar todos los campos"; 
				}
	
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.control.ICrud#actualizar(int, java.lang.Object)
	 */
	@Override
	public String actualizar(int id, Object registro) {
		// Busqueda 
		int posEnc = 0;
		boolean banEnc = false; 
		for (TipoCita tipoCita : MemoriaBdd.tipoCitas ) {

			if(tipoCita != null && tipoCita.getId() == id ){
				banEnc = true ;
				break;
			}
			posEnc++;
			
		}
		if(banEnc){
			MemoriaBdd.tipoCitas[posEnc] = (TipoCita) registro; 
			return "Registro de Tipo Cita actualizado exitosamente";
		}else{
			
			return "Nose encontro el registro de Cita";
		}
		
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.control.ICrud#eliminar(int)
	 */
	@Override
	public String eliminar(int id) {
		int posEnc = 0;
		boolean banEnc = false;
		for (TipoCita tipoCita : MemoriaBdd.tipoCitas) {
			if (tipoCita != null && tipoCita.getId() == id) {
				// Recuperarme la posición donde le encontre
				banEnc = true;
				break;
			}
			posEnc++;
		}

		if (banEnc) {
			MemoriaBdd.tipoCitas[posEnc] = null;
			return "Registro eliminado correctamente";
		} else {
			return "No se encontró registro";
		}
	
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.control.ICrud#listar()
	 */
	@Override
	public Object[] listar() {
		return MemoriaBdd.tipoCitas;
	}

	/* (non-Javadoc)
	 * @see com.asoriach.agenda.control.ICrud#consultarPorId(int)
	 */
	@Override
	public Object consultarPorId(int id) {
	
		TipoCita tipoCitaEnc = null;
			for (int i = 0; i < MemoriaBdd.tipoCitas.length; i++) {
				if (MemoriaBdd.tipoCitas[i].getId() == id) {
					tipoCitaEnc = MemoriaBdd.tipoCitas[i];
					break;
				}
			}
		
		return tipoCitaEnc;
		
	}
	
	public String imprimirListaFormateada() {
		StringBuilder tipoCitaLis = new StringBuilder();
		for (TipoCita tipoCitaTmp : MemoriaBdd.tipoCitas) {
			if (tipoCitaTmp != null) {
				tipoCitaLis.append(tipoCitaTmp.getId()).append("-").append(tipoCitaTmp.getNombreCita())
						.append(" - ").append(tipoCitaTmp.getSucursalCita()).append("!!");
			}
		}
		return tipoCitaLis.toString();
	}
	
	

}
