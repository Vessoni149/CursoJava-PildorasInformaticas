package poo.Interfaces;//ESTO ES UNA COPIA DE LAS CLASES SobrecargaConstructores9 Y Empleado12 PARA TRABAJAR EL TEMA DE las interfaces.
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

//Son un conjunto de directrices que deben cumplir las clases. Funcionan siimilar a una clase abstracta.
//una clase puede "implementar" una interfaz que es como heredar de una clase. Una interfaz en su interior contiene directrices (METODOS) y constantes (no puede tener variables) que podrÃ¡ usar la clase que la implementa.

//Establecen los comportamientos a cumplir por las clases que las implementan.
//Hay interfaces predefinidas en la api de java y propias que construimos nosotros.
//Caracteristicas:
//La clase que la implementa deberï¿½ obligatoriamente tener esos metodos que va a implementar (similar a clases abstractas).
//Solo pueden tener metodos abstractos publicos y cosntantes (final) publicas estaticas (no variables).
//Se almacenan en un fichero con extencion .class.
//No se pueden instanciar.
//Todos los metodos son publicos y abstractos. Solo se definen , no se implementan en ella igual que las clases astractas. No es necesario usar la palabra reservada abstract.
// Una interfaz puede extender solamente de otras interfaces (la cantidad que quiera) , no puede ehredar de clases.

//Diferencia con clases abstractas:
//Las clases abstractas pueden tener metodos normales (no abstractos), las interfaces NO.
//las intefaces permiten herencia multiple. Una clase puede heredar de una clase e implementar interfaces al mismo tiempo.


//Vamos a ver como usar el metodo sort aplicado a objetos para aplicar una interface.
//sucede que metodos sort hay muchos, segun el parametro que reciba. En este caso vamos a usarlo en el array de objetos misEmpleados. Pero al momento de usarlo, la documentacion nos dice que los elementos en el array DEBEN implementar la interface "comparable". Es decir, Empleado12 tendria que implementarla.
//En el metodo Main vamos a usar Arrays.sort (se usa asi xq es un metodo static), Luego haremos que Empleado12 implemente la interface Comparable, que en ppio dara error. Y luego para solucionar éste, incluiremos el metodo de la interfaz en la clase Empleado12, ya que las clases que implementen una interface estï¿½n obligadas a implementar o incluir sus metodos sobre escribiendolos.


//Luego veremos como se implementa una interface Jefes en la clase HerencaiJefe12 y usaremos el metodo heredado de ésta en el main.

//También crearemos 2 interfaces jefes y trabajadores, en la que jefes heredará de trabajadores, y luego se implementarán ambas de dsitintas maneras en empleados12 y herenciaJefe12.
public class Interfaces12 {
    public static void main(String[] args) {
        Empleado12[] misEmpleados = new Empleado12[6];
        misEmpleados[0] =new Empleado12("Juan",85000, 1900, 12, 17);
        misEmpleados[1] =new Empleado12("Ana",95000, 1905, 6, 2);
        misEmpleados[2] =new Empleado12("Paco",105000, 1903, 3, 7);
        misEmpleados[3] = new Empleado12("Antonio");
        HerenciaJefe12 jefe_rrhh = new HerenciaJefe12("Juan", 66000, 2006, 9, 25);
        jefe_rrhh.estableceIncentivo(2570);
        misEmpleados[4] = jefe_rrhh;
        misEmpleados[5] = new HerenciaJefe12("Maria", 70000, 1999,11,3);
        HerenciaJefe12 jefe_finanzas = (HerenciaJefe12)  misEmpleados[5];//ppio de sustitucion del polimorfismo (se puede usar un objeto de una subclase siempre que el programa espere un objeto de la superclase. Esto se da xq un jefe "es un" empleado).
          //Otra forma de hacer casting es esta:
        ((HerenciaJefe12) misEmpleados[5]).estableceIncentivo(3777);
        jefe_finanzas.estableceIncentivo(5000);
        
        //EL PRINCIPIO DE SUSTITUCION TAMBIÉN ES APLICABLE A INTERFACES. Por ej suponiendo que tenemos una interface "comparable": Comparable ejemplo = new Empleado(datos del empleado);
        //Podemos usar el metodo instanceof para saber si una instancia pertenece a una clase o si una instancia de tipo interfaz pertenece a una clase.
        
        Empleado12 director_comercial = new HerenciaJefe12("Sandra", 85000, 2012, 05, 23);
        Comparable ejemplo = new Empleado12("Roque", 95000, 2011, 06,23);
        if(director_comercial instanceof Empleado12){
        System.out.println("Es de tipo HerenciaJefe12");
    }
         if(ejemplo instanceof Comparable){
        System.out.println("Es de tipo Comparable");
    }
        System.out.println(jefe_finanzas.tomar_decisiones("Dar mas dias de vacasiones a los empleados"));
        System.out.println("El Bono de un jefe será: " + jefe_finanzas.estableceBonus(500));
        System.out.println("El bono de trabajadores sera: " + misEmpleados[3].estableceBonus(200));


        Arrays.sort(misEmpleados);
    }
}

class HerenciaJefe12 extends Empleado12 implements Jefes{
    //Al implementar la interface, tendremos que sobreescribir el metodo o los metodos que tenga la interface:
    @Override
    public String tomar_decisiones(String decision) {
        return "Un mienmbro de la direccion ha tomado la decision de: "+ decision;
    }
    @Override
    public double estableceBonus(double gratificacion) {
        double prima = 2000;
        return Trabajadores.bonusBase + prima + gratificacion;
    }

    public HerenciaJefe12(String nom, double sue, int anio, int mes, int dia) {
        super(nom, sue, anio, mes, dia);
    }
    private double incentivo;
    public void estableceIncentivo(double b){
        incentivo=b;
    }
    @Override
    public double dameSueldo(){
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }



}

class Empleado12 implements Comparable, Trabajadores{
    @Override
    public double estableceBonus(double gratificacion) {
        return Trabajadores.bonusBase + gratificacion;
    }


    //Comparable es una interfaz de java.lang y tiene el metodo compareto que basicamente compara objetos por orden y que vamos a tener que sobreescribirlo aca.
    //Para sobreescribirlo hay que ver la documentacion para saber que debe hacer el metodo.
    @Override
    public int compareTo(Object miObjeto){
         //este metodo recibira por parametro un objeto y devolvera un int.
         //tenermos que hacer un casting o refundicion del parametro que reciba para transformarlo a un Empleado.
         Empleado12 otroEmpleado = (Empleado12) miObjeto;
         if(this.sueldo<otroEmpleado.sueldo){
             return -1;
         }
         if(this.sueldo > otroEmpleado.sueldo){
             return 1;
         }
         return 0;
    }

    public Empleado12(String nom, double sue, int anio, int mes, int dia) {
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
        altaContrato = calendario.getTime();
    }
    public Empleado12(String nom) {
        this(nom, 30000, 2000, 01, 01);
    }
    public String dameNombre() {
        return nombre;
    }
    public double dameSueldo() {
        return sueldo;
    }
    public Date dameFechaContrato() {
        return altaContrato;
    }
    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }
    private String nombre;
    private double sueldo;
    private Date altaContrato;


}
final class Director extends HerenciaJefe12 {
    public Director (String nom, double sue, int anio, int mes, int dia){
        super(nom, sue, anio, mes, dia);
    }
}




