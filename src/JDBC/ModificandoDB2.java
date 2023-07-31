package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificandoDB2 {
    public static void main(String[] args) {
        try{
            //Paso1, crear conexion:
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaJava","root", "");
            //Paso 2 crear objeto statement:
            Statement miStatement = miConexion.createStatement();

            //En este caso no necesitaremos el Resulset, la tabla virtual, ya que no necesitamos ver nada sino modificar la DB.

            //Insertando valores a la tabla:
            //Primero almacenamos la instruccion sql en una variable string. En este caso es un insert pero tmb puede ser un update o un delete, ya que todas pueden ir como parametro en el metodo que usaremos (excecuteUpdate).
            String instruccionSql = "INSERT INTO usuarios (nombre, apellidos, correo, edad) VALUES ('Pedro', 'Zanchez', 'DropeZanchez@gmail.com', 34)";
            //El metodo executeUpdate permite updatear, insertar y borrar datos. Recibe por parametro la consulta sql a ejecutar.
            miStatement.executeUpdate(instruccionSql);
            System.out.println("datos incertados");
        }catch (Exception e){
            System.out.println("No conecta!");
            e.printStackTrace();
        }
    }
}
