package JDBC;

//jdbc significa java database connectivity
//Es un driver  que conecta una ap java y un sistema gestor de bases de datos y permite manipular la ase de datos.
//El driver jdbc lo proporcona el propio fabricante del SGBD, entonces va a haber un driver jdbc para mysql, otro para oracle
//Vamos a manejar los paquetes de java java.sql y javax.sql
//Estos paquetes tienen dentro clases e interfaces para conectarnos y manipular la db: Clase DriverManager, interfaces ResulSet, Connection, Statement y DataSource.

//Proceso a seguir:
//hay que tener descargado mysql y levantado el servidor en xamp.
//Si no tenemos Maven primero hay que descargar el driver (dependencia) MySql connector java para mysql desde la pagina de MySql o para la db que vayamos a usar.
//Se descarga un archivo comprimido, al abrirlo hay varias cosas entre ellas el mysql-connector-java-numero-bin.jar.
//ese arcchivo hay que agregar.
// En el editor de codigo IntelliJ idea (sin maven): hacemos clicl derecho en el proyecto vamos a "open module settings" , dentro vamos a la pestaña de "libraries" y agregamos "+" la libreria indiacndo el directorio donde esta el arhivo que descargamos y que vamos a añadir.
// En NetBeans con maven: click derecho sobre la carpeta Dependencies, add dep, y buscar mysql connector. Una vez agregada hacer clean and build para asegurarnos que se descargue la dependencia añadida. Luego para conectarse a la DB ir a la pestaña "Windows" de la barra e herramientas superior y buscar "Services", para que se agruegue como pestaña al lado de proyects en la barra de herramientas izquierda. Click der en Databases, new connection...



//1 Establecer la coneccion con la DB
//2 Crear un objeto de tipo Statement.
//3 Ese objeto nos permite ejecutar una sentencia sql
//4 Y la sentencia sql nos va a devolver un objeto de tipo resultset que tendremos q leer para acceder a la info de la db.

//Paso 1: consiste en crear un objeto de tipo Connection usando la clase DriverManager, especificamente el metodo getConnection(), que nos pide la ruta de la db, user y pass, y establece la coneccion a la db.
//A la hora de crear ese objeto necesitamos crear un String que almacenara la cadena de coneccion a la db, ej:
//jdbc:mysql://localhost:9999/gestionPedidos
//jdbc especifica el driver, luego viene el protocolo que usa el fabricante de sql (mysql en este caso) y luego los detalles de la coneccion, puerto y url o ip
//Para crear este objeto necesitamos usuario y contraseña.

//Paso 2: una vez creado este objeto de la clase Connection, hay que crear otro objeto de tipo statement. La clase usada para la conexion (Connection) con la que creamos el objeto en el paso anterior tiene metodo createStatement. Usando ese metodo aplicado sobre el objeto de tipo Connection nos devolvera un objeto de tipo Statement.

//Paso 3: ejecutar la sentencia sql. Con el objeto Statement poemos usar un metodo executeQuery que toma como parametro una sentencia sql, y devuelve un "resulset", un objeto donde se almacena la info que devuelve la sentencai sql.

//Paso 4: leer el resulset. Tenemos los metodos getString(), next(), etc. Para recorrer el objeto resulset tendremos que usar un bucle.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class jdbc1 {
    public static void main(String[] args) {
        try{
            //Paso1, crear conexion:
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaJava","root", "");
            //Paso 2 crear objeto statement usando el metodo createStatement sobre el objeto de tipo Conection creado anteriormente:
            Statement miStatement = miConexion.createStatement();
            //Paso 3: ejecutar instruccion sql:
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM usuarios");
            //El resultset es una tabla virtual q se almacena en memoria donde se almacenan los resultados que queremos ver.
            //resulset genera una tabla virtual, el metodo first() permite señalar el primer registro y next() movernos a los siguientes y devuelve T o F segun haya o no siguientes registros
            //Paso 4, recorrer o leer el resultset:
            while (miResultSet.next()){     //Mientras haya un siguiente registro:
                System.out.println(miResultSet.getString("usuario_id"));    //getString devuelve el valor de la columna designada en la actual fila como un String.
                System.out.println(miResultSet.getString("nombre"));
                //Ademas de getString tenemos metodos para los distintos tipos de datos, getShort, getDouble, getDate.
            }
        }catch (Exception e){
            System.out.println("No conecta!");
            e.printStackTrace();
        }
    }

}
