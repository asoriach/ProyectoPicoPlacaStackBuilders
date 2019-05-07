/**
 * 
 */
package com.asoriach.agenda.form.util;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.asoriach.agenda.modelo.TipoCita;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         Apr 29, 2019 - 10:06:20 AM
 */
public class TableModelTipoCita implements TableModel {

	private List<String> columnas;
	private List<TipoCita> filas;

	/**
	 * @param columnas
	 * @param filas
	 */
	public TableModelTipoCita(List<String> columnas, List<TipoCita> filas) {
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

		TipoCita tipoCita = filas.get(rowIndex);
		if (columnIndex == 0) {
			return tipoCita.getId();
		} else if (columnIndex == 1) {
			return tipoCita.getNombreCita();
		} else {
			return tipoCita.getSucursalCita();
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		filas.set(rowIndex, (TipoCita) aValue);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
	}

	// Recuperar registro seleccionado
	public TipoCita obtenerFilaSeleccionada(int indSel) {
		return filas.get(indSel);
	}

}
