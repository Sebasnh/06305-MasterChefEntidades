/*
 * Copyright 2020 Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es
 */
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int DEF_MIEMBROS = 3;

    public static final double DEF_PRESUPUESTO = 21;
    
    public static final int MIN_COCINEROS = 2;
    public static final int MAX_COCINEROS = 4;
    
    public static final double MIN_PRE = 5;
    public static final double MAX_PRE = 30;
            

    private int miembros;
    private double presupuesto;

    public Equipo() {
        miembros = DEF_MIEMBROS;
        presupuesto = DEF_PRESUPUESTO;
    }

    public Equipo(int miembros, double presupuesto) {
        if (validarMiembros(miembros)) {
            this.miembros = miembros;
        } else {
            this.miembros = DEF_MIEMBROS;
        }

        if (validarPresupuesto(presupuesto)) {
            this.presupuesto = presupuesto;
        } else {
            this.presupuesto = DEF_PRESUPUESTO;
        }
    }

    public int getMiembros() {
        return miembros;
    }

    public void setMiembros(int miembros) {
         if (validarMiembros(miembros)) {
            this.miembros = miembros;
        }
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        if (validarPresupuesto(presupuesto)) {
            this.presupuesto = presupuesto;
        }
    }

    @Override
    public final boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Equipo)) {
            testOK = false;
        } else {
            testOK = miembros == ((Equipo) o).getMiembros()
                    && presupuesto == ((Equipo) o).getPresupuesto();
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.miembros;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.presupuesto)
                ^ (Double.doubleToLongBits(this.presupuesto) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
       return String.format(Locale.ENGLISH,"%s - Número de personas del equipo:"
                + " %d - Presupuesto: %.2f€", getClass().getSimpleName(),
                 miembros, presupuesto);
    }

    private boolean validarMiembros(int miembros){
        return miembros >= MIN_COCINEROS && miembros <= MAX_COCINEROS;
    }
    
    private boolean validarPresupuesto(double presupuesto){
        return presupuesto >= MIN_PRE && presupuesto <= MAX_PRE;
    }
    
}
