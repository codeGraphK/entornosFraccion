package com.entornosFraccion.model;

public class Fraccion {

    private int iNumerador;
	private int iDenominador;

	public Fraccion(int numerador, int denominador) {
		this.iNumerador = numerador;
		this.iDenominador = denominador;
	}

	public int getNum() {
		return this.iNumerador;
	}

	public int getDen() {
		return this.iDenominador;
	}

	public void setNum(int numerador) {
		this.iNumerador = numerador;
	}

	public void setDen(int denominador) {
		this.iDenominador = denominador;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.iNumerador).append(" / ").append(this.iDenominador);
		return sb.toString();
    }
    
}