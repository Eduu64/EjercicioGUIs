//Eduardo Morales Calvo
import javax.swing.*;
import java.awt.event.*;

public class Principal implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;// Declaración de botones
	JPanel panel1,panel2; // Declaración de paneles
	JTextField input; // Declaración de campo de texto
	JLabel explicacion,explicacion2,explicacion3;  // Declaración de labels
	Operaciones op; // Declaración de objeto Operaciones
	float SaldoUsuario; // Declaración de variable para el saldo del usuario

	public Principal() {
		JFrame frame = new JFrame("ATM Eduardo"); // Crear el objeto JFrame con título "ATM Eduardo"
		// Inicializaciones
		op = new Operaciones();
		input = new JTextField();
		explicacion = new JLabel();
		explicacion2 = new JLabel();
		explicacion3 = new JLabel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		b1=new JButton("Crear cuenta vacía");  
		b2=new JButton("Crear cuenta saldo inicial");  
		b3=new JButton("Ingresar dinero");  
		b4=new JButton("Sacar dinero");  
		b5=new JButton("Ver saldo");  
		b6=new JButton("Salir");  
		b7=new JButton("Crear");  
		b8=new JButton("Ingresar");  
		b9=new JButton("Retirar");  

		//Agrega el ActionListener
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		// Establece el diseño de los paneles
		panel1.setLayout(null);
		panel1.setVisible(false);  
		panel2.setLayout(null);
		panel2.setVisible(false);  

		// Establece las coordenadas
		panel1.setBounds(7,25, 370, 150);
		panel2.setBounds(7,25, 370, 150);
		explicacion.setBounds(50, 5, 250, 35);
		explicacion2.setBounds(50, 5, 250, 35);
		explicacion3.setBounds(50, 75, 250, 35);
		input.setBounds(50, 45, 200, 25);
		b1.setBounds(5, 200, 175, 25);
		b2.setBounds(190, 200, 190, 25);
		b3.setBounds(5, 250, 175, 25);
		b4.setBounds(190, 250, 190, 25);
		b5.setBounds(5, 300, 175, 25);
		b6.setBounds(190, 300, 190, 25);
		b7.setBounds(270, 45, 70, 25);
		b8.setBounds(270, 45, 90, 25);
		b9.setBounds(270, 45, 90, 25);

		// Agrega a paneles algunos objetos 
		panel1.add(input);
		panel1.add(b7);
		panel1.add(b8);
		panel1.add(b9);
		panel1.add(explicacion);
		panel1.add(explicacion3);
		panel2.add(explicacion2);

		//se agrega los paneles al frame y algunos botones
		frame.add(panel1);
		frame.add(panel2);
		frame.add(b1);frame.add(b2);frame.add(b3);frame.add(b4);frame.add(b5);frame.add(b6);
		
		//Establecimiento de las propiedades del contenedor(FRAME)
		frame.setResizable(false);//para no poder hacer mas grande la ventana
		frame.setSize(400,400); //establecimiento de tamaño
		frame.setLayout(null); //no hay layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //programa acaba cuando se cierra la pantalla
		frame.setVisible(true);//frame visible  
	}

	public void actionPerformed(ActionEvent e) {
		String texto; //variable texto
		float dinero; //variable flotante
		if (e.getSource()==b1) { // boton1 seleccionado (crear cuenta)
			panel1.setVisible(false); // Hacer que el panel2 no sea visible
			panel2.setVisible(false); // Hacer que el panel2 no sea visible
			SaldoUsuario = op.CreacionCuenta(); // Llamar al método CreacionCuenta() de la clase Operaciones

		}

		if (e.getSource()==b2) {// boton2 seleccionado (crear cuenta con saldo incial) 
			panel2.setVisible(false); // Hacer que el panel2 no sea visible
			explicacion.setText("Saldo con el que contará la cuenta: "); //label explicativa
			//Hacer que los botones b8 y b9 no sean visibles que son los de ingreso y retiro
			b8.setVisible(false);
			b9.setVisible(false);
			b7.setVisible(true);// Hacer que el boton de crear cuenta  sea visible
			panel1.setVisible(true); // Hacer que el panel1 sea visible, panel de input del usuario de cantidades

		}
		if (e.getSource()==b3) {// boton3 seleccionado (ingresar)
			//misma estructura que b2
			panel2.setVisible(false); 
			explicacion.setText("Ingresar: ");
			b8.setVisible(true);
			b9.setVisible(false);
			b7.setVisible(false);
			panel1.setVisible(true); 

		}
		if (e.getSource()==b4) {// boton4 seleccionado (retirar dinero)
			//misma estructura que b2
			panel2.setVisible(false); 
			explicacion.setText("Retirar: ");
			b8.setVisible(false);
			b9.setVisible(true);
			b7.setVisible(false);
			panel1.setVisible(true); 
		}
		if (e.getSource()==b5) {// boton5 seleccionado (ver saldo)
			panel1.setVisible(false); // Hacer que el panel1 no sea visible
			explicacion2.setText("Tiene: "+ SaldoUsuario + " euros"); // Establece en el label  el saldo del usuario
			panel2.setVisible(true); // Hacer que el panel2 sea visible, panel de ver saldo

		}
		if (e.getSource()==b6) {// boton6 seleccionado (salir)
			System.exit(0); // salir del programa, aunque también se puede salir con la 'X' del programa
		}
		if (e.getSource()== b7) { //Después de seleccionar el boton2, se ha seleccionado el boton7, ya que se incluye en el panel cuando se selecciona el boton2.
			texto  = input.getText().trim();; //obtiene el texto (String) del input del usuario
			dinero =  Float.parseFloat(texto); //convierte en interger
			SaldoUsuario = op.CreacionCuenta(dinero); // Llama al método CreacionCuenta(dinero) de la clase Operaciones y asignar el valor de retorno a SaldoUsuario
			explicacion3.setText("Creada cuenta con: " + SaldoUsuario + " euros"); // Establece en el label la cantidad con la que se ha creado la cuenta
            input.setText(""); // Limpiar el campo de texto

		}
		if (e.getSource()== b8) {//Después de seleccionar el boton3, se ha seleccionado el boton8, ya que se incluye en el panel cuando se selecciona el boton3.
			texto  = input.getText().trim();; //obtiene el texto (String) del input del usuario
			dinero = Float.parseFloat(texto); //convierte en interger
			SaldoUsuario = op.ingresar(dinero); // Llama al método ingresar(dinero) de la clase Operaciones y asignar el valor de retorno a SaldoUsuario
			explicacion3.setText("Ingresado: " + dinero  + " euros"); // Establece en el label la cantidad ingresada
            input.setText(""); // Limpiar el campo de texto


		}
		if (e.getSource()== b9) {//Después de seleccionar el boton4, se ha seleccionado el boton9, ya que se incluye en el panel cuando se selecciona el boton4.
			texto  = input.getText().trim();; //obtiene el texto (String) del input del usuario
			dinero =   Float.parseFloat (texto); //convierte en interger
			if(SaldoUsuario >= dinero) {
				SaldoUsuario = op.retirar(dinero); // Llama al método retirar(dinero) de la clase Operaciones y asignar el valor de retorno a SaldoUsuario
				explicacion3.setText("Retirado: " + dinero  + " euros");// Establece en el label la cantidad retirada
	
			}else {
				explicacion3.setText("No tiene suficiente dinero en la cuenta");
			}
            input.setText(""); // Limpiar el campo de texto


		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Principal(); // Crear una nueva instancia de la clase Principal
	}

}
