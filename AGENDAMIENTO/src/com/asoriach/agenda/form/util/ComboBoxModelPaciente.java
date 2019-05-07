/**
 * 
 */
package com.asoriach.agenda.form.util;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.asoriach.agenda.modelo.Paciente;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * May 1, 2019 - 5:29:57 PM
 */
public class ComboBoxModelPaciente implements ComboBoxModel<Paciente> {

	private List<Paciente> pacientes;
	private int indice; 
	
	public ComboBoxModelPaciente(List<Paciente> pacientes) {
		this.pacientes = pacientes;  
	}
	
	@Override
	public int getSize() {
		return pacientes.size();
	}

	@Override
	public Paciente getElementAt(int index) {
	indice = index;
	return pacientes.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		
	}

	@Override
	public void setSelectedItem(Object anItem) {
	if(pacientes.contains(anItem)){
		indice = pacientes.indexOf(anItem);
	}
	
	}

	@Override
	public Object getSelectedItem() {
		return pacientes.get(indice);

	}

	
	
	
	
}
