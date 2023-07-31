package poo.Interfaces;


public interface Jefes extends Trabajadores{
//Así es como una interface hereda de otra. Ahora las clases que extiendan esta interface, tambien extenderan a trabajadores, lo que nos obliga a desarrollar todos los metodos abstractos de las interfaces.




    //Así declaramos un metodo en una interfaz, se definen pero no se desarrollan.
    //No hace falta poner public abstract, por defecto al ser una interfaz se interpreta que sus metodos son publicos y abstractos.
    String tomar_decisiones(String decision);

}
