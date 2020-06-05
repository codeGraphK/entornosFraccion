package com.entornosFraccion.model;

import java.io.Serializable;

public class Fraccion implements Serializable {

	private static final long serialVersionUID = 1L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iDenominador;
		result = prime * result + iNumerador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraccion other = (Fraccion) obj;
		if (iDenominador != other.iDenominador)
			return false;
		if (iNumerador != other.iNumerador)
			return false;
		return true;
	}

}