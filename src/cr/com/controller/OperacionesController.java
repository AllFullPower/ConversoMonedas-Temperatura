package cr.com.controller;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import cr.com.modelo.Operaciones;

public class OperacionesController {
	private Operaciones operar;
	
	
	public OperacionesController() {
		this.operar = new Operaciones();
	}
	
	public  void calcular(Float num1, JFormattedTextField num2, String tipo1, String tipo2) {
		var monedas = operar.getMonedas();
		monedas.forEach((String moneda, Map<String, Double> values) ->{
			if(tipo1 == moneda) {
				values.forEach((String monedaTipo, Double valor) ->{
					if(monedaTipo == tipo2) {
						double resultado = 0;
						DecimalFormat df = new DecimalFormat("#.####");
						resultado = (float) num1 / valor;
						num2.setText(String.valueOf(df.format(resultado)));
					}
				});
			}
		});
	
	}

	public boolean validar(JFormattedTextField input1) {
		// TODO Auto-generated method stub
		var inputvalue1 = input1.getText();
		boolean valida = inputvalue1.trim().matches("[0-9.]*");
				
		if(!valida) {
			input1.setBorder(new LineBorder(new Color(255, 55, 55), 2, true));
			JOptionPane.showMessageDialog(input1, "Algo salio mal");
		}else {
			input1.setBorder(new LineBorder(new Color(255, 55, 55), 0, true));
		}
		
		return valida;
	
	}

	public void calcularGrados(float grados, JFormattedTextField inputNum2, String tipo1, String tipo2) {
		// TODO Auto-generated method stub
		
		float resultado = grados;
		DecimalFormat df = new DecimalFormat("#.##");
		
		if(tipo2 == "Celcius") {			
			if(tipo1 == "Fahrenheit") {
				resultado = (float) (grados - 32) * 5/9;
			}else if(tipo1 == "Kelvin") {
				resultado = (float) ((float) grados - 273.15);
			}else {
				resultado = grados;
			}
		
		}else {
			//Convirtiendo todos los datos a celcius
			if(tipo1 == "Fahrenheit") {
				grados = (float) (grados - 32) * 5/9;
			}else if(tipo1 == "Kelvin") {
				grados = (float) ((float) grados - 273.15);
			}
		
			//Converosr
			if(tipo2 == "Fahrenheit") {
				resultado = (grados * 9/5) + 32;
			}else if(tipo2 == "Kelvin") {
				resultado = (float) (grados + 273.15);
			}
			
		}
		
		inputNum2.setText(String.valueOf(df.format(resultado)));
		
	}


}
