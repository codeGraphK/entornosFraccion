package com.entornosFraccion.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import com.entornosFraccion.model.Fraccion;

public class Operaciones {

	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	public static SortedMap<Integer, Integer> divisores(int numero) {
		SortedMap<Integer, Integer> divisores = new TreeMap<Integer, Integer>();

		int numeroIntermedio = numero;
		Integer divisor = 2;

		while (numeroIntermedio >= divisor) {
			while (numeroIntermedio % divisor == 0) {
				Integer clave = divisor;
				divisores.putIfAbsent(divisor, 0);
				divisores.computeIfPresent(clave, (key, val) -> (val + 1));
				numeroIntermedio = numeroIntermedio / divisor;
			}
			divisor++;
		}

		return divisores;
	}

	public static ArrayList<Integer> listaDePrimosHasta(int numero) {
		ArrayList<Integer> listaDePrimos = new ArrayList<Integer>();

		listaDePrimos.add(1);
		listaDePrimos.add(2);
		listaDePrimos.add(3);

		for (int i = 5; i <= numero; i += 2) {
			if (esPrimo(i))
				listaDePrimos.add(i);
		}

		return listaDePrimos;
	}

	public static int potencia(int base, int exponente) {
		int iResult = 1;

		if (exponente > 0)
			iResult = base * potencia(base, exponente - 1);

		return iResult;
	}

	public static boolean esPrimo(int numero) {
		boolean bPrimo = true;
		int divisor = 3;

		if (numero != 2 && numero % 2 == 0)
			bPrimo = false;

		while (bPrimo && divisor <= Math.sqrt(numero)) {
			if (numero % divisor == 0)
				bPrimo = false;
			divisor += 2;
		}
		return bPrimo;
	}
	
	public static Fraccion suma(Fraccion frUno, Fraccion frDos) {
		Fraccion frResult = null;

		int resultDen = frUno.getDen() * frDos.getDen();
		int resultNum = (frUno.getNum() * frDos.getDen()) + (frUno.getDen() * frDos.getNum());
		
		frResult = new Fraccion(resultNum, resultDen);

		return frResult;
	}

	public static Fraccion resta(Fraccion frUno, Fraccion frDos) {
		Fraccion frResult = null;

		int resultNum = (frUno.getNum() * frDos.getDen()) - (frUno.getDen() * frDos.getNum());
		int resultDen = frUno.getDen() * frDos.getDen();

		frResult = new Fraccion(resultNum, resultDen);

		return frResult;
	}
	
	public static Fraccion multiplicacion(Fraccion frUno, Fraccion frDos) {
		Fraccion frResult = null;

		int resultNum = frUno.getNum() * frDos.getNum();
		int resultDen = frUno.getDen() * frDos.getDen();
		
		frResult = new Fraccion(resultNum, resultDen);

		return frResult;
	}

	public static Fraccion division(Fraccion frUno, Fraccion frDos) {
		Fraccion frResult = null;

		int resultNum = frUno.getNum() * frDos.getDen();
		int resultDen = frUno.getDen() * frDos.getNum();

		frResult = new Fraccion(resultNum, resultDen);

		return frResult;
	}

	public static Integer maxComDivisor(Fraccion frIn) {
		SortedMap<Integer, Integer> mapNum = divisores(frIn.getNum());
		SortedMap<Integer, Integer> mapDen = divisores(frIn.getDen());
		Iterator<Integer> itKeys = null;
		int iResult = 1;

		if (mapNum.size() < mapDen.size())
			itKeys = mapNum.keySet().iterator();
		else
			itKeys = mapDen.keySet().iterator();

		while (itKeys.hasNext()) {
			int iNow = itKeys.next();
			if (mapDen.containsKey(iNow) && mapNum.containsKey(iNow)) {
				int numValue = mapNum.get(iNow);
				int denValue = mapDen.get(iNow);

				if (numValue < denValue)
					iResult *= Math.pow(iNow, numValue);
				else
					iResult *= Math.pow(iNow, denValue);
			}
		}

		return iResult;
	}

	public static Integer minComMultiplo(Fraccion frIn) {
		return (frIn.getNum() * frIn.getDen())/maxComDivisor(frIn);
	}

	public static Fraccion simplificacion(Fraccion frIn) {
		int mcd = maxComDivisor(frIn);
		return new Fraccion(frIn.getNum()/mcd, frIn.getDen()/mcd);
	}

}