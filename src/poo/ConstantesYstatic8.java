package poo;

public class ConstantesYstatic8 {
    //El metodo main es public para poder ser acceido desde fuera de la clase.
    //es static, eso implica que  no actuara sobre ningun objeto, ya que no hay ningun objeto construido, ya que x aca se empieza la ejecución, entonces este metodo debe poder ser ejecutado sin que exista ninun metodo.
    //Recibe por parametro un array de tipo String que se llama args. Mas adelante veremos como podemos pasarle otros parametros.
    public static void main(String[] args) {
        Empleados trabajador1 = new Empleados("Paco");
        Empleados trabajador2 = new Empleados("Ana");
        Empleados trabajador3 = new Empleados("Pero");
        Empleados trabajador4 = new Empleados("Juan");
        trabajador1.setSeccion("RRRHH");
        //trabajador1.setNombre("asd");         //esta linea dara error si nombre es uan constante.
        System.out.println(trabajador1.devuelveDatos());
        System.out.println(trabajador2.devuelveDatos());
        System.out.println(trabajador3.devuelveDatos());
        System.out.println(trabajador4.devuelveDatos());
//acá ejecutamos el metodo static:
        System.out.println(Empleados.dameIdSiguiente());
    }
}

class Empleados{
    public Empleados(String nom){
        nombre = nom;
        seccion = "Administracion";
        Id = IdSiguiente;
        //El primer objeto que instanciemos tendrá id 1,
        //luego se incrementara idSiguiente, haciendo que el siguiente objeto que instanciemos tenga un id de 2.
        IdSiguiente++;

    }

    public String getNombre() {
        return nombre;
    }

    //este metodo por el solo hecho de existir daria error, ya que una constante no puede teenr un metodo setter.
   /* public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String devuelveDatos(){
        return "El nombre es: " + nombre + " y la seccion es: " + seccion + ". Tiene el id: " + Id;
    }

    //final se pone entre el modificador de acceso y el tipo de dato, sirve para que el dato sea una constante y no pueda reasignarse.
    private final String nombre;
    private String seccion;
       private int Id;

    //static va a  hacer que cada vez que instanciemos un objeto, que va a tener una copia de nombre y de seccion, NO TENGA una copia de Id.
    //Entonces va a haber un único campo id que compartirán todos los objetos que instanciemos, no que cada uno tenga el suyo
    //de esta forma podremos incrementar esa variable de 1 en 1 para que cada objeto tome ese valor.
    //En otras palabras: static hace que una variable/metodo pase a ser de la clase y no del objeto instanciado de esa Clase. Por eso es que para acceder
    // a ese metodo o variable static solo vamos a usar Clase.variable/metodo(). Y no hará falta ni si quiera instanciar un objeto de esa clase para usarlos.
    //Los metodos static no actúan sobre ningun objeto.
    //y para poder usar variables/metodos estatios fuera de la clase, éstos deben ser public. En este ejemplo no hará falta ya que se usará entro de la misma clase Empleados.
    private static int IdSiguiente = 1;

    //vamos a constuir un metodo static para mostrar el valor de IdSiguiente, que incrementa su valor cada que se instancia un objeto de la clase empleados.:
    public static String dameIdSiguiente(){
        return "El IdSiguiente es: " + IdSiguiente;
    }
    //los metodos estaticos no pueden acceer a las variables de clase que NO sean ESTATICAS
}
//Otro ej de static:
//PI de la Clase Math es public static final double:
//como es publica, se puede acceder a ella desde otra clase, incluso desde otro paquete.
//al tener  final es una constante.
//al ser static, indica que es perteneciante a la clase, no a objetos isntanciados de la clase.
//entonces para usarla se una Clase.constante: Math.PI

//RESUMEN DE STATIC:
//1) No actuan sore objetos.
//2) no acceden a variables/constantes declaradas en la clase donde están,salvo que estas sean estatic. Ej: dameIdSiguinete puede acceder a id siguiente xq ambos son estaticos.
//3) se llama con NombreClase.Metodo/variable.