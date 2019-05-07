/**
 * 
 */
package com.asoriach.agenda.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa la base de datos en memoria 
 * @author angelsoriachicaiza
 *
 * Mar 5, 2019 - 6:47:44 PM
 */
public class MemoriaBdd {

	/*
	 * Objetos de la Base de Datos 
	 * Pacientes 
	 * Usuarios
	 * Doctores 
	 * Centros de Atencion
	 * Citas 
	 * Tipo Citas
	 */
	public static Paciente[] pacientes; 
	public static Usuario[] usuarios;
//	private static TipoCita[] tipoCitas; 
	public static TipoCita[] tipoCitas;
	public static ArrayList<Doctor> doctores;
	public static ArrayList<Cita> citas;
		
	static {
		
		// Declaracion de los arrays para obj 	
		usuarios = new Usuario[5];
		pacientes = new Paciente[5];
		tipoCitas = new TipoCita[5];
		doctores = new ArrayList<Doctor>(); 
		citas = new ArrayList<Cita>();
		inicializarUsuarios(); 	
	}
	
	private static void inicializarUsuarios(){
		usuarios[0] = new Usuario("pescobar","0001",new Date(), null); 
		usuarios[1] = new Usuario("mzambrano","0002",new Date(), null);
		usuarios[2] = new Usuario("mchicaiza","0003",new Date(), null); 
		usuarios[3] = new Usuario("pcuji","0004",new Date(), null); 
		usuarios[4] = new Usuario("pchango","0005",new Date(), null); 
		
	}
	
//	private static void inicializarPacientes(){
//		pacientes[0] = new Paciente("Pablo","Escobar","1718161616","01/01/1980/","Lucha de los pobres","2500400","pescobar@gmail.com","M","Humana"); 
//		pacientes[1] = new Paciente("Mercedes","Zambrano","1718161515","03/03/1990/","Cumbaya","2400300","mzambrano@gmail.com","F","Hispana"); 
//		pacientes[2] = new Paciente("Maria","Chicaiza","1718161616","06/06/1970/","Granados","2200100","mchicaiza@gmail.com","F","Ninguno");
//	}	
//	
	
//	public static void imprimirInfoBdd(){
//	System.out.println("MemoriaBdd V 1.0 - Angel Soria - SYSMED");		
//	}
	
	
	
//	
//	
//	public static void main(String[] args){
//		
//		MemoriaBdd bddDes = new MemoriaBdd();
//		bddDes.imprimirInfoBdd();
//		
//		MemoriaBdd.imprimirInfoBdd();
//		MemoriaBdd bddTes = new MemoriaBdd(); 
//		
//		
//		
//		
//	}
	
	
	
}
