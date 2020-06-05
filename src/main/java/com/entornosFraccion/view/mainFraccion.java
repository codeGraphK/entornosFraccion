package com.entornosFraccion.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.entornosFraccion.controller.ManejoRegistro;
import com.entornosFraccion.controller.Operaciones;
import com.entornosFraccion.model.Fraccion;

public class mainFraccion {

    BufferedReader rdData = new BufferedReader(new InputStreamReader(System.in));
    ManejoRegistro mRegistro;
    ArrayList<Fraccion> frToUse = null;

    public static void main(String[] args) {
        mainFraccion mrFraccion = new mainFraccion();
        try {
            mrFraccion.menu();
        } catch (NumberFormatException e) {
            System.out.println("\tIngresa un dato válido.");
            try {
                mrFraccion.menu();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public mainFraccion() {
        mRegistro = new ManejoRegistro();
    }

    private void menu() throws Exception {
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
        System.out.println("\t║                           ╔═══════════════════════════╣");
        System.out.println("\t║  13. Salir.               ║  Fracción Actual:  "
                + ((mRegistro.getFrActual() == null) ? "nullie" : mRegistro.getFrActual().toString()) + " ║");
        System.out.println("\t╚═══════════════════════════╩═══════════════════════════╝");
        int iOption = ingresar("M E N U", 0, false);
        switch (iOption) {
            case 1:
                mRegistro.addToFile(numDenMenu("C R E A R"));
                menu();
                break;
            case 2:
                buscarMenu(true);
                menu();
                break;
            case 3:
                mRegistro.deleteFraccion(numDenMenu("E L I M I"));
                menu();
                break;
            case 4:
                optionLista();
                menu();
                break;
            case 5:
                operacionesLayout("+", "S U M A");
                menu();
                break;
            case 6:
                operacionesLayout("-", "R E S T");
                menu();
                break;
            case 7:
                operacionesLayout("x", "M U L T");
                menu();
                break;
            case 8:
                operacionesLayout("/", "D I V I");
                menu();
                break;
            case 9:
                simplificar();
                menu();
                break;
            case 10:
                mcd();
                menu();
                break;
            case 11:
                mcm();
                menu();
                break;
            case 12:
                descompMenu();
                menu();
                break;
            default:
                break;
        }
    }

    private int ingresar(String s, int opt, boolean tab) throws IOException {
        int iResult;
        System.out.print("\t" + (tab ? "\t" : "") + "╔═══════════╦═══════════════════════════╗");
        if (opt == 0)
            System.out.print("\n\t" + (tab ? "\t" : "") + "║  " + s + "  ║  Ingresa la opción:  ");
        else if (opt == 1)
            System.out.print("\n\t" + (tab ? "\t" : "") + "║  " + s + "  ║  Ingresa el dato:  ");
        iResult = Integer.parseInt(rdData.readLine());
        System.out.println("\t" + (tab ? "\t" : "") + "╚═══════════╩═══════════════════════════╝");
        return iResult;
    }

    private Fraccion numDenMenu(String s) throws Exception {
        System.out.println("\t\t╔═════════════╦════════════════════╗");
        System.out.print("\t\t║  " + s + "  ║    Numerador: ");
        int num = Integer.parseInt(rdData.readLine());
        System.out.print("\t\t╠═════════════╝    Denominador: ");
        int den = Integer.parseInt(rdData.readLine());
        System.out.println("\t\t╚══════════════════════════════════╝");
        Fraccion fr = new Fraccion(num, den);
        return fr;
    }

    private void buscarMenu(boolean keep) throws Exception {
        System.out.println("\t\t╔═══════════════╦═══════════════════════╗");
        System.out.println("\t\t║  B U S C A R  ║    1. Por numerador   ║");
        System.out.println("\t\t╠═══════════════╝    2. Por denominador ║");
        int opt = ingresar("B U S C", 0, true);
        if (opt == 1)
            frToUse = mRegistro.buscarRegistroFracc(ingresar("N U M D", 1, true), 0);
        else if (opt == 2)
            frToUse = mRegistro.buscarRegistroFracc(ingresar("D E N D", 1, true), 1);
        hacerLista();
        if (frToUse.size() > 0) {
            int iFr = ingresar("S E L E", 0, true);
            if (iFr < frToUse.size())
                mRegistro.setFrActual(frToUse.get(iFr));
        }
        if (keep)
            menu();
    }

    private void hacerLista() {
        System.out.println("\t\t╔════════════════════════╗");
        if (frToUse.size() > 0) {
            for (int i = 0; i < frToUse.size(); i++)
                System.out.println("\t\t║        " + i + ". " + frToUse.get(i) + "       ║");
        } else {
            System.out.println("\t\t║  No se encuentra nada. ║");
        }
        System.out.println("\t\t╚════════════════════════╝");
    }

    private void optionLista() throws Exception {
        frToUse = mRegistro.listRegistroFracc();
        hacerLista();
    }

    private void operacionesLayout(String signo, String header) throws Exception {
        if (isSelected()) {
            Fraccion primera = mRegistro.getFrActual(), segunda = null;
            System.out.println("\t\t╔════════════════════════════════════╗");
            System.out.println("\t\t║   Para obtener la segunda fracción,  ║");
            System.out.println("\t\t║   quieres:                           ║");
            System.out.println("\t\t║     1. Seleccionar existente         ║");
            System.out.println("\t\t║     2. Crear nueva fracción          ║");
            System.out.println("\t\t╚════════════════════════════════════╝");
            int opt = ingresar("S U M A", 0, true);
            if (opt == 1) {
                buscarMenu(false);
                segunda = mRegistro.getFrActual();
            } else if (opt == 2) {
                segunda = numDenMenu("C R E A R");
            }
            System.out.println("\t\t╔═══════════╦═════════════════════════╗");
            System.out.println("\t\t║  " + header + "  ║    " + primera.toString() + "  " + signo + "  "
                    + segunda.toString() + "    ║");
            System.out.println("\t\t╠═══════════╩═════════════════════════╣");
            System.out.println("\t\t║  Introduce el num. de tu resultado: ║");
            int num = ingresar("N U M D", 1, true);
            System.out.println("\t\t║  Introduce el den. de tu resultado: ║");
            int den = ingresar("D E N D", 1, true);
            String sResult = "Incorrecto.";

            if (signo.equals("+")) {
                if (Operaciones.suma(primera, segunda).equals(new Fraccion(num, den)))
                    sResult = "Correcto :D";
            } else if (signo.equals("-")) {
                if (Operaciones.resta(primera, segunda).equals(new Fraccion(num, den)))
                    sResult = "Correcto :D";

            } else if (signo.equals("x")) {
                if (Operaciones.multiplicacion(primera, segunda).equals(new Fraccion(num, den)))
                    sResult = "Correcto :D";

            } else if (signo.equals("/")) {
                if (Operaciones.division(primera, segunda).equals(new Fraccion(num, den)))
                    sResult = "Correcto :D";
            }
            System.out.println("\t\t╔═══════════╦═════════════════════════╗");
            System.out.println("\t\t║  " + header + "  ║       " + sResult + "       ║");
            System.out.println("\t\t╚═══════════╩═════════════════════════╝");
        }
    }

    private boolean isSelected() throws Exception {
        boolean bResult = mRegistro.getFrActual() != null;
        if (!bResult) {
            System.out.println("\t\t╔════════════════════════════════════╗");
            System.out.println("\t\t║  Seleccione primero una fracción   ║");
            System.out.println("\t\t║  con la opción de Buscar.          ║");
            System.out.println("\t\t╚════════════════════════════════════╝");
            buscarMenu(true);
        }
        return bResult;
    }

    private void simplificar() throws Exception {
        if (isSelected()) {
            Fraccion fr = new Fraccion(mRegistro.getFrActual().getNum(), mRegistro.getFrActual().getDen());
            int mcd = Operaciones.maxComDivisor(mRegistro.getFrActual());
            fr.setNum(fr.getNum() / mcd);
            fr.setDen(fr.getDen() / mcd);
            System.out.println("\t\t╔═══════════╦═══════════════════════════╗");
            System.out.println("\t\t║  S I M P  ║     " + mRegistro.getFrActual().toString() + "  =  " + fr.toString()
                    + "      ║");
            System.out.println("\t\t╠═══════════╩═══════════════════════════╣");
            System.out.println("\t\t║   ¿Desea sustituir la fracción por    ║");
            System.out.println("\t\t║   la simplificada?   1. Si   2. No    ║");
            int opt = ingresar("S I M P", 0, true);
            if (opt == 1)
                mRegistro.addToFile(fr);
        }
    }

    private void mcd() throws Exception {
        if (isSelected()) {
            System.out.println("\t\t╔═══════════╦═══════════════════════════╗");
            System.out.println("\t\t║  M C Div  ║     " + mRegistro.getFrActual().toString() + "  =  "
                    + Operaciones.maxComDivisor(mRegistro.getFrActual()));
            System.out.println("\t\t╚═══════════╩═══════════════════════════╝");
        }
    }

    private void mcm() throws Exception {
        if (isSelected()) {
            System.out.println("\t\t╔═══════════╦═══════════════════════════╗");
            System.out.println("\t\t║  M C Múl  ║     " + mRegistro.getFrActual().toString() + "  =  "
                    + Operaciones.minComMultiplo(mRegistro.getFrActual()));
            System.out.println("\t\t╚═══════════╩═══════════════════════════╝");
        }
    }

    private void descompMenu() throws Exception {
        if (isSelected()) {
            Fraccion fr = mRegistro.getFrActual();
            System.out.println("\t\t╔══════════════════╦════════════════════╗");
            System.out.println(
                    "\t\t║  Descomposición  ║  " + fr.getNum() + " = " + Operaciones.divisores(fr.getNum()).toString());
            System.out.println(
                    "\t\t╠══════════════════╣  " + fr.getDen() + " = " + Operaciones.divisores(fr.getDen()).toString());
            System.out.println("\t\t╚══════════════════╩════════════════════╝");
        }
    }

}