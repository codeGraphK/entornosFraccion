package com.entornosFraccion.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;

import com.entornosFraccion.model.Fraccion;

public class ManejoRegistro {

    private Fraccion frActual;
    private File fileFracciones = new File("RegistroFracciones.txt");
    private HashMap<Integer, Fraccion> hashFraccion = new HashMap<Integer, Fraccion>();

    private boolean fileRegToHash(HashMap<Integer, Fraccion> hashIn) throws IOException, ClassNotFoundException {
        FileInputStream flujoEntrada = new FileInputStream(this.fileFracciones);
        ObjectInputStream filtroEntrada = new ObjectInputStream(flujoEntrada);

        try {
            hashIn.clear();
            int index = 0;
            while (true) {
                hashIn.put(++index, (Fraccion) filtroEntrada.readObject());
            }
        } catch (EOFException e) {
            filtroEntrada.close();
            flujoEntrada.close();
        }

        return hashIn.size() == 0;

    }

    private void setToFileReg(HashMap<Integer, Fraccion> hashIn) throws IOException {
        FileOutputStream flujoSalida = new FileOutputStream(this.fileFracciones);
        ObjectOutputStream filtroSalida = new ObjectOutputStream(flujoSalida);

        Iterator<Fraccion> it = hashIn.values().iterator();

        while (it.hasNext())
            filtroSalida.writeObject(it.next());

        filtroSalida.close();
        flujoSalida.close();
    }

    public void addToFile(Fraccion frIn) throws IOException, AlreadyExistsException, ClassNotFoundException {
        if (fileFracciones.exists())
            fileRegToHash(hashFraccion);
        if (hashFraccion.containsValue(frIn))
            throw new AlreadyExistsException();
        else
            hashFraccion.put(hashFraccion.size() + 1, frIn);
        setToFileReg(hashFraccion);
    }

    public ArrayList<Fraccion> buscarRegistroFracc(int num, int opt) throws Exception {
        ArrayList<Fraccion> aListResult = new ArrayList<Fraccion>();
        if (fileFracciones.exists()) {
            if (!fileRegToHash(hashFraccion)) {
                Iterator<Fraccion> it = hashFraccion.values().iterator();

                while (it.hasNext()) {
                    Fraccion fr = it.next();
                    if (opt == 0 && fr.getNum() == num)
                        aListResult.add(fr);
                    else if (opt == 1 && fr.getDen() == num)
                        aListResult.add(fr);
                }
            } else {
                throw new Exception("No se encuentra.");
            }
        }
        return aListResult;
    }

    public ArrayList<Fraccion> listRegistroFracc() throws RegistroVacioException, ClassNotFoundException, IOException {
        ArrayList<Fraccion> aListResult = new ArrayList<Fraccion>();
        if (fileFracciones.exists()) {
            if (!fileRegToHash(hashFraccion)) {
                Iterator<Fraccion> it = hashFraccion.values().iterator();

                while (it.hasNext())
                    aListResult.add(it.next());
            } else {
                throw new RegistroVacioException();
            }
        }
        return aListResult;
    }

    public boolean deleteFraccion(Fraccion frIn) throws RegistroVacioException, ClassNotFoundException, IOException {
        boolean bResult = false;
        if (fileFracciones.exists()) {
            if (!fileRegToHash(hashFraccion)) {
                Iterator<Integer> it = hashFraccion.keySet().iterator();

                while (it.hasNext()) {
                    int indice = it.next();
                    if (hashFraccion.get(indice).equals(frIn))
                        hashFraccion.remove(indice);
                }

                setToFileReg(hashFraccion);
            } else {
                throw new RegistroVacioException();
            }
        }
        return bResult;
    }

    public Fraccion getFrActual() {
        return frActual;
    }

    public void setFrActual(Fraccion frActual) {
        this.frActual = frActual;
    }

}