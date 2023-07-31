package Excepciones;
//Cuando ocurre un error se crea un objeto. Ese objeto puede pertenecer a distintas clases.
//Jerarquia de errores:

/*                                Error

    Teimpo compilacion                           Tiempo ejecucion

                                                        Throwable

                                            Error                      Exception

                                                            IOException     RuntimeException
*/

//Error tiene 2 hijos:
//Errores en tiempo de compilacion (de sintaxis x ej.)
//Y errores en tiempo de ejecucion
//Estos errores de ejecucion tiene como hijo a la clase "Throwable"
//De ésta se desprenden por un lado la clase "Error" y por otro la clase "Exception".
//Error normalmente es por errores de hardware, como x ej poca memoria disponible.
//Finalmente la clases Execption se divide en:
//IOException (excepciones comprobadas o error controlado) y RuntimeException (no comprobados).

//los IOException no son culpa del programador. EJ: un programa que tiene que buscar una img que tiene que estar en una carpeta y alguien borra esa img o carpeta.
//Lo runtimeException si son errores del programador que no son de sintaxis, x ej: recorrer un array con mas posiciones de las que tiene, intentar almacenar en una variable de tipo String un int, dividir un int por 0, etc.

//IOExceptions:
//Cuando se genera un error, como se dijo, se genera un objeto. Y lo que hace el editor es mostrarnos a que clase pertenece ese error
//Si abrimos la api podemos ver la clase, que trae constructores para poder manejar ese tipo de errores.
//Las excepciones en ejecucion IOExeption se pueden controlar para evitar x ej que el programa se detenga por completo por un error.
//Cuando un metodo lleva la clase throws quiere decir que el metodo, que hace x cosa, también crea la excepcion "lanzando" un objeto eprteneciente a la clase ioexception.
//Cuando tenemos ioEx o errores controlados, java nos obliga a capturar o manipular ese error para no frenar la ejecucion con bloques try catch. Si no lo haemos seguira apareceindo error en el editor (no en consola).


import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones1 {
    public static void main(String[] args) {

        Scanner entrada2 = new Scanner(System.in);
        System.out.println("introduce tu email");
        String email= entrada2.nextLine();

    try{
        examina_email(email);
    }catch(Exception e){
        System.out.println("direccion de email demasiado corta");
    }
        pedirDatos();
    }


    //Sintaxis try catch:
   /* public void asd(){
        try{
        //aca iria la ejecucion de un metodo que tiene un throws osea que lanza excepcion en caso de error.
        //Si al resultado de ese metodo quisieramos guardarlo en una variable previamente declarada, y legado el caso de que de error este bloque, la variable quedaria con un valor de null,
        //Entonces si luego ne otra parte del codigo necesitamso usar esa varaible, vamos a obtener una excepcion no controlada "nullPointerException", que al no ser ontrolada no es obligatorio controlarla con try catch pero será una excepcion al fin y al cabo.
        //En ese caso se puede controlar con un if else. if(variable == null){...} else{ resto del codigo que se  deberia ejecutar si la imagen se cargo.
        //Tambien podemos decirle a los metodos que creamso que lancen una excepcion para capturarla con un try catch. Aunque esto es un poco mala practica ya que es mejor corregir el error en vez de producirlo y capturarlo.
        }catch(IOException e){  //e será el nombre del objeto de tipo IOExeption que se capturara.
        System.out.println("error controlado");
        }
    }*/



    //Para hacer que un metodo lance una excepcion:
    public static void pedirDatos() throws InputMismatchException {
        //ese error que le pusimos que lance es el error que tira cuando se inserta algo que no es un int donde debería ir un int.
        //Este error hereda de runTimeException, por lo que no nos obliga a usar try catch pero lo podemos hacer igual
       try{
        Scanner entrada = new Scanner(System.in);
        System.out.println(("introduce tu nombre"));
        String nombre = entrada.nextLine();
        System.out.println("introduce tu edad:");
        int edad = entrada.nextInt();       //si en este punto introducimos algo que no sea un int habra un errror no comproado.
        System.out.println("Tu nombre y edad es: " + nombre + " " + edad);
    }catch(InputMismatchException e){ //aca podemos decirle que capture o bien la excepcion puesta seguida del throws o una excepcion por encima en la jerarquia de herencia.
           //Por ej. podriamos poner RuntimeException o Exception.
           System.out.println("Que introduciste en edad?");
       }
    }//Este try catch debe ir en donde se ejecuta el metodo, no dentro del metodo mismo. Es solo a modo de ejemplo.



    //Cuando el tipo de excepcion no concuerda con la excepcion que realmente ocurre, hay que crear las propias excepciones.
//es o se hace creando una clase que herece o bien de IOException o de RuntimeException, o directamente d eEception para que sea mas generica.
//Si hereda de IOE... o de Exception nos obligaria a trabajar el error del metodo que la lanza un bloque try catch, si el Runtime no.
    static class Longitud_mail_erronea extends Exception{
        //Creamos 2 constructores, uno va a ser el mensaje predeterminado y el otro posibilita poner un mensaje particular al instanciar el objeto.
        public Longitud_mail_erronea(){}
        public Longitud_mail_erronea(String msj_error){
            super(msj_error);
        }
    }

    static void examina_email(String email) throws Longitud_mail_erronea{
        int arroba=0;
        boolean punto= false;
        if(email.length()<=3){
            throw new Longitud_mail_erronea("asd");
        }else{
            for(int i=0; i<email.length(); i++){
                if(email.charAt(i) == '@'){
                    arroba++;
                }
                if(email.charAt(i) == '.'){
                    punto = true;
                }
            }
        }

    }
}

//Clausula trhow. No es lo mismo que throws, esta ultimo la usamos en un metodo para indicar que el mismo podria lanzar una excepcion
//La clausula throw se puede usar en cualquier parte del codigo para indicar que en ese punto se lanzará una excepcion.
//EJ (suponiendo que este if esta dentro de un metodo:
/*if(mail.lenght()<3){
    ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
    throw e;
    }else...
        }*/
//Lo que se hace es instanciar el error, en este caso con el nombre de "e", pudiendo ser caulquiera, y luego se lanza.
//Hay que ver bien que error instanciar, debería ser el error que tiraría correspondiente con el error real.
//Tambien puede instanciarse la clase en la misma linea que el trhow:
//throw new ArrayIndexOutOfBoundsException();
//Cuando indiquemos un throw en un metodo, hay que indicarle al metodo que puede lanzar esa excepcion con el "throws" y seguidamente la excepcion (sin ella no va a haber error), pero le indicamos a otros programadores que ese metodo puede lanzar un error,
//y que podría capturarla, y si la excepcion es e tipo IOExpt... va a tener que capturarla obligatoriamente al ejecutar el metodo.








//EN SITESIS: