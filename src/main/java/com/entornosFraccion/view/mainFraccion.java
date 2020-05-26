package com.entornosFraccion.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.entornosFraccion.controller.Operaciones;
import com.entornosFraccion.model.Fraccion;

public class mainFraccion {

    BufferedReader rdData = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.println("\t╔═══════════════════════════════════════════════════════╗");
        System.out.println("\t║              F  R  A  C  C  I  O  N  E  S             ║");
        System.out.println("\t╠═══════════════════════════╦═══════════════════════════╣");
        System.out.println("\t║  1. Crear fracción.       ║   5. Suma.                ║");
        System.out.println("\t║  2. Buscar fracción.      ║   6. Resta.               ║");
        System.out.println("\t║  3. Eliminar fracción.    ║   7. Multiplicación.      ║");
        System.out.println("\t║  4. Listar fracciones.    ║   8. División.            ║");
        System.out.println("\t╠═══════════════════════════╩═══════════════════════════╣");
        System.out.println("\t║  9. Simplificar fracción.                             ║");
        System.out.println("\t║  10. Máximo Común Divisor.                            ║");
        System.out.println("\t║  11. Mínimo Común Múltiplo.                           ║");
        System.out.println("\t║  12. Descomposición en primos.                        ║");
        System.out.println("\t║                                                       ║");
        System.out.println("\t║  13. Salir.                                           ║");
        System.out.println("\t╚═══════════════════════════════════════════════════════╝");
    }

}