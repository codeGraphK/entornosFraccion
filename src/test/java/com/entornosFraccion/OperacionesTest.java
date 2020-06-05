package com.entornosFraccion;

import static org.junit.jupiter.api.Assertions.*;

import com.entornosFraccion.controller.Operaciones;
import com.entornosFraccion.model.Fraccion;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperacionesTest {

    @BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName(value = "Potencia")
	@ParameterizedTest
	@CsvSource(value = { "1,1,1", "2,2,4", "2,10,1024", "5,11,48828125" })
	public void potenciaTest(int base, int exponente, int resultadoEsperado) {
		assertEquals(resultadoEsperado, Operaciones.potencia(base, exponente));
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 5, 19, 79, 199 })
	void esPrimoTest(int numero) {
		assertTrue(Operaciones.esPrimo(numero));
	}

	@ParameterizedTest
	@ValueSource(ints = { 4, 8, 100, 49, 25, 777555222, 1991, 1115 })
	void esNoPrimoTest(int numero) {
		assertFalse(Operaciones.esPrimo(numero));
	}

	@DisplayName(value = "Máximo común divisor")
	@ParameterizedTest
	@CsvSource(value = {"24,12,12", "6,4,2", "35,15,5"})
	void mcdTest(int num, int den, int result) {
		Fraccion frToTest = new Fraccion(num, den);
		assertEquals(result, Operaciones.maxComDivisor(frToTest));
	}
	
	@DisplayName(value = "Mínimo común múltiplo")
	@ParameterizedTest
	@CsvSource(value = {"72,50,1800", "6,33,66"})
	void mcmTest(int num, int den, int result) {
		Fraccion frToTest = new Fraccion(num, den);
		assertEquals(result, Operaciones.minComMultiplo(frToTest));
	}

	@DisplayName(value = "Resta")
	@ParameterizedTest
	@CsvSource(value = { "8,4,48,32", "6,3,27,18", "10,5,75,50"})
	public void restaTest(int iUno, int iDos, int numResult, int denResult) {
		assertEquals(numResult, Operaciones.resta(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getNum());
		assertEquals(denResult, Operaciones.resta(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getDen());
	}
	
	@DisplayName(value = "División")
	@ParameterizedTest
	@CsvSource(value = { "8,4,64,16", "6,3,36,9", "10,5,100,25"})
	public void divisionTest(int iUno, int iDos, int numResult, int denResult) {
		assertEquals(numResult, Operaciones.division(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getNum());
		assertEquals(denResult, Operaciones.division(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getDen());
	}
	
	@DisplayName(value = "Suma")
	@ParameterizedTest
	@CsvSource(value = { "8,4,80,32", "6,3,45,18", "10,5,125,50"})
	public void sumaTest(int iUno, int iDos, int numResult, int denResult) {
		assertEquals(numResult, Operaciones.suma(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getNum());
		assertEquals(denResult, Operaciones.suma(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getDen());
	}
	
	@DisplayName(value = "Multiplicación")
	@ParameterizedTest
	@CsvSource(value = { "8,4,32,32", "6,3,18,18", "10,5,50,50"})
	public void multiplicaciónTest(int iUno, int iDos, int numResult, int denResult) {
		assertEquals(numResult, Operaciones.multiplicacion(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getNum());
		assertEquals(denResult, Operaciones.multiplicacion(new Fraccion(iUno, iDos), new Fraccion(iDos,iUno)).getDen());
	}
    
}