package ProgramaionGenerica.ArrayList.ClasesGenericasPropias;

//La programacion generica cosnstiste en escribir codigo en una clase que podamos reutilizra para objetos de distintos tipos.
//Así evitamos tener que crear una clase concreta para almacenar objeros de tipo String x ej.
//Ej. usando la clase ArrayList podemos usarla para almacenar y manejar objetos de tipo String, de tipo File, de tipo ojeto, etc.
//El problema seria el uso constinuo de casting que complica el codigo, ademas no nos posibilita la comprobacion de errores en tiempo de compilacion. Cuando usamos la herencia de una clase para controlar cualquier tipo de objetos, los errores van a ser en tiempo de ejecucion y no de compilacion.
//lo que implica que vamos a tener que controlar mas erroes.
//Las ventajas: mas sencillez en el codigo, reutilizacion de codigo, comprobacion de erroes en tiempo compilacion

//Con corchetes angulares indicamos el tipo de dato que va a manejar una clase, el argumento generico  por convenio suele ser T, U o K. Se puede usar cualquiera.
//Esto va a permitir a la hora de instanciarla (en el archivo UsoPareja) poder indicarle el tipo de dato que va a utilizar.
public class Pareja1<T>{
    private T primero;      //Usamos nuevamente la T para indicar que es generico.
    public Pareja1(){
        primero = null;
    }
    public void setPrimero(T nuevoValor){
        primero = nuevoValor;
    }
    public T getPrimero(){
        return primero;
    }

}
