package poo;

import java.util.Date;
import java.util.GregorianCalendar;


//ESTO ES UNA COPIA DE LAS CLASES EMPLEADO Y USOEMPLEADO7 PARA TRABAJAR EL TEMA DE LA SOBRECARGA DE METODOS y HERENCIA (casting de objetos).
public class SobrecargaConstructores9 {
    public static void main(String[] args) {



        Empleadox[] misEmpleados = new Empleadox[6];

        misEmpleados[0] =new Empleadox("Juan",85000, 1900, 12, 17);
        misEmpleados[1] =new Empleadox("Ana",95000, 1905, 6, 2);
        misEmpleados[2] =new Empleadox("Paco",105000, 1903, 3, 7);
        misEmpleados[3] = new Empleadox("Antonio"); //El interprete de java detecta el constructor por los parametros que le pasamos. Como solo le pasamos nombre,
        //la fecha de alta dara null, ya que Date es un objeto. Si no se le da un valor iniciar a una variable de tipo objeto dara null. Las otras variables java las inicializara por defecto.
        //Se pueden sobrecargar los metoods las veces que querramos siempre que tengnas distintos parametros.
        //como los objetos se guardan en un arrai que se va a recorrer y segun nuestro bucle for each va a mostrar todos los datos del objeto, el objeto que hayamos
        // instanciado con el metodo sobrecargado solo tendrá un nombre, el resto de datos seran asigados por defecto.
        //para solucionar esto podemos hacer lo que hacemos en el metodo sobrecargado (ver línea 48), que es asignarle valores por defecto nosotros.

        //Cuando se ejecute el bucle y entre otras cosas muestra el sueldo de los empleados, al momento de iterar a los jefes, va a ejecutar el metodo dame sueldo de ellos, no al metodo dameSueldo de empleado. Y el metodo dameSueldo de los jefes tiene una bonificacion, x eso será mas dinero que el sueldo mas el 5%.
        //La JVM automaticamente en la ejecucion detecta a qué clase pertenece el metodo. Esto se llama enlazado dinamico.
        for(Empleadox e: misEmpleados){
            e.subeSueldo(5);
        }
        for(Empleadox e: misEmpleados){
            System.out.println("Nombre: " + e.dameNombre() + " Sueldo: "
                    + e.dameSueldo() + " Fecha de alta: " + e.dameFechaContrato());
        }
//----------------------------------------------------------------------
    //HERENCIA:

    //En este archivo tengo un array de tipo Empleadox, pero que dentro tienen objetos de tipo Empleadox y HerenciaJefe9 que es una clase que hereda de Empleadox.
    //Como veremos esto se puede hacer por ppio de herencia, almacenar en un array de objetos, un objeto que no sea de esa clase sino de una clase hija.
    //Luego se puede ver que los elementos 4 y 5 del array, que son de tipo HerenciaJefe9 (osea hijos de Empleadox) están incorporados al array de 2 formas distintas:
    //MisEmpleados[4] está almacenando un objeto de la clase HerenciaJefe9 YA INSTANCIADO PREVIAMENTE (a continuacion del comentario), y MisEmpleados[5] está instanciandolo
    //al momento de su creacion.
    //La gran diferencia es que en éste útimo no se podrán utilizar los metodos (estableceIncentivo() en el ej.) de la clase hija (HerencaiJefe9) a menos que hagamos un
    //casting de objetos. Para el caso de MisEmpleados[4] también sería necesario si queremos usar el metodo desde el arrai, pero también podemos usar el metodo
    // estableceIncentivo() directamente desde el objeto instanciado previamente jefe_rrhh.estableceIncentivo(2570);
    //En resumen: Instanciar el objeto hijo en un array de objetos padres, antes de insertarlo en el array, permite acceder a los metodos de la clase hija más fácil.
    //Si no lo instanciamos antes sino que lo instanciamos en la misma linea que lo metemos al array, habrá que hacer un cast de metodos  de la clase hija para poder usarlos,
    //ya que no tendremos una variable de tipo "claseHija" a la que aplicarle el metodo.
    HerenciaJefe9 jefe_rrhh = new HerenciaJefe9("Juan", 66000, 2006, 9, 25);
        jefe_rrhh.estableceIncentivo(2570);

    misEmpleados[4] = jefe_rrhh;    //ppio de sustitucion del polimorfismo (se puede usar un objeto de una subclase siempre que el programa espere un objeto de la superclase. Esto se da xq un jefe "es un" empleado).
    misEmpleados[5] = new HerenciaJefe9("Maria", 70000, 1999,11,3);
    //Suponiendo que el metodo sobrecargado fuera el siguiente (ubicado en la clase Empleado por supuesto):
    //public Empleadox(String nom){
    //        nombre = nom;
    //    }

    //Casting de objetos:
    //misEmpleados[5].subeSueldo no aparece como metodo para usar, metodo que etá declarado en la clase Empleadox pero que no puede ser usado aca, porque
    //se está instanciando un Jefe9 (hijo de la clase Empleadox). En ppio esto parece raro porque segun la herencia un Jefe) "es un" Empleadox.
    //Por esa misma razon es que un Jefe9 se puede almacenar en un array de tipo Empleadox.
    //Sin embargo el array e tipo Empleadox solo nos permite usar metodos de Empleadox y no de otra clase.
    //Para solucionar esto hay que hacer un casting o refundicion para convertir lo que hay almacenado en ese arrai que es de tipo Empleadox, en un objeto de tipo Jefe9
    HerenciaJefe9 jefe_finanzas = (HerenciaJefe9)  misEmpleados[5];
    //Otra forma de hacer casting es esta:
        ((HerenciaJefe9) misEmpleados[5]).estableceIncentivo(3777);
    //al igual que con las variables la sintaxis es: tipo de dato, nombre de variable, = , (tipo al ue queremos convertir),  y lo que queremos refundir, en este caso Empleadox[5]
        jefe_finanzas.estableceIncentivo(5000);

    //Nunca se podra usar un metodo de la clase hija directamente en el array de objetos de tipo de la clase padre:
    //misEmpleados[5]).estableceIncentivo(3777);


    //No se podria hacer un casting de jefe a empleado ya que por herencia un jefe es siempre un empleado pero no al reves.


    }
}

class HerenciaJefe9 extends Empleadox {

    public HerenciaJefe9(String nom, double sue, int anio, int mes, int dia) {
        super(nom, sue, anio, mes, dia);
    }

    private double incentivo;
    public void estableceIncentivo(double b){
        incentivo=b;
    }

    public double dameSueldo(){
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }

    //Polimosrfismo y ppio de sustitucion:
    //Este ppio significa que se puede usar un objeto de la subclase siempre que el programa espere un objeto de la sueprclase.
    //O sea un objeto puede adoptar distintass formas segun su contexto.


}

class Empleadox {
    public Empleadox(String nom, double sue, int anio, int mes, int dia) {
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
        altaContrato = calendario.getTime();
    }

    //----------------------------------------------------------------------
    //SOBRECARGA:
    //sirve para construir objetos de distinta  manera.
    public Empleadox(String nom) {
        this(nom, 30000, 2000, 01, 01);
        //Aca nombre será asignado al instanciar al objeto, y los otros parámetros serán los de acá arriba por defeto.
        //Lo que hace this es llamar al otro constructor de la clase. En ese caso es facil xq solo hay 1 constructor. Si hubiere varios, llamaria al que tenga la misma cantidad de parametros.
    }

    //getters:
    public String dameNombre() {
        return nombre;
    }

    public double dameSueldo() {
        return sueldo;
    }

    public Date dameFechaContrato() {
        return altaContrato;
    }

    //Setters:
    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;

//Podríamos crear clases sin constructor. En ese caso java interpreta un ccnstructor por efecto que no tiene parametros. Al crear un ojeto se crearia sin asignarle singun valor a sus propiedades.
//Por otra parte, a demás de existiir la sobrecarga de constructores existe la sobrecarga de metodos comunes, que funciona de la misma manera que en la sobrecarga de metodos.
}








//----------------------------------------------------------------------
//CLASES Y METODOS FINAL.
//Al declarar una clase como FINAL, lo que sucede es que ya no se va a poder crear otra clase nueva que herede de ésta clase final.
//Corta la cadena de herencia.

final class Director extends HerenciaJefe9{
    public Director (String nom, double sue, int anio, int mes, int dia){
        super(nom, sue, anio, mes, dia);
    }
}
//Metodos final:
//supngamos que en una clase padre tenemos un metodo que no queremos que sea sobrecargado, osea, que no sea sobreescrito en una clase hija.
//lo que podemos hacer es al crearlo declararlo como final
//    public final double dameSueldo() {
//        return sueldo;
//    }
// Así no podrá haber mas de un metodo con el mismo nombre en las sucecivas clases hijas.






