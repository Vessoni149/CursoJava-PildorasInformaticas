package JDBC.AplicacionConsulta.principal;

import JDBC.AplicacionConsulta.vista.MarcoAplicacion2;

import javax.swing.*;
// MVC:
//patron de arquitectura que separa la logica del programa (datos), la UI, y las comunicaciones (eventos comunicacion con servidor)
//Una aplicacion bajo este paradigma se estructura de la sgt manera:
//En la parte Modelo programaremos todo lo relacionado on los datos y su encapsulacion
//Vista: la UI
//controlador: La interaccion entre la vista y el modelo, entre la ui y los eventos que conectan con la db.
//Flujo:
//la vista y el controlador estan muy relacionados e si. No tanto el modelo. El Usuario usa la app mediante eventos.
//una vez q el usuario a travez de la ui realiza un evento que esta en el controlador, ese evento hace una consulta o mannipulacion de la db (modelo). Ell modelo recibe la consulta, la provesa y la devuelve a la vista para que el usuario la pueda ver.

public class EjecutaMVC {
    public static void main(String[] args) {
        MarcoAplicacion2 miMarco2 = new MarcoAplicacion2();
        miMarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco2.setVisible(true);
    }
}
