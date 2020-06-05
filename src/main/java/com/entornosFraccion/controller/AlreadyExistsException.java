package com.entornosFraccion.controller;

public class AlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public AlreadyExistsException() {
        super("La fracción ya existe.");
    }
}