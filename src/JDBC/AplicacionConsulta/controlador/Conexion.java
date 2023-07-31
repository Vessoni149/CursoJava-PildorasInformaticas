package JDBC.AplicacionConsulta.controlador;

import java.sql.*;

public class Conexion {
    Connection miConexion=null;
    public Conexion(){

    }

    public Connection dameConexion(){
        try {
            //Secciones
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaJava", "root", "");
        }catch(Exception e){

        }
        return miConexion;
    }
}
