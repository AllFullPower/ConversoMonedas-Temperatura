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
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Cursor;

public class ConversorMonedas extends JPanel {
	private OperacionesController controller;
	private JComboBox comboBoxMonedas1;
	private JFormattedTextField inputNum1;
	private JPanel dataBox;
	private JPanel panelContenidoConversorMonedas;
	private JPanel dataBox_1;
	private JComboBox comboBoxMonedas2;
	private JFormattedTextField inputNum2;
	private JPanel btnCalcular;
	private JLabel lblCalcualr;
	private JLabel lblConversorDeMonedas;
	private JLabel fodno;

	/**
	 * Create the panel.
	 */
	
	public void setImageLabel(JLabel label, String root) {
		ImageIcon imagen = new ImageIcon(root);
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icon);
		this.repaint();
	}
	
	public ConversorMonedas() {
		setOpaque(false);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		controller = new OperacionesController();

		panelContenidoConversorMonedas = new JPanel();
		panelContenidoConversorMonedas.setLayout(null);
		panelContenidoConversorMonedas.setVerifyInputWhenFocusTarget(false);
		panelContenidoConversorMonedas.setBounds(0, 0, 624, 539);
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

		comboBoxMonedas1 = new JComboBox();
		comboBoxMonedas1.setModel(new DefaultComboBoxModel(new String[] { "Euro", "Colones", "Dolares", "Yenes" }));
		comboBoxMonedas1.setBorder(null);
		comboBoxMonedas1.setBounds(31, 18, 140, 22);
		dataBox.add(comboBoxMonedas1);

		dataBox_1 = new JPanel();
		dataBox_1.setLayout(null);
		dataBox_1.setBackground(Color.DARK_GRAY);
		dataBox_1.setBounds(373, 168, 205, 112);
		panelContenidoConversorMonedas.add(dataBox_1);

		comboBoxMonedas2 = new JComboBox();
		comboBoxMonedas2.setModel(new DefaultComboBoxModel(new String[] { "Euro", "Colones", "Dolares", "Yenes" }));
		comboBoxMonedas2.setBounds(33, 19, 140, 22);
		dataBox_1.add(comboBoxMonedas2);

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
		btnCalcular.setBackground(new Color(0, 128, 0));
		btnCalcular.setBounds(219, 343, 175, 64);
		panelContenidoConversorMonedas.add(btnCalcular);

		lblCalcualr = new JLabel("CALCULAR");
		lblCalcualr.setForeground(Color.WHITE);
		lblCalcualr.setFont(new Font("Roboto", Font.BOLD, 22));
		lblCalcualr.setBounds(27, 14, 129, 34);
		btnCalcular.add(lblCalcualr);

		lblConversorDeMonedas = new JLabel("CONVERSOR DE MONEDAS");
		lblConversorDeMonedas.setForeground(Color.WHITE);
		lblConversorDeMonedas.setFont(new Font("Roboto", Font.BOLD, 38));
		lblConversorDeMonedas.setBorder(new EmptyBorder(6, 4, 0, 0));
		lblConversorDeMonedas.setBounds(49, 51, 529, 62);
		panelContenidoConversorMonedas.add(lblConversorDeMonedas);
		
		fodno = new JLabel("");
		fodno.setBounds(0, 0, 624, 539);
		setImageLabel(fodno, ".\\imgs\\backgounds\\FondoContenido.png");
		panelContenidoConversorMonedas.add(fodno);
		

		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.validar(inputNum1);
				float num1 = Float.parseFloat(inputNum1.getText().trim().toString());
				JFormattedTextField num2 = inputNum2;

				var tipoMoneda1 = String.valueOf(comboBoxMonedas1.getSelectedItem());
				var tipoMoneda2 = String.valueOf(comboBoxMonedas2.getSelectedItem());

				controller.calcular(num1, num2, tipoMoneda1, tipoMoneda2);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCalcular.setBackground(new Color(0, 90, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCalcular.setBackground(new Color(0, 128, 0));
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
