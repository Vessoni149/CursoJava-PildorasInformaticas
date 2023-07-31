package Threads.banco;

public class BancoSincronizado {
    public static void main(String[] args) {

        Banco b = new Banco();
        for (int i = 0; i < 100; i++){
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }

    }

}


class Banco{
    private final double[] cuentas;
    //private Lock cierreBanco = new ReentrantLock();       //Con synchronized ya no hace falta
    //private Condition saldoSuficiente;                    //Con synchronized ya no hace falta
    public Banco(){
        cuentas = new double[100];
        for(int i = 0; i < cuentas.length; i++){
            cuentas[i] = 2000;
        }
        //Cada vez que creemos un banco vendra con un bloqueo establecido con una condicion, que permitira usar este campo saldoSuficiente como condicion en caulquier metodo que pertenezca a la clase Banco.
        //saldoSuficiente = cierreBanco.newCondition(); //Con synchronized ya no hace falta
    }





    //Synchronized es una palabra reservada que permite establecer bloqueos y una condicion pero de una forma mas sencilla que con await y signalAll pero tiene sus limitaciones.
//Para poder usarla, hay que saber que la clase Object tiene 2 metodos void wait() y void notifyAll() que sirven para lo mismo que await y signalAll de la interfaz Condition que hemos visto
//Hacen lo mismo que esos metodos, podemos modificar el codigo usando estos metodos y serviria igual.
    //La diferencai es que si usamos los metodos de la calse object solo podemos usar una sola condicion para los hilos. En cambio, con los metodos de la interfaz condition, podemos establecer varias condiciones.
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
    //Usaremos la clase ReentrantLock que implementa la interfaz Lock que tiene entre otros, los metodos lock y unlock, que sirven para bloquear y desbloquear hilos de ejecucion en ciertas lineas de codigo.
    // Esto será util aca xq si tenemos varias lineas de codigo ejecutando transferencias, en algun momento 2 hilos pueden actuar sobre una misma cuenta y quizas uno este imprimiendo un saldo total cuando otro hilo ya desconto saldo de esa cuenta y el saldo total se desconto. o al revez, que se muestre un saldo total menor por haberse ejecutado 2 veces la resta y una vez la suma y se imprima en pantalla el salto total antes de hacer la segunda suma.

        //El metodo lock() hace que un trozo de codigo se bloquee para impedir que un segundo hilo quiera acceder a ese trozo de codigo, hasta que el hilo1 desbloquee ese trozo, que lo hara cuando  termine de ejecutar ese trozo de codigo.
        //A su vez el hilo 2 tmb usara el metodo lock para los hilos sucesores.
        //Este metodo no es static asique hay que intanciar la clase ReentrantLock. Se va a hacer dentro de la clase banco


    //La clase ReentrantLock tiene otro metodo llamado newCondition() que permite crar un bloqueo pero con una condicion. Retorna un objeto de tipo condition, una interfaz que tiene entre otros, los metodos await() para poner un hilo a la espera y desblouqear el codigo, y signalAll() que informa a todos los hilos que estan a la espera despierten.

        //El hilo entra con el metodo transferencia y bloquea este bloque de codigo para que no entre ningun hilo mas:

        //Con synchronized ya no hace falta:
        //cierreBanco.lock(); //caundo un hilo llame a este metodo lo va a bloquear para que los hilos sucesivos no lo ejecuten hasta que se termine de ejecutar y se desbloquee.


        //Con synchronized ya no hace falta los metodos await y unlick, por lo uqe tampoco necesitamos el bloque try para manejar el error del await
        //try {
        while(cuentas[cuentaOrigen] < cantidad){   //Verificamos que el saldo a transferir no sea menos que el que hay en la cuenta
            //Con synchronized ya no hace falta:
            //saldoSuficiente.await();     //mientras la ondicion del while sea T, el hilo permanezca a la espera, liberando el blouqeo para que pueda entrar otro hilo.
            //System.out.println("----------CANTIDAD INSUFICIENTE: " +" cuenta: " + cuentaOrigen + "saldo actual: " + cuentas[cuentaOrigen] + "... cantidad a transferir " + cantidad );
            //return;     //Este return hara que no se ejecuten las lneas que aparecen debajo, no realizando la transferencia, perdiendose el hilo, solo desbloqueara el codigo por el metodo unlock
            wait();     //Gracais a synchronized podemos usar esto para que el hilo espere, caundo el hilo entra en el white se pone a la espera.
            //al final del codigo, si la condicion no se cumple, con el medoto notifyAll() informa a todos los hilos que esten a la espera que vuelvan a revizar la condicion.
        }
        //Si entra otro hilo y no cumple la condicion del while ejecuta lo de aca abajo:
            //Así, imprime q hilo es, resta la cantidad de la cuenta origen, imprime la operacion, suma en la cuenta destino, e imprime el salto total de todas las cuentas Y despierta a todos lo hilos que estén a la espera para que se ejecuten.
    //En resumen: el while verifica si una cuenta no tiene saldo para hacer transferencia, si no tiene saldo se ejecuta el await para esperar que otro hilo entre en ejecucion y en algun moemnto transfiera dinero a esa cuenta sin sando para que una vez hecho eso se desbloquee ese hilo bloqueado y se pueda hacer la transferencia.

        System.out.println(Thread.currentThread());

        cuentas[cuentaOrigen] -= cantidad;  //Dinero que sale de la cuenta origen.

        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen,cuentaDestino);
        cuentas[cuentaDestino]+= cantidad;  //dinero que entra a la cuenta destino
        System.out.printf(" Saldo total: %10.2f%n" , getSaldoTotal());

        notifyAll();
        //saldoSuficiente.signalAll();      //Con synchronized ya no hace falta
    //}//finally {                         //Con synchronized ya no hace falta
            //cierreBanco.unlock();
        //}
    }

    public double getSaldoTotal(){
        double suma_cuentas = 0;
        for (double a: cuentas) {
            suma_cuentas += a;
        }
        return suma_cuentas;
    }



}


class EjecucionTransferencias implements Runnable{

    private  Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
    @Override
    public void run() {
        try {
            while(true){
                int paraLaCuenta = (int)(100*Math.random());
                double cantidad = cantidadMax*Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta,cantidad);
                Thread.sleep((int)(Math.random()*10));
            }
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    public EjecucionTransferencias(Banco b, int de, double max){
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;

    }
}














