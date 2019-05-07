/**
 * 
 */
package com.asoriach.agenda.form.util;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.asoriach.agenda.modelo.Cita;

/**
 * Clase que representa ....
 * @author angelsoriachicaiza
 *
 * May 1, 2019 - 5:44:26 PM
 */
public class TableModelCita implements TableModel{

	private List<String> columnas;
	private List<Cita> filas; 
	
	public TableModelCita(List<String> columnas, List<Cita> filas) {
		this.columnas = columnas;
		this.filas = filas;
	}
	
	
	@Override
	public int getRowCount() {
		return filas.size();
	}


	@Override
	public int getColumnCount() {
	return columnas.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnas.get(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Cita cita = filas.get(rowIndex);
		if(columnIndex == 0 ){
			return cita.getIdCita();
		}else if(columnIndex == 1){
			return cita.getEspecialidadCita();
		}else if(columnIndex == 2){
			return cita.getFechaCita();
		}else if( columnIndex == 3 ){
			return cita.getTipocita();
		}else{
			return cita.getPaciente();
		}
		
		
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		filas.set(rowIndex, (Cita) aValue);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	public Cita obtenerCitaSeleccionada(int indSel){
		return filas.get(indSel);
		
	}
	
	
}
