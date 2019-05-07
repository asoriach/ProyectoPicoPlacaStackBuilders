/**
 * 
 */
package com.asoriach.agenda.control;

import com.asoriach.agenda.modelo.MemoriaBdd; 
import com.asoriach.agenda.modelo.Paciente;
import com.asoriach.agenda.modelo.TipoCita;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Mar 5, 2019 - 8:38:31 PM
 */
public class PacienteTrs implements ICrud {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrud#guardar(java.lang.Object)
	 */
	@Override
	public String guardar(Object registro) {
		// TODO Auto-generated method stub
		
		boolean banIng = false;
		if (registro != null) {
			for(int i= 0 ;i<MemoriaBdd.pacientes.length;i++){
				if(MemoriaBdd.pacientes[i] == null){
					MemoriaBdd.pacientes[i] = (Paciente) registro;
					banIng = true;
					break; 
				}	
			}
				if(banIng){
					return "Paciente registrado correctamente";
					}	
				else{
					return "El numero maximo de pacientes es de 5";
				}
				}else{
					return "Debe llenar todos los campos"; 
				}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrud#actualizar(int, java.lang.Object)
	 */
	@Override
	public String actualizar(int id, Object registro) {
		// TODO Auto-generated method stub
		int posEnc = 0; 
		boolean banEnc = false; 
		for(Paciente paciente : MemoriaBdd.pacientes){
			if(paciente != null && paciente.getIdPer() == id){
				banEnc = true;
				break;
			}
			posEnc++;
		}
		
		if(banEnc){
			MemoriaBdd.pacientes[posEnc]=(Paciente) registro; 
			return "Registro actualizado correctamente";
		}
		else{
			return "No se encontro el registro"; 
		}
	}	


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrud#eliminar(int)
	 */
	@Override
	public String eliminar(int id) {
		// TODO Auto-generated method stub
		int posEnc = 0;
		boolean banEnc = false; 
		for(Paciente paciente : MemoriaBdd.pacientes){
			if(paciente != null && paciente.getIdPer()== id ){
				banEnc = true ;
				break;
			}
		posEnc++;
		}
		if(banEnc){
			MemoriaBdd.pacientes[posEnc] = null; 
			return "Paciente eliminado correctamente";
		}
		else{
			return "No se encontro al paciente";	
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrud#listar()
	 */
	@Override
	public Object[] listar() {
		// TODO Auto-generated method stub
		return MemoriaBdd.pacientes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asoriach.agenda.control.ICrud#consultarPorId(int)
	 */
	@Override
	public Object consultarPorId(int id) {
	
		Paciente pacEnc = null;
			for (int i = 0; i < MemoriaBdd.pacientes.length; i++) {
				if (MemoriaBdd.pacientes[i].getIdPer() == id) {
					pacEnc = MemoriaBdd.pacientes[i];
					break;
				}
			}
		
		return pacEnc;
		
	}
	
	public String imprimirListaFormateada() {
		StringBuilder pacLis = new StringBuilder();
		for (Paciente pacTmp : MemoriaBdd.pacientes) {
			if (pacTmp != null) {
				pacLis.append(pacTmp.getIdPer()).append("-").append(pacTmp.getNombrePer())
						.append(" - ").append(pacTmp.getApellidoPer()).append(" - ").append(pacTmp.getSeguroPer()).append("!!");
			}
		}
		return pacLis.toString();
	}

	
	
	
	
}
