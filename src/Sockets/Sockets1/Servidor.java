
package Sockets.Sockets1;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//El servidor tendra que hacer 2 tareas: 1 recibir el texto en el JTextArea, y 2 realizar en segundo plano permanecer a la escucah contantemente y tener el puerto 9999 abierto
//Vamos a tener que usar los threads. para esto. 1 hilo gestionara la escucha permanente.
public class Servidor  {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}

class MarcoServidor extends JFrame implements Runnable {
	public MarcoServidor(){
		setBounds(1200,300,280,350);
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto=new JTextArea();
		milamina.add(areatexto,BorderLayout.CENTER);
		add(milamina);
		setVisible(true);

		Thread mihilo = new Thread(this);
		mihilo.start();

		}
	private	JTextArea areatexto;

	@Override
	public void run() {

		try {
			ServerSocket servidor = new ServerSocket(9999);	//Esta a la escucha del puerto
				while (true) {
					Socket misocket = servidor.accept();                    //acepta las conecciones que vengan del exterior.
					DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
					String mensaje_texto = flujo_entrada.readUTF();
					areatexto.append("\n" + mensaje_texto);
					misocket.close();    //Como se cierra la coneccion, luego de cada mensaje no se podra escuchar otro. Lo que podemos hacer es usar un bucle while infinito.
				}
			} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

//En el lado del servidor vamso a tener q usar la clase ServerSocker, que tiene un metodo constructor que construye un socket de servidor que pone la app a la escucha en un puerto que le indiquemos
//El constructor toma como parametro el puerto al que va a estar escuchando.
//Esta clase tmb tiene un metodo accept que escucha la coneccion y la acepta, es el metodo que pone a la escucha.