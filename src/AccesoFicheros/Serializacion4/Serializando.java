package AccesoFicheros.Serializacion4;


import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

//Serializar consiste en convertir un objeto en una sucesion de bytes para poder almacenarlo en algun medio de almacenamiento (pc o pen drive x ej) y luego poder volver al estado anterior descerializandolo. Se usa tmb para distribuir esos objetos a ordenadores remotos.
//Se usa la interfaz Serializable, no tiene metodos asique no hay que sobreescribir nadam solo hay que decirle a una clase que la implementa.
//Eso implica que los objetos que pertenezcan a esa clase son suceptibles de ser serializados.
//Ademas manejaremos las clses  ObjectOutputStream y ObjectInputStream.
//El primero crea un flujo de datos para transferir un objeto desde el programa a un medio de almacenamiento o pc remota
//El seundo crea un flujo de datos apra que los objetos viajes desde afuuera hacia el programa
//Estas clases tienen sus metodos writeObject() y readObject() respetivamente.
//El 1ro crea el objeto en bytes para enviarlo, y el 2do lee la sucesion de bytes.
public class Serializando {
    public static void main(String[] args) {
        Administrador jefe = new Administrador("Juan", 80000, 2005,12,15);
        jefe.setIncentivo(5000);
        Empleado[] personal = new Empleado[3];
        personal[0] = jefe; //ppio sustitucion
        personal[1] = new Empleado("Ana",25000,2008,10,1);
        personal[2] = new Empleado("Luis",26000,2009,10,6);
        //Como vamos a serializar el array de tipo Empleado vamos a tener que implementar la interface Serializable en esa clase

        //ObjectOutputStream es una clase que pertenece a java.io que tiene 2 constructores, uno sin parametros y otro que crea un objeto OutputStream que escribe en la direccion especificada. Toma como parametro un objeto OutputStream.
        //Como ese metodo lanza una ioexcept hay que usar try catch.
        try{
           //Primero llevamos el objeto al exterior:
            //Creamos el flujo de datos de salida:
            ObjectOutputStream escribiendo_fichero = new ObjectOutputStream((new FileOutputStream("C:/Users/agust/OneDrive/Escritorio/yo/empleado.dat")));
            //La clase ObjectOutputStream tieen varios metodos, usaremos esl que toma como parametro un objeto, que es lo que queremos escribir.
            escribiendo_fichero.writeObject(personal);
            //cerramos el flujo:
            escribiendo_fichero.close();

            //Ahora rescatamos ese objeto exterior y lo traemos al programa:
            //Creamos el flujo de datos de entrada:
            //creamos un objeto del tipo ObjectInputStream con el constructor que recibe como parametro un objeto
            ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("C:/Users/agust/OneDrive/Escritorio/yo/empleado.dat"));
            //Va a entrar un objeto de tipo array, entonces vamos a necesitar almacenarlo en una variable de tipo array:
            //El metodo readObject de ObjectInputStream devuelve un objeto en general, por eso tendremos que hacer un casting para convertir ese objeto a un array:
            Empleado[] personal_recuperado = (Empleado[]) recuperando_fichero.readObject();
            recuperando_fichero.close();
            //Ahora para leer el array traido hay que recorrerlo:
            for(Empleado e : personal_recuperado){
                System.out.println(e);
            }
        }catch (Exception e){

        }
    }
}

class Empleado implements Serializable {
    //Cuando un emisor quiere enviar un objeto por la red al receptor, ambos tienen que tener la misma copia identica del programa java. cuando creamos el programa java, este tiene una huella o id unico que se asigna automaticamente.
    //La huella se llama SHA y la crea el compilador de java analizando como se construye el codigo. Consiste en una sucesion de 20 bytes.
    //Si emisor y receptor tienen diferentes serialVersionUID, el receptor no podra leer el objeto.
    //Cuando actualizamos o modificamos algo en el codigo como receptor, tenemos que pasar esas actualiz o mific al receptor para que pueda leer el objeto.
    //Si no, la solucion es declarar nosotros en el programa el serialVersionUID para que no lo haga automaticamente el compilador.
    //Simplemente hay qe crear una constante static long llamada serialVersionUID y asignarle un valor.
    //Si receptor y emisor tienen declarada esta constante, no importará si hay alguna actualizacion, la huella seguira siendo la misma.
    //La constante debe ser ceclarada en las cclases que implementes Serializable y en las sucesivas clases que hereden de esa clase que implementa Serializable.
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double sueldo;
    private Date fechaContrato;

    public Empleado(String n, double s, int agno, int mes, int dia){
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
        fechaContrato= calendario.getTime();
    }
    public String getNombre(){
        return nombre;
    }
    public double getSueldo(){
        return sueldo;
    }
    public Date getFechaContrato(){
        return getFechaContrato();
    }
    public void subirSueldo(double porcentaje){
        double aumento = sueldo*porcentaje/100;
        sueldo+=aumento;
    }
    public String toString(){
        return "Nombre= "+nombre+" ,sueldo= "+ sueldo+ " ,fecha de contrato=" + fechaContrato;
    }
}

class Administrador extends Empleado{
    private static final long serialVersionUID = 1L;
    public double incentivo;
    public Administrador(String n, double s,int agno, int mes, int dia){
        super(n,s,agno,mes,dia);
        incentivo = 0;
    }
    public double getSueldo(){
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }
    public void setIncentivo(double b){
        incentivo = b;
    }
    public String toString(){
        return super.toString() + "Incentio= " + incentivo;
    }
}