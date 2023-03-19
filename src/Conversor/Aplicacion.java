package Conversor;


import Ventana.conversor;

public class Aplicacion {
		
	public Aplicacion () {		
		
		presentarVentana();
	}

	private void presentarVentana() {
		
		conversor miVentana = new conversor();
		miVentana.setVisible(true);
		
	} 

}
