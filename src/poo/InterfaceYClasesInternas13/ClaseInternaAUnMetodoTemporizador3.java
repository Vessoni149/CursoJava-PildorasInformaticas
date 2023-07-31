package poo.InterfaceYClasesInternas13;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//Clases interna locales o interna a un metodo:
//Son una clase dentro de un metodo.
//Sirven cuando solo se vaa a usar (instanciar) la clase interna SOLO una vez. Sirve para simplificar el codigo.
//Su ambito queda restringido al metodo donde son declaradas.
//Las ventajas es que se encapsula mas, ni la clase externa puede acceder a esta salvo usando el metodo al que pertenece la clase interna.
public class ClaseInternaAUnMetodoTemporizador3 {
    public static void main(String[] args) {
        Reloj2 miReloj = new Reloj2();  //Como no hay constructor se inicializa sin parametros
        miReloj.enMarcha(3000, true);   //y aca ponemos las variables necesarias para el metodo enMarcha que contiene la clase interna local.
        JOptionPane.showMessageDialog(null,"Pulsa aceptar para terminar.");

    }
}

//La clase Reloj2 tendrá el metodo enMarcha y éste tendrá la clase DameLaHora2
class Reloj2 {
    public void enMarcha(int intervalo, final boolean sonido){
        //Basicamente lo que se hizo con respecto al archivo anterior es cortar la clase DameLaHora y pegarla dentro del metodo enMarcha, y a la clase le sacamos el modificador de acceso "private" ya que las clases internas a un metodo no deben llevar modif. de acceso.
        //Tambien se elimino el metodo cosntructor de la clase contenedora Reloj2 y sus 2 variables intervalo y sonido, ya que podemos pasar por parametro esas variables dentro de el metodo (enMarcha) que contendrá a la clase interna.
        //El segundo parametro, como es usado dentro de la clase debe ser final. Es una regla de clases internas a metodos.
        class DameLaHora2 implements ActionListener{
            //La clase interna local a un metodo puede acceder a variables de la clase a la que pertenece y a las varaibles del metodo.

            public void actionPerformed(ActionEvent evento){
                Date ahora = new Date();
                System.out.println("Te doy la hora cada: " + ahora);
                if(sonido){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        ActionListener oyente = new DameLaHora2();
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
    }
}



