package Threads;

public class SincronizandoHilos {
    public static void main(String[] args) {
    HilosVarios hilo1=new HilosVarios();
    HilosVarios hilo2= new HilosVarios();

    //--------------------------------------------
        //1

        //Aveces no queremos que se ejecute un hilo hasta terminar otro, para eso esta el metodo join para sincronizar hilos.
        //Lo que hace es esperar a que un hilo muera para ejecutar otro. Lanza una IOException.

    hilo1.start();
    //Si comentamos este try catch veremos que los hilos estan sincronizados.
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo2.start();

        System.out.println("terminadas las tareas");//Veremos que este sout se ejecuta entre los 2 hilos, esto porque este sout pertenece al hilo main, si queremos que el hilo main se ejecute al final podemos usar el metodo join en el hilo2
    //Cada vez que creamos un hilo java le da un nombre, q podemos ver con e metodo getName.

        //--------------------------------------------
        //2
        //Los hilos e la claseHilosvario2 que tiene un constructor permiten recibir por parametro un hilo, que hasta que no termine, no se va a ejecutar el hilo instanciado.
        HilosVarios2 hilo3 = new HilosVarios2(hilo2);

        hilo3.start();


    }
}


//La segunda forma de crear un hilo era crando una clase que extienda de Thread y sobreescribir el metodo run
class HilosVarios extends Thread{
    public void run(){
        for(int i =0; i<15;i++){
            System.out.println("ejecutando hilo" + getName());
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
//Aveces no queremos que se ejecute un hilo hasta terminar otro, para eso esta el metodo join para sincronizar hilos.
    //Lo que hace es esperar a que un hilo muera para ejecutar otro. Lanza una IOException.
}


//Crearemos otra clase que herede de Threads pero esta  con un constructor que recibira como parametro un hilo, que será el que se esperara que muera para ejecutar el hilo que se intancie de esta clase.
class HilosVarios2 extends Thread{
    private Thread hilo;
    public HilosVarios2(Thread hilo){
        this.hilo = hilo;
    }
    public void run(){
        try {
            hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int i =0; i<15;i++){
            System.out.println("ejecutando hilo" + getName());
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}






















