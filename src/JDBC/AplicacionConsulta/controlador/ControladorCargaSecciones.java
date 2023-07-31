package JDBC.AplicacionConsulta.controlador;

import JDBC.AplicacionConsulta.modelo.*;
import JDBC.AplicacionConsulta.vista.MarcoAplicacion2;
;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControladorCargaSecciones extends WindowAdapter {

public ControladorCargaSecciones(MarcoAplicacion2 elmarco){
    this.elmarco = elmarco;

}
    @Override
    public void windowOpened(WindowEvent e) {
        obj.ejecutaConsultas();
        try{
            while(obj.rs.next()){
                elmarco.secciones.addItem(obj.rs.getString(1));
            }
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }


    CargaSecciones obj = new CargaSecciones();
    private MarcoAplicacion2 elmarco;

}
