package cr.com.view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

import cr.com.controller.OperacionesController;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class ConversorTemperatura extends JPanel {

	private JLabel lblConversorDeTemperatura;
	private JLabel lblCalcualr;
	private JPanel btnCalcular;
	private JFormattedTextField inputNum2;
	private JComboBox comboBoxTemperaturas2;
	private JPanel dataBox_1;
	private JComboBox comboBoxTemperaturas1;
	private JFormattedTextField inputNum1;
	private JPanel dataBox;
	private OperacionesController controller;
	private JLabel Fondo;

	/**
	 * Create the panel.
	 */
	
	public void setImageLabel(JLabel label, String root) {
		ImageIcon imagen = new ImageIcon(root);
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		this.repaint();
	}
	
	public ConversorTemperatura() {
		setBounds(new Rectangle(0, 0, 0, 560));
		controller = new OperacionesController();
		setLayout(null);
		
		JPanel panelContenidoConversorMonedas = new JPanel();
		panelContenidoConversorMonedas.setLayout(null);
		panelContenidoConversorMonedas.setVerifyInputWhenFocusTarget(false);
		panelContenidoConversorMonedas.setBounds(0, 0, 624, 560);
		add(panelContenidoConversorMonedas);
		
		dataBox = new JPanel();
		dataBox.setLayout(null);
		dataBox.setBackground(Color.DARK_GRAY);
		dataBox.setBounds(49, 168, 205, 112);
		panelContenidoConversorMonedas.add(dataBox);
		
		inputNum1 = new JFormattedTextField();
		inputNum1.setFont(new Font("Roboto", Font.PLAIN, 19));
		inputNum1.setBackground(Color.WHITE);
		inputNum1.setBounds(31, 51, 140, 42);
		dataBox.add(inputNum1);
		
		comboBoxTemperaturas1 = new JComboBox();
		comboBoxTemperaturas1.setModel(new DefaultComboBoxModel(new String[] {"Celcius", "Fahrenheit", "Kelvin"}));
		comboBoxTemperaturas1.setBorder(null);
		comboBoxTemperaturas1.setBounds(31, 18, 140, 22);
		dataBox.add(comboBoxTemperaturas1);
		
		dataBox_1 = new JPanel();
		dataBox_1.setLayout(null);
		dataBox_1.setBackground(Color.DARK_GRAY);
		dataBox_1.setBounds(373, 168, 205, 112);
		panelContenidoConversorMonedas.add(dataBox_1);
		
		comboBoxTemperaturas2 = new JComboBox();
		comboBoxTemperaturas2.setModel(new DefaultComboBoxModel(new String[] {"Celcius", "Fahrenheit", "Kelvin"}));
		comboBoxTemperaturas2.setBounds(33, 19, 140, 22);
		dataBox_1.add(comboBoxTemperaturas2);
		
		inputNum2 = new JFormattedTextField();
		inputNum2.setFont(new Font("Roboto", Font.PLAIN, 19));
		inputNum2.setEditable(false);
		inputNum2.setDisabledTextColor(Color.BLACK);
		inputNum2.setBorder(null);
		inputNum2.setBounds(33, 52, 140, 42);
		dataBox_1.add(inputNum2);
		
		btnCalcular = new JPanel();
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setLayout(null);
		btnCalcular.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(0, 0, 0)));
		btnCalcular.setBackground(new Color(128, 0, 255));
		btnCalcular.setBounds(219, 343, 175, 64);
		panelContenidoConversorMonedas.add(btnCalcular);
		
		lblCalcualr = new JLabel("CALCULAR");
		lblCalcualr.setForeground(Color.WHITE);
		lblCalcualr.setFont(new Font("Roboto", Font.BOLD, 22));
		lblCalcualr.setBounds(27, 14, 129, 34);
		btnCalcular.add(lblCalcualr);
		
		lblConversorDeTemperatura = new JLabel("CONVERSOR DE TEMPERATURA");
		lblConversorDeTemperatura.setForeground(Color.WHITE);
		lblConversorDeTemperatura.setFont(new Font("Roboto", Font.BOLD, 38));
		lblConversorDeTemperatura.setBorder(new EmptyBorder(6, 4, 0, 0));
		lblConversorDeTemperatura.setBounds(22, 56, 592, 62);
		panelContenidoConversorMonedas.add(lblConversorDeTemperatura);
		
		Fondo = new JLabel("");
		Fondo.setBounds(0, 0, 624, 560);
		setImageLabel(Fondo, ".\\imgs\\backgounds\\FondoContenido.png");
		panelContenidoConversorMonedas.add(Fondo);
		
		
		
		//------------------LISTENERS 
		
		//BOTON CALCULAR
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCalcular.setBackground(new Color(128, 0, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCalcular.setBackground(new Color(128, 0, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.validar(inputNum1);
				
				
				float grados = Float.parseFloat(inputNum1.getText().toString());
				var tipo1 = String.valueOf(comboBoxTemperaturas1.getSelectedItem()); 
				var tipo2 = String.valueOf(comboBoxTemperaturas2.getSelectedItem());
				
				controller.calcularGrados(grados, inputNum2, tipo1, tipo2);
			}
		});
		
	}
	
	public void constructor(JPanel panel) {
		this.setSize(800, 600);
		this.setLocation(0,0);
		panel.removeAll();
		panel.add(this, BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
	}

}
