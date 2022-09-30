package cr.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import cr.com.controller.OperacionesController;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane, contenidoPrincipalPanel, panelContenidoConversorTemperatura;
	private JPanel leftPanelBotones;
	private JPanel btnCalcular;
	private JLabel lblCalcualr;
	private JPanel dataBox;
	private JFormattedTextField inputNum1;
	private JFormattedTextField inputNum2;
	private JComboBox comboBoxSelector1;
	private JComboBox comboBoxSelector2;
	private JLabel lblTittle;

	private OperacionesController controller;
	private JPanel panel;
	private JPanel btnExit;
	private JLabel lblbtnX;

	private int mouseX, mouseY;
	private int locationX, locationY;
	private ConversorMonedas conversorMonedas;
	private ConversorTemperatura conversorTemperatura;
	private JLabel lblIconoMonedas;
	private JPanel botonCambiarMonedas;
	private JPanel botonCambiarTemperatura;
	private JLabel lblIconoTemperatura;
	private JLabel fondoBotonesIzquierda;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setUndecorated(true);
		setVisible(true);
		dispose();
		

		this.controller = new OperacionesController();
		setLocationByPlatform(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 520);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(UIManager.getBorder("PasswordField.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		buildConversorEscene();

		// A frame is displayable as long as it is realized. Call dispose() to make it
		// undisplayable.

		// Calling pack() or setVisible(true) makes the frame displayable again.

	}

	// PARA ESTABLECER IMAGENS
	public void setImageLabel(JLabel label, String root) {
		ImageIcon imagen = new ImageIcon(root);
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		this.repaint();
	}

	private void buildConversorEscene() {


		leftPanelBotones = new JPanel();
		leftPanelBotones.setBackground(new Color(0, 128, 64));
		leftPanelBotones.setBounds(0, 0, 99, 520);
		contentPane.add(leftPanelBotones);
		leftPanelBotones.setLayout(null);
		
		
		
		botonCambiarMonedas = new JPanel();
		botonCambiarMonedas.setBounds(10, 85, 79, 78);
		leftPanelBotones.add(botonCambiarMonedas);
		botonCambiarMonedas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCambiarMonedas.setBackground(new Color(255,255,255,0));
		botonCambiarMonedas.setLayout(null);
		
		lblIconoMonedas = new JLabel("");
		lblIconoMonedas.setBounds(10, 11, 59, 56);
		setImageLabel(lblIconoMonedas, ".\\imgs\\icons\\iconoMonedas.png");
		botonCambiarMonedas.add(lblIconoMonedas);
		

		
		botonCambiarTemperatura = new JPanel();
		botonCambiarTemperatura.setBounds(10, 248, 79, 78);
		leftPanelBotones.add(botonCambiarTemperatura);
		botonCambiarTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCambiarTemperatura.setLayout(null);
		botonCambiarTemperatura.setBackground(new Color(255, 255, 255, 0));
		
		lblIconoTemperatura = new JLabel("");
		lblIconoTemperatura.setBounds(10, 11, 59, 56);
		setImageLabel(lblIconoTemperatura, ".\\imgs\\icons\\iconoTemperatura.png");
		botonCambiarTemperatura.add(lblIconoTemperatura);
		
		
		
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 723, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnExit = new JPanel();
		btnExit.setForeground(Color.BLACK);
		btnExit.setOpaque(false);
		btnExit.setBounds(668, 0, 55, 46);
		panel.add(btnExit);
				
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setBackground(new Color(192, 192, 192));
						
		lblbtnX = new JLabel("X");
		btnExit.add(lblbtnX);
		lblbtnX.setFont(new Font("Roboto", Font.PLAIN, 27));
								


		//////////////////////////////////////////////////
		contenidoPrincipalPanel = new JPanel();
		contenidoPrincipalPanel.setVerifyInputWhenFocusTarget(false);
		contenidoPrincipalPanel.setBounds(99, 0, 624, 520);
		contenidoPrincipalPanel.setLayout(null);
		contentPane.add(contenidoPrincipalPanel);
		
		conversorMonedas = new ConversorMonedas();
		conversorTemperatura = new ConversorTemperatura();
		conversorTemperatura.constructor(contenidoPrincipalPanel);
		conversorMonedas.constructor(contenidoPrincipalPanel);
		
		
		fondoBotonesIzquierda = new JLabel("");
		fondoBotonesIzquierda.setBounds(0, 0, 99, 520);
		leftPanelBotones.add(fondoBotonesIzquierda);
		setImageLabel(fondoBotonesIzquierda, ".\\imgs\\backgounds\\FondoBotonesIz1.png");
	
		
		
		//BOTON CAMBIAR A TEMPERATURA 
		botonCambiarTemperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonCambiarTemperatura.setOpaque(true);
				botonCambiarTemperatura.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonCambiarTemperatura.setOpaque(false);
				botonCambiarTemperatura.setBackground(new Color(255,255,100,50));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				conversorTemperatura.constructor(contenidoPrincipalPanel);
				setImageLabel(fondoBotonesIzquierda, ".\\imgs\\backgounds\\FondoBotones2.png");
			}
		});
		
		
		//BOTON CAMBIAR A MONEDAS
		botonCambiarMonedas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botonCambiarMonedas.setOpaque(true);
				botonCambiarMonedas.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botonCambiarMonedas.setOpaque(false);
				botonCambiarMonedas.setBackground(new Color(255,255,100,50));;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setImageLabel(fondoBotonesIzquierda, ".\\imgs\\backgounds\\FondoBotonesIz1.png");
				conversorMonedas.constructor(contenidoPrincipalPanel);
			}
		});

		


		// -----------------------------LISTENERS

		// Boton de salir
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setOpaque(true);
				lblbtnX.setForeground(Color.white);
				btnExit.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setOpaque(false);
				lblbtnX.setForeground(Color.black);
				btnExit.setBackground(new Color(192, 192, 192));
			}
		});


		// Panel de arriba
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

	}
}
