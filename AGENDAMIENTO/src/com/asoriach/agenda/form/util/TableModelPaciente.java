/**
 * 
 */
package com.asoriach.agenda.form.util;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.asoriach.agenda.modelo.Paciente;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 30, 2019 - 4:53:00 PM
 */
public class TableModelPaciente implements TableModel {

	private List<String> columnas;
	private List<Paciente> filas;

	public TableModelPaciente(List<String> columnas, List<Paciente> filas) {
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

		Paciente pac = filas.get(rowIndex);
		
		  if(columnIndex == 0){ return pac.getIdPer(); }else if(columnIndex ==1){ return pac.getNombrePer(); }
		  
		  else if(columnIndex == 2){ return pac.getApellidoPer(); }else if(columnIndex == 3){ return pac.getIdentificacionPer(); }
		  else if(columnIndex == 4){ return pac.getFechaNacPer(); }else if(columnIndex == 5){ return pac.getDireccionPer();}
		  else if(columnIndex == 6){ return pac.getCorreoPer(); }else if(columnIndex == 7){ return pac.getGeneroPer();}		
		  else { return pac.getSeguroPer(); }
		  /*
		switch (columnIndex) {
		case 0:
			pac.getIdPer();
			break;
		case 1:
			pac.getNombrePer();
			break;
		case 2:
			pac.getApellidoPer();
			break;
		case 3:
			pac.getIdentificacionPer();
			break;
		case 4:
			pac.getFechaNacPer();
			break;
		case 5:
			pac.getDireccionPer();
			break;
		case 6:
			pac.getCorreoPer();
			break;
		case 7:
			pac.getGeneroPer();
			break;
		case 8:
			pac.getSeguroPer();
			break;
		default:
			break;
		}
		return pac;
		*/
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		filas.set(rowIndex, (Paciente) aValue);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public Paciente obtenerFilaSeleccionada(int indSel){
		return filas.get(indSel);
	}
	
}
