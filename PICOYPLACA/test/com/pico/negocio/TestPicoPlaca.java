/**
 * 
 */
package com.pico.negocio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author angelsoriachicaiza
 *
 */
public class TestPicoPlaca {

	private ImplementacionTrs admTest;

	@Before
	public void setUp() throws Exception {

		admTest = new ImplementacionTrs();
		String digito = "0";
		String placa = "PBX1040";
		// String placaNo = "PBX";
	}

	/**
	 * Test method for
	 * {@link com.pico.negocio.ImplementacionTrs#obtenerPlaca(java.lang.String)}.
	 */
	@Test
	public void testAll(){
		String digito = "1";
		String placa = "PBX1241";
		String fecha = "20/05/2019";
		String hora = "7:00"; 
		boolean test = true; 
		String mensaje = "La placa de su auto tiene restringido la circulacion ";
		
		try{
		testObtenerPlaca(digito, placa);
		testValidarDia(test, digito, fecha);
		testValidarHora(test, hora);
		testValidarPicoPlaca(mensaje, test, test);
		}catch (Exception e){
			System.out.println("Hay errores en alguna funcion ");
		}
	}

	// @Test
	public void testObtenerPlaca(String digito, String placa) {

		// String digito = "0";

		// String placaOk = "PBX1040";
		// String placaNo = "PBX";
		try {
			Assert.assertEquals(digito, admTest.obtenerPlaca(placa));
			// Assert.assertEquals(digito, admTest.obtenerPlaca(placaNo) );

		} catch (Exception e) {
			System.out.println("La placa no esta bien");
		}

	}

	/**
	 * Test method for
	 * {@link com.pico.negocio.ImplementacionTrs#validarDia(char, java.lang.String)}.
	 */
	// @Test
	public void testValidarDia(boolean expVal, String digito, String fecha) {

		try {
			Assert.assertEquals(expVal, admTest.validarDia(digito, fecha));
		} catch (Exception e) {

			System.out.println("Fx de dia no funciona");
		}

	}

	/**
	 * Test method for
	 * {@link com.pico.negocio.ImplementacionTrs#validarHora(java.lang.String)}.
	 */
	// @Test
	public void testValidarHora(boolean expVal, String hora) {

		try {
			Assert.assertEquals(expVal, admTest.validarHora(hora));
		} catch (Exception e) {

			System.out.println("Fx de hora no funciona");
		}

	}

	/**
	 * Test method for
	 * {@link com.pico.negocio.ImplementacionTrs#validarPicoPlaca(boolean, boolean)}.
	 */
	// @Test
	public void testValidarPicoPlaca(String mensaje, boolean dia, boolean hora) {

		try {
			Assert.assertEquals(mensaje, admTest.validarPicoPlaca(dia, hora));
		} catch (Exception e) {

			System.out.println(" Si puede circular");
		}

	}

}
