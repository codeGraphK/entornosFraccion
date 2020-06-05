package com.entornosFraccion.controller;

public class RegistroVacioException extends Exception {

    private static final long serialVersionUID = 1L;

    public RegistroVacioException() {
        super("El fichero de registros está vacío.");
    }
}