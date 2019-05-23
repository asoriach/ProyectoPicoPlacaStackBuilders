package com.pico.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.sound.midi.Synthesizer;

/**
 * Clase que representa la implementacion del sistema Pico y Placa. Modelo del Backend o Logica
 * 
 * @author angelsoriachicaiza
 *
 */
public class ImplementacionTrs {

	
/*	public char obtenerPlaca(String placa) {

		char digito = placa.charAt(placa.length() - 1);
		
		return digito;
	}
*/
	public String obtenerPlaca(String placa) {

	char digito = placa.charAt(placa.length() - 1);
	String numero = String.valueOf(digito);
	return numero;
}
	
	
	
	
	/*
	public boolean validarDia(char digito, String fecha) throws Exception {
		
		int diaSemana = 0;
		Date dia = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy"); 
		
		try {
			dia = formato.parse(fecha);	
		} catch (ParseException e) {
			throw new Exception("No se puede convertir la cadena a fecha por favor ingrese de la siguiente forma dd/MM/yyy");
		}
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dia);
		diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		
		boolean flag = false;
		if (diaSemana == 2) { // Para cuando la placa esta en pico y placa el lunes
			if (digito == 49 || digito == 50) { // ASCII for digitos 0 - 9 equivalente 48 - 57 
				flag = true;
			} else {
				flag = false;
			}
		} else if (diaSemana == 3) { // Para cuando la placa esta en pico y placa el martes 
		if (digito == 51 || digito == 52) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 4) { // Para cuando la placa esta en pico y placa el miercoles 
		if (digito == 53 || digito == 54) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 5) { // Para cuando la placa esta en pico y placa el jueves
		if (digito == 55 || digito == 56) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 6) { // Para cuando la placa esta en pico y placa el Viernes
		if (digito == 57 || digito == 48) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 1 || diaSemana == 7 ) { // Para cuando la placa esta en pico y placa fin de semana 
				flag = false;
				}
		
		return flag;
	}
	*/

public boolean validarDia(String digito, String fecha) throws Exception {
		
		int diaSemana = 0;
		Date dia = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy"); 
		
		try {
			dia = formato.parse(fecha);	
		} catch (ParseException e) {
			throw new Exception("No se puede convertir la cadena a fecha por favor ingrese de la siguiente forma dd/MM/yyy");
		}
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dia);
		diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		
		boolean flag = false;
		
		if (diaSemana == 2) { // Para cuando la placa esta en pico y placa el lunes
			if (digito.equals("1") || digito.equals("2")) { // ASCII for digitos 0 - 9 equivalente 48 - 57 
				flag = true;
			} else {
				flag = false;
			}
		} else if (diaSemana == 3) { // Para cuando la placa esta en pico y placa el martes 
		if (digito.equals("3") || digito.equals("4") ) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 4) { // Para cuando la placa esta en pico y placa el miercoles 
		if (digito.equals("5") || digito.equals("6")) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 5) { // Para cuando la placa esta en pico y placa el jueves
		if (digito.equals("7") || digito.equals("8")) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 6) { // Para cuando la placa esta en pico y placa el Viernes
		if (digito.equals("9") || digito.equals("0")) {
				flag = true;
			}else{
				flag = false;
			}
		}else if (diaSemana == 1 || diaSemana == 7 ) { // Para cuando la placa esta en pico y placa fin de semana 
				flag = false;
				}
		
		return flag;
	}


	
	public boolean validarHora(String horario) throws Exception{
		
		Date horaVer = null;
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm"); 
		try {
			horaVer = formato.parse(horario);	
		} catch (ParseException e) {
			throw new Exception("No se puede convertir la cadena a tiempo por favor ingrese de la siguiente forma HH:MM");
		}
		
		boolean flag = false;
		String[] time = horario.split(":");
		String hora = time[0];
		String minuto = time[1];
		String horaComp = hora + minuto;
		
		int hc = Integer.parseInt(horaComp) ;
		
		if( hc >= 700 && hc <= 930 || hc >=1600 && hc <= 1930 ){
			flag = true;
		}
		else{
			flag = false; 
		}
				
		return flag;
	}
	
	public String validarPicoPlaca (boolean dia, boolean hora){
		String mensaje = null;
	if( dia == true && hora == true){
		mensaje = "La placa de su auto tiene restringido la circulacion ";
	}else{
		mensaje = "La placa de su auto puede circular" ;
	}
		return mensaje; 
	}

}

