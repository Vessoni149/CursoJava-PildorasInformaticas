package Sockets.Sockets1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
//Los sockets nos permiten crear aplicaciones cliente-servidor, que nos permita mover info desde un ordenador clienten a uno servidor. Es un puente virtual que comunica estos 2 ordenadores en el que se transladasn los apquetes de info.
//Para construir un socket primero ha uq tener una app cliente y una servidor.
//Vamos a necesitar para construir el socket la direccion del servidor (con ip o dominio), y el puerto de recepcion y envio.
//Tambien tendremos que crear un OutputStream en el lado del cliente y un InputStream en el lado del servidor.

//Tenemos construidos ya una interfaz para el cliente y otra para el servidor. En este archivo vamos a trabajar mas que nada en la clase EnviaTexto que es donde vamos a construir el socket.


public class Cliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoCliente extends JFrame{

	public MarcoCliente(){
		setBounds(600,300,280,350);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
		}
}

class LaminaMarcoCliente extends JPanel{
	public LaminaMarcoCliente(){
		JLabel texto=new JLabel("CHAT");
		add(texto);
		campochat = new JTextArea(12,20);
		add(campochat);
		campo1=new JTextField(20);
		add(campo1);
		miboton=new JButton("Enviar");
		EnviaTexto miEvento = new EnviaTexto();
		miboton.addActionListener(miEvento);
		add(miboton);	
		
	}
	
	private class EnviaTexto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(campo1.getText());
			//La clase Socket tiene 2 constructores: 1 construye uno sockes sin conectar. El otro connecta con la direccion de red especificada y con el puerto especificado
			//lanza una IOException
			//El primer parametro es la direccion ip, como estamos practicando en local es nuestra ip
			try {
				Socket misocket = new Socket( "192.168.1.2", 9999);
				//DataOutputStream tiene un constructor q nos pide un objeto outputStream de salida.
				//La clase Socket tiene un metodo getOutputStream que devuelve un objeto de estos.
				DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				//Estamos indicando que construimos un flujo de datos de salida que va a circular x el socket creado.
				//Ahora hay que especificar que es lo q va a circular x el soket
				flujo_salida.writeUTF(campo1.getText()); //en el flujo de datos va a viajar el texto que haya en el cammpo1.
				flujo_salida.close();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
	
		
		
		
	private JTextField campo1;
	private JTextArea campochat;
	private JButton miboton;
	
}