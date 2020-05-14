package com.entornosFraccion.view;

import com.entornosFraccion.controller.Operaciones;
import com.entornosFraccion.model.Fraccion;

public class mainFraccion {

    public static void main(String[] args) {
        Fraccion frUno = new Fraccion(42, 56);
        System.out.println(Operaciones.maxComDivisor(frUno));
    }

}