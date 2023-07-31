package JDBC.AplicacionConsulta.modelo;

import JDBC.AplicacionConsulta.controlador.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaSecciones {
    Conexion miConexion;
    public ResultSet rs;
    public CargaSecciones(){
         miConexion = new Conexion();
    }

    public String ejecutaConsultas(){
        Productos miProducto = null;
        Connection accesoBBDD = miConexion.dameConexion();
        try{
            Statement secciones = accesoBBDD.createStatement();
            rs = secciones.executeQuery("SELECT distinct seccion from productos");
            while(rs.next()){
                miProducto = new Productos();
                miProducto.setSeccion(rs.getString(1));
            }
            rs.close();
        }catch (Exception e){

        }
        return miProducto.getSeccion();
    }

}
