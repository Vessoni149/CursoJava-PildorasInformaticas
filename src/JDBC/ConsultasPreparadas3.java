package JDBC;

//Las consultas preparadas son una consulta que permiten pasar parametros como si fuesen funciones para reutilizarla con siderentes criterios.
//Previenen de ataques de inyeccion sql. Que tienen como objetivo manipular la consulta SQL original para obtener acceso no autorizado a la base de
// datos subyacente, extraer información sensible o realizar cambios no deseados en la base de datos.
//Ej de inyeccion sql: Supongamos que tenemos una aplicación web que tiene un formulario de inicio de sesión donde se solicita un nombre de usuario
// y una contraseña. La consulta SQL que se utiliza para verificar las credenciales del usuario podría ser algo así:
//SELECT * FROM usuarios WHERE nombre_usuario = '<nombre_de_usuario>' AND contraseña = '<contraseña>'
//si el atacante ingresara lo siguiente en el campo de nombre de usuario:
//' OR '1'='1
//La consulta SQL resultante sería:
//SELECT * FROM usuarios WHERE nombre_usuario = '' OR '1'='1' AND contraseña = '<contraseña>'
//En este caso, el atacante ha manipulado la consulta para que siempre evalúe la condición '1'='1', que siempre es verdadera. Esto significa que
// la consulta devolverá todos los registros de usuarios en lugar de verificar las credenciales del usuario legítimo. El atacante podría obtener acceso no autorizado al sistema utilizando esta técnica.

//Tienen mejor rendimiento xq se escribe la consulta 1 vez

import java.sql.*;

//Las consultas preparadas son como las normales solo que al momento de escribir el criterio de seleccion por ej en vez de escriir el campo se
// pone "?".
//Para crear consultas preparadas se necesitan ciertos metodos de la interface Connection, prepareStatement() que tiene varias sobreescirturas.
//Este metodo devuelve un objeto de tipo PreparedStatement (interfaz). Esta interfaz tiene muchos metodos como setString, setInt, setObject que
// reciben 2 argumentos un int y otro que varía el tipo segun la sobrecarga el metodo.
//Todos estos metodos set... estableen el numero de parametro y el valor del parametro.
public class ConsultasPreparadas3 {
    public static void main(String[] args) {
        try{
            //Paso1, crear conexion:
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaJava","root", "");
            //Paso 2 crear la consulta preparada. El metodo PrepareStatement de la Clase Connection devuelve un objeto de tipo preparedStatement:
            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT nombre, apellidos FROM usuarios WHERE edad = ?");
            //Paso 3: establecer parametros de consulta:
            miSentencia.setInt(1,28); //Vamos a elegir el metodo set...() segun el tipo de dato que necesitemos como parametro,
            // el primer parametro es el n° de parametro de la consulta y el segundo el valor que deberia ir en la consulta.
            //miSentencia.setInt(1, 67);        //Si sobreescribo miSentencia se va a imprimir el valor de ésta.
            //Paso 4 ejecutar y recorrer consulta:
            ResultSet rs = miSentencia.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1) + " " +  rs.getString(2));
            }
            rs.close();

            //Reutilizando consulta:


        }catch (Exception e){
            System.out.println("No conecta!");
            e.printStackTrace();
        }
    }
}
