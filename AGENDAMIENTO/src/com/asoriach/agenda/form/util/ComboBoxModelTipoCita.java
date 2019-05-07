/**
 * 
 */
package com.asoriach.agenda.form.util;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.asoriach.agenda.modelo.TipoCita;

/**
 * Clase que representa ....
 * 
 * @author angelsoriachicaiza
 *
 *         May 1, 2019 - 5:29:37 PM
 */
public class ComboBoxModelTipoCita implements ComboBoxModel<TipoCita> {

	private List<TipoCita> tipoCitas;
	private int indice;

	public ComboBoxModelTipoCita(List<TipoCita> tipoCitas) {
		this.tipoCitas = tipoCitas;
	}

	@Override
	public int getSize() {
		return tipoCitas.size();
	}

	@Override
	public TipoCita getElementAt(int index) {
		indice = index;
		return tipoCitas.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {

	}

	@Override
	public void removeListDataListener(ListDataListener l) {

	}

	@Override
	public void setSelectedItem(Object anItem) {
	if(tipoCitas.contains(anItem)){
		indice = tipoCitas.indexOf(anItem);
	}
	}

	@Override
	public Object getSelectedItem() {
		return tipoCitas.get(indice);
	}

}
