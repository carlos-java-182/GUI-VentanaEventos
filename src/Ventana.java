import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ventana extends JFrame {

	private JPanel panel;
	private JLabel saludo;
	private JTextArea areaTexto;
	private JButton boton;
	private JTextField cajaTexto;

	public Ventana() {
		setBounds(50, 50, 500, 500);
		setTitle("Eventos");
		iniciarComponentes();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void iniciarComponentes() {

		colocarPanel();
		// colocarEtiqueta();
		colocarAreaDeTexto();
		//colocarBoton();
		colocarCajaTexto();
	}

	public void colocarPanel() {
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);

		// eventoDeMovimientoDeRaton();
		// eventoDeLaRuedaDelRaton();

	}

	public void colocarEtiqueta() {
		JLabel etiqueta = new JLabel("Ingrese su nombre: ");
		etiqueta.setBounds(40, 15, 200, 30);
		etiqueta.setFont(new Font("cooper black", 1, 20));
		panel.add(etiqueta);
	}

	public void colocarCajaTexto() {
		cajaTexto = new JTextField();
		cajaTexto.setBounds(50, 30, 200, 25);
		panel.add(cajaTexto);

		eventosDelTeclado();
	}

	public void colocarAreaDeTexto() {

		areaTexto = new JTextArea();
		areaTexto.setBounds(50, 70, 200, 300);
		panel.add(areaTexto);

		JScrollPane scroll = new JScrollPane(areaTexto, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(50, 70, 200, 300);
		panel.add(scroll);

	}

	public void colocarBoton() {
		boton = new JButton("¡Pulsa aquí!");
		boton.setBounds(150, 350, 150, 40);
		boton.setFont(new Font("Arial", 0, 15));
		panel.add(boton);

		saludo = new JLabel();
		saludo.setBounds(50, 200, 300, 40);
		saludo.setFont(new Font("Arial", 1, 20));
		panel.add(saludo);

		// eventoOyenteDeAccion();
		// eventoOyenteDeRaton();

	}

	public void eventoOyenteDeAccion() {

		// Agregando Evento de tipo Action Listener

		ActionListener oyenteDeAccion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saludo.setText("Hola " + areaTexto.getText());

			}
		};

		boton.addActionListener(oyenteDeAccion);
	}

	public void eventoOyenteDeRaton() {

		MouseListener oyenteDeRaton = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				areaTexto.append("\nmouseClicked\n");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// areaTexto.append("\nmousePressed");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// areaTexto.append("\nmouseReleased");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// areaTexto.append("\nmouseEntered");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// areaTexto.append("\nmouseExited");
			}

		};

		boton.addMouseListener(oyenteDeRaton);
	}

	public void eventoDeMovimientoDeRaton() {

		MouseMotionListener oyenteMovimientoRaton = new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				areaTexto.append("mouseMoved\n");

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				areaTexto.append("mouseDragged\n");

			}

		};
		panel.addMouseMotionListener(oyenteMovimientoRaton);
	}

	public void eventoDeLaRuedaDelRaton() {

		MouseWheelListener ruedaRaton = new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				if (e.getPreciseWheelRotation() == -1) {
					areaTexto.append("Rueda hacia arriba\n");
				}

				if (e.getPreciseWheelRotation() == 1) {
					areaTexto.append("Rueda hacia abajo\n");
				}

			}

		};

		panel.addMouseWheelListener(ruedaRaton);

	}

	public void eventosDelTeclado() {

		KeyListener eventoTeclado = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				//areaTexto.append("keytypped\n");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//areaTexto.append("keyreleased\n");
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//areaTexto.append("keypressed\n");
				if(e.getKeyChar() == 'p') {
					areaTexto.append("Letra p\n");
				}
				if(e.getKeyChar()== '\n') {
					areaTexto.append("Enter\n");
				}
				if(e.getKeyChar()==' ') {
					areaTexto.append("Espacio\n");
				}

			}
		};

		cajaTexto.addKeyListener(eventoTeclado);

	}

}
