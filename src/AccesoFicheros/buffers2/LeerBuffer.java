package AccesoFicheros.buffers2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Este archivo es copia de "LeerFichero"

//Para acceder de un programa java a un archivo de texto externo, tenemos que construir un STREAM, una comunicacion entre el programa y el archivo.
//En el archivo LeerFichero se estaba accediendo a un archivo de pocos caracteres, pero con grandes archivos hacerlo de esa manera descripta en el arhivo no es eficiente, para eso veremos los buffers.
//El buffer es una especie de memoria interna entre medio del prograam y el archivo al que queremos acceder.

//Para usar un buffer:
//usar la clase BufferedReader para leer y BufferedWriter para escribir

//LEER:
//El metodo readLine() de BufferedReader lee linea a linea el texto que hay en un archivo, no devuelve caracter a caracter como en el "read" del archivo LeerFichero.
//Lo mismo ocurre con BufferedWrite, tiene su metodo para escribir por lineas
//En la API, podemos ver que BufferedReader hereda de la clase Reader. La descripcion dice que lee texto y los almacena en un buffer. El buffer puede tener tamaño especificado o uno x default.
//Tiene 2 constructores, uno pide como parametro un objeto de tipo Reader y otro que tiene ese param y un int que indica el tamaño del buffer.
//Respecto a los metodos que posee, está readLine() que devuelve un String, una linea de texto (1 linea de texto es considerada cuando termina con un salto de linea) y cuando no haya mas lineas devolvera un null. Lanza una IOException asique vamos a tener que usar try catch.

//Escribir:
//BufferedWriter hereda de la Clase Writer, tiene 2 constructores tmb como BufferedReader, 1 con 1 param y otro con 2 (el segundo de éste último para especificar tamaño de buffer).
//Y los metodos son varios,

public class LeerBuffer {
    public static void main(String[] args) {
        LeyendoBuffer accediendo = new LeyendoBuffer();
        accediendo.lee2();
    }
}

    class LeyendoBuffer{
        public void lee2(){
            try {
                FileReader entrada = new FileReader("C:/Users/agust/OneDrive/Escritorio/asd.txt");
                BufferedReader mibuffer = new BufferedReader(entrada); //Aca almacenamos en un buffer el fichero de texto.
                String linea ="";
                while(linea != null){
                    linea= mibuffer.readLine(); //aca se lee la linea del archivo.
                    if(linea!=null){            //Esto es para que no imprima el ultimo null.
                        System.out.println(linea);
                    }
                }
            }
            catch (IOException e) {
                System.out.println("No se encontro el archivo");
            }
        }
}
//El BufferedWriter no fue explicado pero funciona igual que el Reader.