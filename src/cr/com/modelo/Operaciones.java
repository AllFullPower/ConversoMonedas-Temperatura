package cr.com.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operaciones {
	private Map<String, Map<String, Double>> monedas = new HashMap<>();
	
	public Operaciones() {
		Map<String, Double> valoresCRC = new HashMap<>();
		valoresCRC.put("Dolares", (double) 640);
		valoresCRC.put("Euro", (double) 656);
		valoresCRC.put("Yenes", (double) 0.22);
		valoresCRC.put("Colones", (double) 1);
		monedas.put("Colones", valoresCRC);
		/*Colones Euro Yenes Dolares*/
		
		Map<String, Double> ValoresDolares = new HashMap<>();
		ValoresDolares.put("Colones", (double) 0.0015625);
		ValoresDolares.put("Euro", (double) 0.97);
		ValoresDolares.put("Yenes", (double) 0.007);
		ValoresDolares.put("Dolares", (double) 1);
		monedas.put("Dolares", ValoresDolares);
		
		Map<String, Double> ValoresEuros = new HashMap<>();
		ValoresEuros.put("Colones", (double) 0.0014285);
		ValoresEuros.put("Euro", (double) 1);
		ValoresEuros.put("Dolares", (double) 1.03);
		ValoresEuros.put("Yenes", (double) 0.0069);
		monedas.put("Euro", ValoresEuros);
		
		Map<String, Double> valoresYenes = new HashMap<>();
		valoresYenes.put("Euro", (double) 143.30);
		valoresYenes.put("Dolares",(double)  142.70);
		valoresYenes.put("Yenes", (double) 1);
		valoresYenes.put("Colones",(double)  4.55);
		monedas.put("Yenes", valoresYenes);
	}
	
	public Map<String, Map<String,Double>> getMonedas(){
		return this.monedas;
	}


	
}
