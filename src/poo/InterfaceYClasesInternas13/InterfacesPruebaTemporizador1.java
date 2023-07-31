package poo.InterfaceYClasesInternas13;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class InterfacesPruebaTemporizador1 {
    public static void main(String[] args) {
        //El metodo Timer de javax.swing (hay varios Timer) espera como segundo parametro un objeto de tipo interfaz, concretamente
        // ActionListener.
        //Si vemos la interface ActionListener veremos que pertenece al paquete java.awt.event y tiene solo un metodo llamado a
        // actionPerformed, que vamos a tener que sobreescribir aca.
        //este evento no devuelve nada, y recibe como parametro de tipo ActionEvent.
        //Como no podemos instanciar un objeto de una interfaz estamos obligados a crear una clase que implemente la interface ActionListener, para despues crearnos una isntancia.
        // de esa clase, que es la que usaremos para instanciar el objeto. Y la clase deberá tener el metodo sobreescrito de la interface.

        DameLaHora oyente = new DameLaHora(); //Instanciamos el objeto de la clase que implementa la interface ActionListener
        Timer miTemporizador = new Timer(5000, oyente);
        miTemporizador.start(); //el metodo start de la clase Timer inicia el temporizador.

        //Para que el programa esté en ejecucion hasta que nosotros querramos crearemos una ventana de joptionpane para que recine se pare la ejecucion al cerrar la ventana.

        JOptionPane.showMessageDialog(null,"Pulsa aceptar para detener");


        //(Como se vio antes, una interfaz, al igual que una clase abstracta no se puede instanciar.
        // Lo que si se puede hacer es instanciar la interfaz pero diciendo que es = a un objeto de tipo xClase
        // teniendo que esa xClase implementar previamente la interfaz. En el ej de este apartado podria quedar asi:
        // ActionListener oyente = new DameLaHora();)

    }
}

class DameLaHora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Date ahora = new Date();
        System.out.println("Te pongo la hora cada 5 seg.: " + ahora);
        //Toolkit es una clase puente entre el programa y el sistema operativo. Poemos acceder x ej a la resol de pantalla y a recursos de sonido
        //En este caso lo usamos para que suene una bocina.
        Toolkit.getDefaultToolkit().beep();
    }
}

