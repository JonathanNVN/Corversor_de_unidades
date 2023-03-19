package Ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;


import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;




public class conversor extends JFrame implements ActionListener {

	private JPanel contentPane;		
	private JTabbedPane tabbedPane;
	
	double cantidad;	
	DecimalFormat df = new DecimalFormat("#0.000");
	private JPanel panel_4;
	
	
	//***** Variables para conversor de Monedas.
	
	private JTextField textField_NI1;
	private JTextField textField_NI2;
		
	private JComboBox comboBox_TipoMon1;
	private JComboBox comboBox_TipoMon2;
	
	private JLabel lblNewLabel_aviso;
	
	private JLabel lblNewLabel_Dolares_ParaCajaInfer;
	private JLabel lblNewLabel_Dolares_ParaCajaSup;
	
	private JLabel lblNewLabel_Soles_ParaCajaInfer;
	private JLabel lblNewLabel_Soles_ParaCajaSup;
	
	private JLabel lblNewLabel_Euros_ParaCajaInfer;
	private JLabel lblNewLabel_Euros_ParaCajaSup;
	
	private JLabel lblNewLabel_PesoArg_ParaCajaSup;	
	private JLabel lblNewLabel_PesoArg_ParaCajaInfe;	
	
	private JLabel lblNewLabel_RealBrasileño_ParaCajaSup;	
	private JLabel lblNewLabel_RealBrasileño_ParaCajaInfe;	

	
	double solADolares=0.27;	
	double solAPesoArg=53.37;	
	double solAEuros=0.25;
	double solARealBra=1.39;
	
	double euroASol=4.01;
	double euroADolares=1.06;
	double euroAPesoArg=216.89;
	double euroARealBra=5.64;
	
	double dolaresAEuros=0.94;	
	double dolaresAPesoArg=201.09;
	double dolarASoles= 3.76;
	double dolaresARealBra=5.25;
	
	double pesoArgADolares=0.0049;
	double pesoArgASol=0.02;
	double pesoArgAEuro=0.0046;
	double pesoArgARealBra=0.026;
	
	double realBraADolares=0.19;
	double realBraASol=0.72;
	double realBraAEuro=0.18;
	double RealBraAPesoArg=38.45;	
	
	
	//***** Variables para conversor de temperaturas.
	
	private JTextField textField_Izquier;
	private JTextField textField_Derech;
	private JLabel lblNewLabel_FahrenheitIzquier;
	private JLabel lblNewLabel_CelsiusDerech;
	private JComboBox comboBox_Opciones;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_kelvinIzquier;
	private JLabel lblNewLabel_kelvinDerech;
	private JLabel lblNewLabel_FahrenheitDerech;
	private JLabel lblNewLabel_CelsiusIzquier;	
	private JLabel lblNewLabel_avisoIngreseCantidad;
	
	//***Variables para distancias.
	
	private JComboBox comboBox_Distancias;
	private JComboBox comboBox_DistanciaLadoIzquier;
	private JTextField textField_DistanciaLadoIzquier;
	private JTextField textField_DistanciaLadoDerech;
	private JComboBox comboBox_DistanciaLadoDerech;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conversor frame = new conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	
	public conversor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Mi Conversor - Challenge Alura (Grupo 4)");
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 61, 369, 183);
		tabbedPane.setBackground(new Color(235, 228, 248));
		tabbedPane.setFont(new Font("Candara", Font.PLAIN, 13));
		tabbedPane.setBorder(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mi conversor");
		lblNewLabel.setBounds(34, 21, 156, 22);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		contentPane.add(tabbedPane);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 0, 434, 43);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
	
		iniciarComponentesMonedas();	
			
		iniciarComponentesTemperaturas();
		
		iniciarComponentesDistancias();

	}
	
	
	//Metodos para Conversor monedas.
	
	private void iniciarComponentesMonedas() {		

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Monedas", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel_aviso = new JLabel("INGRESE CANTIDAD (*)");
		lblNewLabel_aviso.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_aviso.setForeground(Color.RED);
		lblNewLabel_aviso.setBounds(10, 24, 163, 14);
		panel.add(lblNewLabel_aviso);
		
		lblNewLabel_Dolares_ParaCajaSup = new JLabel("Dolares");
		lblNewLabel_Dolares_ParaCajaSup.setBounds(10, 66, 82, 14);
		panel.add(lblNewLabel_Dolares_ParaCajaSup);
		
		lblNewLabel_Soles_ParaCajaSup = new JLabel("Soles");
		lblNewLabel_Soles_ParaCajaSup .setBounds(10, 66, 82, 14);
		panel.add(lblNewLabel_Soles_ParaCajaSup);
		
		lblNewLabel_Euros_ParaCajaSup = new JLabel("Euros");
		lblNewLabel_Euros_ParaCajaSup.setBounds(10, 66, 82, 14);
		panel.add(lblNewLabel_Euros_ParaCajaSup);
		
		lblNewLabel_PesoArg_ParaCajaSup = new JLabel("Pesos");
		lblNewLabel_PesoArg_ParaCajaSup.setBounds(10, 66, 82, 14);
		panel.add(lblNewLabel_PesoArg_ParaCajaSup);
		
		lblNewLabel_RealBrasileño_ParaCajaSup = new JLabel("Reales");
		lblNewLabel_RealBrasileño_ParaCajaSup.setBounds(10, 66, 82, 14);
		panel.add(lblNewLabel_RealBrasileño_ParaCajaSup);
					
		
		lblNewLabel_Dolares_ParaCajaInfer = new JLabel("Dolares");
		lblNewLabel_Dolares_ParaCajaInfer.setBounds(10, 118, 46, 14);
		panel.add(lblNewLabel_Dolares_ParaCajaInfer);
		
		lblNewLabel_Soles_ParaCajaInfer = new JLabel("Soles");
		lblNewLabel_Soles_ParaCajaInfer .setBounds(10, 118, 46, 14);
		panel.add(lblNewLabel_Soles_ParaCajaInfer);
		
		lblNewLabel_Euros_ParaCajaInfer = new JLabel("Euros");
		lblNewLabel_Euros_ParaCajaInfer.setBounds(10, 118, 46, 14);
		panel.add(lblNewLabel_Euros_ParaCajaInfer);
		
		lblNewLabel_PesoArg_ParaCajaInfe = new JLabel("Pesos");
		lblNewLabel_PesoArg_ParaCajaInfe.setBounds(10, 118, 46, 14);
		panel.add(lblNewLabel_PesoArg_ParaCajaInfe);
		
		lblNewLabel_RealBrasileño_ParaCajaInfe = new JLabel("Reales ");
		lblNewLabel_RealBrasileño_ParaCajaInfe.setBounds(10, 118, 46, 14);
		panel.add(lblNewLabel_RealBrasileño_ParaCajaInfe);
		
		textField_NI1 = new JTextField();
		textField_NI1.setBounds(10, 39, 181, 27);
		panel.add(textField_NI1);
		textField_NI1.setColumns(10);
		
		textField_NI2 = new JTextField();
		textField_NI2.setBounds(10, 91, 181, 27);
		panel.add(textField_NI2);
		textField_NI2.setColumns(10);
			
		
		comboBox_TipoMon1 = new JComboBox();			
		comboBox_TipoMon1.setModel(new DefaultComboBoxModel(new String[] {"Sol peruano", "Dolar estadounidense", "Euro", "Peso argentino", "Real brasileño"}));
		comboBox_TipoMon1.setBounds(201, 41, 153, 22);
		comboBox_TipoMon1.addActionListener(this);
		panel.add(comboBox_TipoMon1);
		
		comboBox_TipoMon2 = new JComboBox();		
		comboBox_TipoMon2.setModel(new DefaultComboBoxModel(new String[] {"Dolar estadounidense", "Sol peruano", "Euro", "Peso argentino", "Real brasileño"}));
		comboBox_TipoMon2.setBounds(201, 92, 153, 22);
		comboBox_TipoMon2.addActionListener(this);		
		panel.add(comboBox_TipoMon2);		
		
		lblNewLabel_aviso.setVisible(false);
		
		lblNewLabel_Soles_ParaCajaSup.setVisible(false);
		lblNewLabel_Dolares_ParaCajaSup.setVisible(false);
		lblNewLabel_Euros_ParaCajaSup.setVisible(false);
		lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
		lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
		
		
		lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);
		lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
		lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
		lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
		lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);			
			
		soloNumerosParaMonedas(textField_NI1,textField_NI2);
		}
	
	public void calcularCantidadText1ATex2_ConversorMonedas(){
		
				
		 while (comboBox_TipoMon1.getSelectedIndex() == 0 ) {
			
			 if (textField_NI1.getText().trim().isEmpty()) {						
					lblNewLabel_aviso.setVisible(false);				
					
			 }else {			 
					  	cantidad = Double.parseDouble(textField_NI1.getText());				  	
					
					 if(comboBox_TipoMon2.getSelectedIndex()==0) {								
							cantidad = cantidad * solADolares;								
							textField_NI2.setText(df.format(cantidad));					
							
							lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
							lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
							lblNewLabel_Dolares_ParaCajaInfer.setVisible(true);		
							lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
							lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
							
						}else if(comboBox_TipoMon2.getSelectedIndex()==1) {					
								textField_NI2.setText(df.format(cantidad));							
								
								lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);
								lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
								lblNewLabel_Soles_ParaCajaInfer.setVisible(true);
								lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
								lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
								
						}else if(comboBox_TipoMon2.getSelectedIndex()==2) {	
								cantidad = cantidad * solAEuros;									
								textField_NI2.setText(df.format(cantidad));						
								
								lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
								lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
								lblNewLabel_Euros_ParaCajaInfer.setVisible(true);
								lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
								lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
								
						}else if(comboBox_TipoMon2.getSelectedIndex()==3) {	
								cantidad = cantidad * solAPesoArg;									
								textField_NI2.setText(df.format(cantidad));						
								
								lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
								lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
								lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
								lblNewLabel_PesoArg_ParaCajaInfe.setVisible(true);
								lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
								
						}else if(comboBox_TipoMon2.getSelectedIndex()==4) {	
								cantidad = cantidad * solARealBra;									
								textField_NI2.setText(df.format(cantidad));						
								
								lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
								lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
								lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
								lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
								lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(true);
						}
				}
			 
				break;
		 }
		 
		 
		 while (comboBox_TipoMon1.getSelectedIndex() == 1) {			 
		 
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
		   	 }else {
						cantidad = Double.parseDouble(textField_NI1.getText());	
						
					
					if(comboBox_TipoMon2.getSelectedIndex()==0) {
						lblNewLabel_aviso.setVisible(false);
						textField_NI2.setText(df.format(cantidad));					
						
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
					
					}else if(comboBox_TipoMon2.getSelectedIndex()==1) {	
						cantidad = cantidad * dolarASoles;					
						textField_NI2.setText(df.format(cantidad));
							
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);						
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_Soles_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
					}else if(comboBox_TipoMon2.getSelectedIndex()==2) {	
						 cantidad = cantidad * dolaresAEuros;							 
						 textField_NI2.setText(df.format(cantidad));
						 
						 lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);							
						 lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						 lblNewLabel_Euros_ParaCajaInfer.setVisible(true);
						 lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						 lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						 
					}else if(comboBox_TipoMon2.getSelectedIndex()==3) {	
						 cantidad = cantidad * dolaresAPesoArg;									
						 textField_NI2.setText(df.format(cantidad));						
							
						 lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
						 lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						 lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						 lblNewLabel_PesoArg_ParaCajaInfe.setVisible(true);
						 lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
							
				}else if(comboBox_TipoMon2.getSelectedIndex()==4) {	
						cantidad = cantidad * dolaresARealBra;									
						textField_NI2.setText(df.format(cantidad));						
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(true);
				}
			}			 
				break;
		}
		 
		 while (comboBox_TipoMon1.getSelectedIndex() == 2) {
			 
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			 }else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon2.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * euroADolares;										
					textField_NI2.setText(df.format(cantidad));	
					
					lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
					lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
					lblNewLabel_Dolares_ParaCajaInfer.setVisible(true);
					lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
					
				}else if(comboBox_TipoMon2.getSelectedIndex()==1) {	
						cantidad = cantidad * euroASol;						
						textField_NI2.setText(df.format(cantidad));	
						
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);	
						lblNewLabel_Soles_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
				}else if(comboBox_TipoMon2.getSelectedIndex()==2) {						 
						textField_NI2.setText(df.format(cantidad));	
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);	
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
				}else if(comboBox_TipoMon2.getSelectedIndex()==3) {	
						cantidad = cantidad * euroAPesoArg;									
						textField_NI2.setText(df.format(cantidad));						
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
					
				}else if(comboBox_TipoMon2.getSelectedIndex()==4) {	
						cantidad = cantidad * euroARealBra;									
						textField_NI2.setText(df.format(cantidad));						
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(true);
				}
			}
				break;
		}
		 
		 	while (comboBox_TipoMon1.getSelectedIndex() == 3) {
			 
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			 }else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon2.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * pesoArgADolares;										
					textField_NI2.setText(df.format(cantidad));	
					
					lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
					lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
					lblNewLabel_Dolares_ParaCajaInfer.setVisible(true);
					lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
					
				}else if(comboBox_TipoMon2.getSelectedIndex()==1) {	
						cantidad = cantidad * pesoArgASol;						
						textField_NI2.setText(df.format(cantidad));	
						
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);	
						lblNewLabel_Soles_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
				}else if(comboBox_TipoMon2.getSelectedIndex()==2) {	
						cantidad = cantidad * pesoArgAEuro;	
						textField_NI2.setText(df.format(cantidad));	
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);	
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
				}else if(comboBox_TipoMon2.getSelectedIndex()==3) {															
						textField_NI2.setText(df.format(cantidad));						
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
					
				}else if(comboBox_TipoMon2.getSelectedIndex()==4) {	
						cantidad = cantidad * pesoArgARealBra;									
						textField_NI2.setText(df.format(cantidad));						
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(true);
				}
			}
				break;
		}
		 	
		 	while (comboBox_TipoMon1.getSelectedIndex() == 4) {
				 
				 if (textField_NI1.getText().isEmpty()) {
					 lblNewLabel_aviso.setVisible(true);
					 
				 }else {
						cantidad = Double.parseDouble(textField_NI1.getText());	
						
					if(comboBox_TipoMon2.getSelectedIndex()==0) {
						lblNewLabel_aviso.setVisible(false);
						cantidad = cantidad * realBraADolares;										
						textField_NI2.setText(df.format(cantidad));	
						
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
					}else if(comboBox_TipoMon2.getSelectedIndex()==1) {	
							cantidad = cantidad * realBraASol;						
							textField_NI2.setText(df.format(cantidad));	
							
							lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
							lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);	
							lblNewLabel_Soles_ParaCajaInfer.setVisible(true);
							lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
							lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
							
					}else if(comboBox_TipoMon2.getSelectedIndex()==2) {	
							cantidad = cantidad * realBraAEuro;	
							textField_NI2.setText(df.format(cantidad));	
							
							lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);	
							lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
							lblNewLabel_Euros_ParaCajaInfer.setVisible(true);
							lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
							lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
							
					}else if(comboBox_TipoMon2.getSelectedIndex()==3) {	
							cantidad = cantidad * RealBraAPesoArg;	
							textField_NI2.setText(df.format(cantidad));						
							
							lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
							lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
							lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
							lblNewLabel_PesoArg_ParaCajaInfe.setVisible(true);
							lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
					}else if(comboBox_TipoMon2.getSelectedIndex()==4) {																
							textField_NI2.setText(df.format(cantidad));						
							
							lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);									
							lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
							lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
							lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
							lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(true);
					}
				}
					break;
			}
		 
//______________________________________________________________________________________________//
		 
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 0) {
			 
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);				 
				 
			}else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * solADolares;											
					textField_NI2.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
					lblNewLabel_Euros_ParaCajaSup.setVisible(false);
					lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {					
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {						
						cantidad = cantidad * euroADolares;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * pesoArgADolares;	
						textField_NI2.setText(df.format(cantidad));
					
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {						
						cantidad = cantidad * realBraADolares;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		}	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 1) {
			
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			}else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					textField_NI2.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
					lblNewLabel_Euros_ParaCajaSup.setVisible(false);
					lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * dolarASoles;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {	
					 	cantidad = cantidad * euroASol;					 	
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * pesoArgASol;	
						textField_NI2.setText(df.format(cantidad));
					
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
				
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {						
						cantidad = cantidad * realBraASol;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		}	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 2) {
			 
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			}else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * solAEuros;					
					textField_NI2.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
					lblNewLabel_Euros_ParaCajaSup.setVisible(false);
					lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * dolaresAEuros;							
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {						 
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * pesoArgAEuro;	
						textField_NI2.setText(df.format(cantidad));
					
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
			
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {						
						cantidad = cantidad * realBraAEuro;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		} 	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 3) {
				
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			}else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * solAPesoArg;	
					textField_NI2.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
					lblNewLabel_Euros_ParaCajaSup.setVisible(false);
					lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * dolaresAPesoArg;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {	
					 	cantidad = cantidad * euroAPesoArg;					 	
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {							
						textField_NI2.setText(df.format(cantidad));
					
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
				
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {						
						cantidad = cantidad * RealBraAPesoArg;						
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		}	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 4) {
			 
			 if (textField_NI1.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			}else {
					cantidad = Double.parseDouble(textField_NI1.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * solARealBra;					
					textField_NI2.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
					lblNewLabel_Euros_ParaCajaSup.setVisible(false);
					lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
					lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * dolaresARealBra;							
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {		
						cantidad = cantidad * euroARealBra;	
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * pesoArgARealBra;	
						textField_NI2.setText(df.format(cantidad));
					
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
			
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {												
						textField_NI2.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);					
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		} 		
	}

	public void calcularCantText2ATex1_ConversorMonedas() {		
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 0) {
			 
			 if (textField_NI2.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);
				 
			}else {
					cantidad = Double.parseDouble(textField_NI2.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
						lblNewLabel_aviso.setVisible(false);
						cantidad = cantidad * dolarASoles;											
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {					
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {	
						cantidad = cantidad * dolaresAEuros;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * dolaresAPesoArg;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {	
						cantidad = cantidad * dolaresARealBra;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		}	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 1) {
			
			 if (textField_NI2.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);	
				 
			 }else {
					cantidad = Double.parseDouble(textField_NI2.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					textField_NI1.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * solADolares;							
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {	
						cantidad = cantidad * solAEuros;					 
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * solAPesoArg;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {	
						cantidad = cantidad * solARealBra;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		}	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 2) {
			 
			 if (textField_NI2.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);	
				 
			 }else {
					cantidad = Double.parseDouble(textField_NI2.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * euroASol;						
					textField_NI1.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * euroADolares;						
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {						 
						textField_NI1.setText(df.format(cantidad));
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * euroAPesoArg;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {	
						cantidad = cantidad * euroARealBra;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		} 	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 3) {
				
			 if (textField_NI2.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);	
				 
			 }else {
					cantidad = Double.parseDouble(textField_NI2.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * pesoArgASol;	
					textField_NI1.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * pesoArgADolares;							
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Dolares_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {	
						cantidad = cantidad * pesoArgAEuro;					 
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {											 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {	
						cantidad = cantidad * pesoArgARealBra;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		}	
		 
		 while (comboBox_TipoMon2.getSelectedIndex() == 4) {
			 
			 if (textField_NI2.getText().isEmpty()) {
				 lblNewLabel_aviso.setVisible(true);	
				 
			 }else {
					cantidad = Double.parseDouble(textField_NI2.getText());	
					
				if(comboBox_TipoMon1.getSelectedIndex()==0) {
					lblNewLabel_aviso.setVisible(false);
					cantidad = cantidad * realBraASol;						
					textField_NI1.setText(df.format(cantidad));
					
					lblNewLabel_Soles_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==1) {	
						cantidad = cantidad * realBraADolares;						
						textField_NI1.setText(df.format(cantidad));
						
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==2) {	
						cantidad = cantidad * realBraAEuro;	
						textField_NI1.setText(df.format(cantidad));
						lblNewLabel_Euros_ParaCajaSup.setVisible(true);
						
				}else if(comboBox_TipoMon1.getSelectedIndex()==3) {	
						cantidad = cantidad * RealBraAPesoArg;					 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(true);
					
				}else if(comboBox_TipoMon1.getSelectedIndex()==4) {											 	
					 	textField_NI1.setText(df.format(cantidad));
					 	
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(true);
				}
			}
				break;
		} 	


	}
		
	public void soloNumerosParaMonedas(JTextField a, JTextField b) {
			a.addKeyListener(new KeyAdapter() {
				
				//**** Código para que solo ingrese numeros. No letras no 2 puntos. ('..') en 'caja de texto' superior.		
				public void keyTyped(KeyEvent e) {			
					char c = e.getKeyChar();					
					if(!Character.isDigit(c) && c != '.') {
						e.consume();
					}				
					if(c == '.' && textField_NI1.getText().contains(".")) {
						e.consume();
					}				
				}			
				
				//*** Evento (Si ingresas texto) para la caja de texto superior.
				@Override
				public void keyReleased(KeyEvent e) {
					char c = e.getKeyChar();
					
					if(textField_NI1.getText().trim().isEmpty()){ //Si 'caja de texto' superior esta vacio.
						lblNewLabel_aviso.setVisible(true);	
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
						textField_NI2.setText("");
						
					} else if(c == '.') {//Si escribes un punto ('.').
						
					}else {							
						lblNewLabel_aviso.setVisible(false);					
						calcularCantidadText1ATex2_ConversorMonedas();									
					}
							
				}
				
				
			});
			
			//**** Código para que solo ingrese numeros. No letras, no 2 puntos. ('..') en 'caja de texto' inferior.
			b.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c1 = e.getKeyChar();
				
						if(!Character.isDigit(c1) && c1 != '.') {
							e.consume();
						}
						
						if(c1 == '.' && textField_NI2.getText().contains(".")) {
							e.consume();
						}	
				}			
				
				//*** Evento (Si ingresas texto) para la caja de texto inferior.
				@Override
				public void keyReleased(KeyEvent e) {	
					char c1 = e.getKeyChar();
					
									
					if(textField_NI2.getText().trim().isEmpty()){
						lblNewLabel_aviso.setVisible(true);	
						
						lblNewLabel_Soles_ParaCajaSup.setVisible(false);
						lblNewLabel_Dolares_ParaCajaSup.setVisible(false);
						lblNewLabel_Euros_ParaCajaSup.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaSup.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaSup.setVisible(false);
						
						lblNewLabel_Dolares_ParaCajaInfer.setVisible(false);
						lblNewLabel_Soles_ParaCajaInfer.setVisible(false);
						lblNewLabel_Euros_ParaCajaInfer.setVisible(false);
						lblNewLabel_PesoArg_ParaCajaInfe.setVisible(false);
						lblNewLabel_RealBrasileño_ParaCajaInfe.setVisible(false);
						
						textField_NI1.setText("");
						
					}else if (c1 == '.') {
						textField_NI1.setText("");
						
						e.consume();
					}
					
					else {
						lblNewLabel_aviso.setVisible(false);	
						calcularCantText2ATex1_ConversorMonedas();						
					}			
				}			
			});
		}
	
	//Metodos para conversor temperaturas.
	
	private void iniciarComponentesTemperaturas() {
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Temperaturas", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_Izquier = new JTextField();
		textField_Izquier.setBounds(10, 86, 164, 30);
		panel_1.add(textField_Izquier);
		textField_Izquier.setColumns(10);
		
		textField_Derech = new JTextField();
		textField_Derech.setBounds(190, 86, 164, 30);
		panel_1.add(textField_Derech);
		textField_Derech.setColumns(10);
		
		lblNewLabel_FahrenheitIzquier = new JLabel("Grados Fahrenheit (°F)");
		lblNewLabel_FahrenheitIzquier.setBounds(10, 69, 140, 14);
		panel_1.add(lblNewLabel_FahrenheitIzquier);
		
		lblNewLabel_CelsiusDerech = new JLabel("Grados Celsius (°C)");
		lblNewLabel_CelsiusDerech.setBounds(190, 69, 140, 14);
		panel_1.add(lblNewLabel_CelsiusDerech);
		
		comboBox_Opciones = new JComboBox();
		comboBox_Opciones.setModel(new DefaultComboBoxModel(new String[] {"Grados Fahrenheit a Grados Celsius", "Grados Fahrenheit a Kelvin", "Grados Celsius a Grados Fahrenheit", "Grados Celsius a Kelvin", "Kelvin a Fahrenheit", "Kelvin a Grados Celsius"}));
		comboBox_Opciones.setBounds(118, 21, 236, 22);
		comboBox_Opciones.addActionListener(this);	
		panel_1.add(comboBox_Opciones);
		
		lblNewLabel_3 = new JLabel("Selecione opción:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 25, 109, 14);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_kelvinIzquier = new JLabel("Kelvin");
		lblNewLabel_kelvinIzquier.setBounds(10, 69, 140, 14);
		panel_1.add(lblNewLabel_kelvinIzquier);
		
		lblNewLabel_kelvinDerech = new JLabel("Kelvin");
		lblNewLabel_kelvinDerech.setBounds(190, 69, 140, 14);
		panel_1.add(lblNewLabel_kelvinDerech);
		
		lblNewLabel_FahrenheitDerech = new JLabel("Grados Fahrenheit (°F)");
		lblNewLabel_FahrenheitDerech.setBounds(190, 69, 140, 14);
		panel_1.add(lblNewLabel_FahrenheitDerech);
		
		lblNewLabel_CelsiusIzquier = new JLabel("Grados Celsius (°C)");
		lblNewLabel_CelsiusIzquier.setBounds(10, 69, 140, 14);
		panel_1.add(lblNewLabel_CelsiusIzquier);
		
		lblNewLabel_avisoIngreseCantidad = new JLabel("INGRESE CANTIDAD (*)");
		lblNewLabel_avisoIngreseCantidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_avisoIngreseCantidad.setForeground(new Color(43, 143, 225));
		lblNewLabel_avisoIngreseCantidad.setBounds(10, 69, 164, 14);
		panel_1.add(lblNewLabel_avisoIngreseCantidad);
		
		lblNewLabel_avisoIngreseCantidad.setVisible(false);
		lblNewLabel_FahrenheitIzquier.setVisible(false);
		lblNewLabel_FahrenheitDerech.setVisible(false);		
		lblNewLabel_CelsiusIzquier.setVisible(false);
		lblNewLabel_CelsiusDerech.setVisible(false);		
		lblNewLabel_kelvinIzquier.setVisible(false);
		lblNewLabel_kelvinDerech.setVisible(false);	
		
		soloNumerosParaTemperaturas(textField_Izquier, textField_Derech);
	}
	
	public void calcularCantidadText1ATex2_ConversorTemperaturas() {
		
		while (comboBox_Opciones.getSelectedIndex() == 0) {
			 if (textField_Izquier.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Izquier.getText());
				cantidad = (cantidad -32) * 5/9;
				textField_Derech.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(true);
				lblNewLabel_CelsiusDerech.setVisible(true);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 1) {
			 if (textField_Izquier.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Izquier.getText());
				cantidad = (cantidad -32) * 5/9 + 273.15;
				textField_Derech.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(true);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(true);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 2) {
			 if (textField_Izquier.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Izquier.getText());
				cantidad = (cantidad * 9/5) + 32;
				textField_Derech.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(true);
				lblNewLabel_FahrenheitDerech.setVisible(true);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 3) {
			 if (textField_Izquier.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Izquier.getText());
				cantidad += 273.15;
				textField_Derech.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(true);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(true);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 4) {
			 if (textField_Izquier.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Izquier.getText());
				cantidad = (cantidad -273.15) * 9/5 + 32;
				textField_Derech.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(true);
				lblNewLabel_kelvinIzquier.setVisible(true);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 5) {
			 if (textField_Izquier.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Izquier.getText());
				cantidad = cantidad  -273.15;
				textField_Derech.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(true);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(true);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		
		
	}
	
	public void calcularCantidadText2ATex1_ConversorTemperaturas() {
		
		while (comboBox_Opciones.getSelectedIndex() == 0) {
			 if (textField_Derech.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Derech.getText());
				cantidad = (cantidad * 9/5) + 32;
				textField_Izquier.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(true);
				lblNewLabel_CelsiusDerech.setVisible(true);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 1) {
			 if (textField_Derech.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Derech.getText());
				cantidad = (cantidad -273.15) * 9/5 + 32;
				textField_Izquier.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(true);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(true);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 2) {
			 if (textField_Derech.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Derech.getText());
				cantidad = (cantidad -32) * 5/9;
				textField_Izquier.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(true);
				lblNewLabel_FahrenheitDerech.setVisible(true);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 3) {
			 if (textField_Derech.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Derech.getText());
				cantidad -= 273.15;
				textField_Izquier.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(true);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(false);
				lblNewLabel_kelvinDerech.setVisible(true);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 4) {
			 if (textField_Derech.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Derech.getText());
				cantidad = (cantidad -32) * 5/9 + 273.15;
				textField_Izquier.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(false);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(true);
				lblNewLabel_kelvinIzquier.setVisible(true);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
		
		while (comboBox_Opciones.getSelectedIndex() == 5) {
			 if (textField_Derech.getText().trim().isEmpty()) {						
					lblNewLabel_avisoIngreseCantidad.setVisible(true);				
			 }else {
				cantidad = Double.parseDouble(textField_Derech.getText());
				cantidad = cantidad  + 273.15;
				textField_Izquier.setText(df.format(cantidad));
				
				lblNewLabel_avisoIngreseCantidad.setVisible(false);
				lblNewLabel_FahrenheitIzquier.setVisible(false);
				lblNewLabel_CelsiusDerech.setVisible(true);
				lblNewLabel_CelsiusIzquier.setVisible(false);
				lblNewLabel_FahrenheitDerech.setVisible(false);
				lblNewLabel_kelvinIzquier.setVisible(true);
				lblNewLabel_kelvinDerech.setVisible(false);
				
			}
			break;
		}
	}
	
	public void soloNumerosParaTemperaturas(JTextField a, JTextField b) {
			a.addKeyListener(new KeyAdapter() {
				
				//**** Código para que solo ingrese numeros. No letras no 2 puntos. ('..') en 'caja de texto' superior.		
				public void keyTyped(KeyEvent e) {			
					char c = e.getKeyChar();					
					if(!Character.isDigit(c) && c != '.' && c!='-') {
						e.consume();
					}				
					if(c == '.' && textField_Izquier.getText().contains(".")) {
						e.consume();
					}
					if(c == '-' && textField_Izquier.getText().contains("-")) {
						e.consume();
					}	
				}			
				
				//*** Evento (Si ingresas texto) para la caja de texto superior.
				@Override
				public void keyReleased(KeyEvent e) {
					char c = e.getKeyChar();
					
					if(textField_Izquier.getText().trim().isEmpty()){ //Si 'caja de texto' superior esta vacio.
						
						lblNewLabel_avisoIngreseCantidad.setVisible(true);
						lblNewLabel_FahrenheitIzquier.setVisible(false);
						lblNewLabel_FahrenheitDerech.setVisible(false);
						
						lblNewLabel_CelsiusIzquier.setVisible(false);
						lblNewLabel_CelsiusDerech.setVisible(false);
						
						lblNewLabel_kelvinIzquier.setVisible(false);
						lblNewLabel_kelvinDerech.setVisible(false);	
						textField_Derech.setText("");
						
					} else if(c == '.' || c=='-') {//Si escribes un punto ('.').
						
					}else {							
						lblNewLabel_avisoIngreseCantidad.setVisible(false);			
						calcularCantidadText1ATex2_ConversorTemperaturas();								
					}
							
				}
				
				
			});
			
			//**** Código para que solo ingrese numeros. No letras, no 2 puntos. ('..') en 'caja de texto' lado izquierdo.
			b.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c1 = e.getKeyChar();
				
						if(!Character.isDigit(c1) && c1 != '.' && c1!='-') {
							e.consume();
						}
						
						if(c1 == '.' && textField_Derech.getText().contains(".")) {
							e.consume();
							
						}if(c1 == '-' && textField_Derech.getText().contains("-")) {
							e.consume();
						}	
				}			
				
				//*** Evento (Si ingresas texto) para la caja de texto lado derecho.
				@Override
				public void keyReleased(KeyEvent e) {	
					char c1 = e.getKeyChar();
					
									
					if(textField_Derech.getText().trim().isEmpty()){
						lblNewLabel_avisoIngreseCantidad.setVisible(true);
						lblNewLabel_FahrenheitIzquier.setVisible(false);
						lblNewLabel_FahrenheitDerech.setVisible(false);
						
						lblNewLabel_CelsiusIzquier.setVisible(false);
						lblNewLabel_CelsiusDerech.setVisible(false);
						
						lblNewLabel_kelvinIzquier.setVisible(false);
						lblNewLabel_kelvinDerech.setVisible(false);	
						
						textField_Izquier.setText("");
						
					}else if (c1 == '.' || c1=='-') {
						
					}
					
					else {
						lblNewLabel_avisoIngreseCantidad.setVisible(false);
						calcularCantidadText2ATex1_ConversorTemperaturas();					
					}			
				}			
			});
		}
	
	//Metodos para conversor distancias.
	
	private void iniciarComponentesDistancias() {
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Distancias", null, panel_2, null);
		panel_2.setLayout(null);
		
		comboBox_DistanciaLadoIzquier = new JComboBox();
		comboBox_DistanciaLadoIzquier.setModel(new DefaultComboBoxModel(new String[] {"Kilómetro", "Metro", "Centímetro", "Milímetro", "Milla", "Yarda", "Pie", "Pulgada"}));
		comboBox_DistanciaLadoIzquier.setBounds(10, 88, 152, 22);
		comboBox_DistanciaLadoIzquier.addActionListener(this);
		panel_2.add(comboBox_DistanciaLadoIzquier);
		
		textField_DistanciaLadoIzquier = new JTextField();
		textField_DistanciaLadoIzquier.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_DistanciaLadoIzquier.setBounds(10, 36, 152, 41);
		panel_2.add(textField_DistanciaLadoIzquier);
		textField_DistanciaLadoIzquier.setColumns(10);
		
		textField_DistanciaLadoDerech = new JTextField();
		textField_DistanciaLadoDerech.setFont(new Font("Tahoma", Font.PLAIN, 22));		
		textField_DistanciaLadoDerech.setBounds(202, 36, 152, 41);
		panel_2.add(textField_DistanciaLadoDerech);
		textField_DistanciaLadoDerech.setColumns(10);
		
		JLabel lblNewLabel_Igual = new JLabel("=");
		lblNewLabel_Igual.setForeground(new Color(128, 128, 128));
		lblNewLabel_Igual.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_Igual.setBounds(165, 36, 39, 41);
		panel_2.add(lblNewLabel_Igual);
		
		comboBox_DistanciaLadoDerech = new JComboBox();
		comboBox_DistanciaLadoDerech.setModel(new DefaultComboBoxModel(new String[] {"Kilómetro", "Metro", "Centímetro", "Milímetro", "Milla", "Yarda", "Pie", "Pulgada"}));
		comboBox_DistanciaLadoDerech.setBounds(202, 88, 152, 22);
		comboBox_DistanciaLadoDerech.addActionListener(this);
		panel_2.add(comboBox_DistanciaLadoDerech);
		
		soloNumerosParaDistancias(textField_DistanciaLadoIzquier, textField_DistanciaLadoDerech);
			
	}
	
	public void calcularCantidadText1ATex2_ConversorDistancias() {

		while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 0 ) {				
			 
			 if (textField_DistanciaLadoIzquier.getText().trim().isEmpty()) {						
									
					
			 }else {			 
					  	cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());				  	
					
					 if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {	
						 
						textField_DistanciaLadoDerech.setText(df.format(cantidad));								
							
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {
							cantidad = cantidad * 1000;
							textField_DistanciaLadoDerech.setText(df.format(cantidad));							
								
								
								
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
								cantidad = cantidad * 100000;									
								textField_DistanciaLadoDerech.setText(df.format(cantidad));						
								
								
								
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
								cantidad = cantidad * 1000000;									
								textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
								
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {	
								cantidad = cantidad / 1.609;									
								textField_DistanciaLadoDerech.setText(df.format(cantidad));						
								
						
								
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
								cantidad = cantidad * 1094;									
								textField_DistanciaLadoDerech.setText(df.format(cantidad));						
								
							
								
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
								cantidad = cantidad * 3281;									
								textField_DistanciaLadoDerech.setText(df.format(cantidad));						
								
								
							
						}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
								cantidad = cantidad * 39370;									
								textField_DistanciaLadoDerech.setText(df.format(cantidad));						
								
								
					
						}
				}
			 
				break;
		 }
		 
		 
		 while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 1) {			 
		 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
		   	 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
						
					
					if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));					
						
				
					
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
							
					
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
						 cantidad = cantidad * 100;							 
						 textField_DistanciaLadoDerech.setText(df.format(cantidad));
						 
					
						 
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
						 cantidad = cantidad * 1000;									
						 textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
							
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {	
						cantidad = cantidad / 1609;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
						
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
						cantidad = cantidad * 1.094;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
					
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
						cantidad = cantidad * 3.281;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
				
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
						cantidad = cantidad * 39.37;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
							
				}
			}			 
				break;
		}
		 
		 while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 2) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			 }else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
					
					cantidad = cantidad / 100000;										
					textField_DistanciaLadoDerech.setText(df.format(cantidad));	
					
				
					
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
						cantidad = cantidad / 100;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {						 
					textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
						cantidad = cantidad * 10;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
					
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {	
						cantidad = cantidad / 160900;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
						cantidad = cantidad / 91.44;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
						cantidad = cantidad / 30.48;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
					
				
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
						cantidad = cantidad / 2.54;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
				}
			}
				break;
		}
		 
		 	while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 3) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			 }else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
					
					cantidad = cantidad * 1000000;										
					textField_DistanciaLadoDerech.setText(df.format(cantidad));	
					
					
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
						cantidad = cantidad /1000;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
						cantidad = cantidad / 10;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {															
					textField_DistanciaLadoDerech.setText(df.format(cantidad));						
					
					
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {	
						cantidad = cantidad / 1609000;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
						
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
						cantidad = cantidad / 914.4;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
				
					
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
						cantidad = cantidad / 304.8;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
					
				
				}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
						cantidad = cantidad / 25.4;									
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
		
				}
			}
				break;
		}
		 	
		 	while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 4) {
				 
				 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
						
					if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
						
						cantidad = cantidad * 1.609;										
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
						
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
							cantidad = cantidad * 1609;						
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
							
					
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
							cantidad = cantidad * 160900;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
					
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
							cantidad = (cantidad * 1.609) + 6;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {																
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
							cantidad = cantidad * 1760;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
				
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
							cantidad = cantidad * 5280;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
							cantidad = cantidad * 63360;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
				
				
					}
				}
					break;
			}
		 	
		 	while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 5) {
				 
				 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
						
					if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
						
						cantidad = cantidad / 1094;										
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
				
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
							cantidad = cantidad / 1.094;						
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
							
				
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
							cantidad = cantidad * 91.44;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
							cantidad = cantidad * 914.4;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {		
						cantidad = cantidad / 1760;
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
															
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
							cantidad = cantidad * 3;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
					
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
							cantidad = cantidad * 36;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
							
				
					}
				}
					break;
			}
		 	
		 	while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 6) {
				 
				 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
					
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
						
					if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
						
						cantidad = cantidad / 3281;										
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
					
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
							cantidad = cantidad /3.281;						
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
							
							
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
							cantidad = cantidad * 30.48;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
							cantidad = cantidad * 304.8;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {	
						cantidad = cantidad / 5280;
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
							cantidad = cantidad / 3;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {																
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {	
							cantidad = cantidad * 12;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
				
					}
				}
					break;
			}
		 	
		 	while (comboBox_DistanciaLadoIzquier.getSelectedIndex() == 7) {
				 
				 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
					 
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
						
					if(comboBox_DistanciaLadoDerech.getSelectedIndex()==0) {
						
						cantidad = cantidad / 39370;										
						textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
					
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==1) {	
							cantidad = cantidad / 39.37;						
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==2) {	
							cantidad = cantidad * 2.54;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==3) {	
							cantidad = cantidad * 25.4;	
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
						
						
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==4) {	
						cantidad = cantidad / 63360;
						textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==5) {	
							cantidad = cantidad / 36;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
					
							
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==6) {	
							cantidad = cantidad / 12;									
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
					
					
					}else if(comboBox_DistanciaLadoDerech.getSelectedIndex()==7) {																
							textField_DistanciaLadoDerech.setText(df.format(cantidad));						
							
					
				
					}
				}
					break;
			}
		 
//______________________________________________________________________________________________//
		 
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 0) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
							 
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
				
									
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
					cantidad = cantidad / 1000;
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {						
						cantidad = cantidad / 100000;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = (cantidad / 1000000);	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {						
						cantidad = cantidad * 1.609;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
				
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad / 1094;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad / 3281;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad / 39370;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
						
				}
			}
				break;
		}	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 1) {
			
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 1000;
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
											
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
				
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
					 	cantidad = cantidad / 100;					 	
					 	textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad / 1000;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {						
						cantidad = cantidad * 1609;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad / 1.094;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad / 3.281;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad / 39.37;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
					
				}
			}
				break;
		}	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 2) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
			
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 100000;					
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad * 100;							
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
				
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {						 
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad / 10;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {						
						cantidad = cantidad * 160900;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad * 91.44;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad * 30.48;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad * 2.54;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
				}
			}
				break;
		} 	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 3) {
				
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 1000000;	
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad * 1000;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
						
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
					 	cantidad = cantidad * 10;					 	
					 	textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {							
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {						
						cantidad = cantidad * 1609000;				
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad * 914.4;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad * 304.8;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad * 25.4;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				}
			}
				break;
		}	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 4) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				 
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad / 1.609;					
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad / 1609;							
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {		
						cantidad = cantidad / 160900;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad / 1.609000000;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
						
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {												
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad / 1760;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad / 5280;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad / 63360;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
				}
			}
				break;
		} 	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 5) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 1094;					
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad * 1.094;							
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {		
						cantidad = cantidad / 91.44;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
				
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad / 914.4;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
					cantidad = cantidad * 1760;
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
			
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
											
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad / 3;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad / 36;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
					
				}
			}
				break;
		} 	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 6) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 3281;					
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad * 3.281;							
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {		
						cantidad = cantidad / 30.48;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
				
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad / 304.8;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
					cantidad = cantidad * 5280;
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad * 3;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {												
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
				
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {						
						cantidad = cantidad / 12;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
					
				}
			}
				break;
		} 	
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 7) {
			 
			 if (textField_DistanciaLadoIzquier.getText().isEmpty()) {
				
				 
			}else {
					cantidad = Double.parseDouble(textField_DistanciaLadoIzquier.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 39370;					
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad * 39.37;							
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {		
						cantidad = cantidad / 2.54;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad / 25.4;	
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
			
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
					cantidad = cantidad * 63360;
					textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {						
						cantidad = cantidad * 36;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {						
						cantidad = cantidad * 12;						
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
						
				
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {															
						textField_DistanciaLadoDerech.setText(df.format(cantidad));
					
					
				}
			}
				break;
		} 	
	
	}
	
	public void calcularCantidadText2ATex1_ConversorDistancias() {

		while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 0 ) {				
			 
			 if (textField_DistanciaLadoDerech.getText().trim().isEmpty()) {						
									
					
			 }else {			 
					  	cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());				  	
					
					 if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {	
						 
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));								
							
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {
							cantidad = cantidad * 1000;
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));							
								
								
								
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
								cantidad = cantidad * 100000;									
								textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
								
								
								
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
								cantidad = cantidad * 1000000;									
								textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
								
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
								cantidad = cantidad / 1.609;									
								textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
								
						
								
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
								cantidad = cantidad * 1094;									
								textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
								
							
								
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
								cantidad = cantidad * 3281;									
								textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
								
								
							
						}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
								cantidad = cantidad * 39370;									
								textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
								
								
					
						}
				}
			 
				break;
		 }
		 
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 1) {			 
		 
			 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
				
				 
		   	 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
						
					
					if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
						cantidad = cantidad / 1000;
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));					
						
				
					
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
										
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));
							
					
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
						 cantidad = cantidad * 100;							 
						 textField_DistanciaLadoIzquier.setText(df.format(cantidad));
						 
					
						 
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						 cantidad = cantidad * 1000;									
						 textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
							
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
						cantidad = cantidad / 1609;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
						
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
						cantidad = cantidad * 1.094;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
						cantidad = cantidad * 3.281;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
						cantidad = cantidad * 39.37;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
							
				}
			}			 
				break;
		}
		 
		 while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 2) {
			 
			 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
				
				 
			 }else {
					cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad / 100000;										
					textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
					
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad / 100;						
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {						 
					textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
						cantidad = cantidad * 10;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
						cantidad = cantidad / 160900;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
						cantidad = cantidad / 91.44;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
						cantidad = cantidad / 30.48;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
						cantidad = cantidad / 2.54;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
				}
			}
				break;
		}
		 
		 	while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 3) {
			 
			 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
				
				 
			 }else {
					cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
					
				if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
					
					cantidad = cantidad * 1000000;										
					textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
						cantidad = cantidad /1000;						
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
						cantidad = cantidad / 10;	
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {															
					textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
					
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
						cantidad = cantidad / 1609000;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
						
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
						cantidad = cantidad / 914.4;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
				
					
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
						cantidad = cantidad / 304.8;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
					
				
				}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
						cantidad = cantidad / 25.4;									
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));							
		
				}
			}
				break;
		}
		 	
		 	while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 4) {
				 
				 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
				
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
						
					if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
						
						cantidad = cantidad * 1.609;										
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
						
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
							cantidad = cantidad * 1609;						
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
							
					
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
							cantidad = cantidad * 160900;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
					
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
							cantidad = (cantidad * 1.609) + 6;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {																
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
							cantidad = cantidad * 1760;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
				
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
							cantidad = cantidad * 5280;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
							cantidad = cantidad * 63360;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
				
				
					}
				}
					break;
			}
		 	
		 	while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 5) {
				 
				 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
				
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
						
					if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
						
						cantidad = cantidad / 1094;										
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));					
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
							cantidad = cantidad / 1.094;						
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
							
				
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
							cantidad = cantidad * 91.44;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
							cantidad = cantidad * 914.4;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {		
						cantidad = cantidad / 1760;
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
															
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
							cantidad = cantidad * 3;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
					
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
							cantidad = cantidad * 36;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
							
				
					}
				}
					break;
			}
		 	
		 	while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 6) {
				 
				 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
					
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
						
					if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
						
						cantidad = cantidad / 3281;										
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
					
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
							cantidad = cantidad /3.281;						
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
							
							
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
							cantidad = cantidad * 30.48;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
							cantidad = cantidad * 304.8;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
						cantidad = cantidad / 5280;
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
							cantidad = cantidad / 3;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {																
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {	
							cantidad = cantidad * 12;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
				
					}
				}
					break;
			}
		 	
		 	while (comboBox_DistanciaLadoDerech.getSelectedIndex() == 7) {
				 
				 if (textField_DistanciaLadoDerech.getText().isEmpty()) {
					 
					 
				 }else {
						cantidad = Double.parseDouble(textField_DistanciaLadoDerech.getText());	
						
					if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==0) {
						
						cantidad = cantidad / 39370;										
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
					
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==1) {	
							cantidad = cantidad / 39.37;						
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==2) {	
							cantidad = cantidad * 2.54;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));	
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==3) {	
							cantidad = cantidad * 25.4;	
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
						
						
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==4) {	
						cantidad = cantidad / 63360;
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
						
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==5) {	
							cantidad = cantidad / 36;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
					
							
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==6) {	
							cantidad = cantidad / 12;									
							textField_DistanciaLadoIzquier.setText(df.format(cantidad));						
							
					
					
					}else if(comboBox_DistanciaLadoIzquier.getSelectedIndex()==7) {																
						textField_DistanciaLadoIzquier.setText(df.format(cantidad));				
				
					}
				}
					break;
			}
//_______________________________
		
		 	
		 	
	}
	
	
	public void soloNumerosParaDistancias(JTextField a, JTextField b) {
		a.addKeyListener(new KeyAdapter() {
			
			//**** Código para que solo ingrese numeros. No letras no 2 puntos. ('..') en 'caja de texto' superior.		
			public void keyTyped(KeyEvent e) {			
				char c = e.getKeyChar();					
				if(!Character.isDigit(c) && c != '.' && c!='-') {
					e.consume();
				}				
				if(c == '.' && textField_DistanciaLadoIzquier.getText().contains(".")) {
					e.consume();
				}
				if(c == '-' && textField_DistanciaLadoIzquier.getText().contains("-")) {
					e.consume();
				}	
			}			
			
			//*** Evento (Si ingresas texto) para la caja de texto superior.
			@Override
			public void keyReleased(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(textField_DistanciaLadoIzquier.getText().trim().isEmpty()){ //Si 'caja de texto' superior esta vacio.
					
					lblNewLabel_avisoIngreseCantidad.setVisible(true);
					lblNewLabel_FahrenheitIzquier.setVisible(false);
					lblNewLabel_FahrenheitDerech.setVisible(false);
					
					lblNewLabel_CelsiusIzquier.setVisible(false);
					lblNewLabel_CelsiusDerech.setVisible(false);
					
					lblNewLabel_kelvinIzquier.setVisible(false);
					lblNewLabel_kelvinDerech.setVisible(false);	
					textField_DistanciaLadoDerech.setText("");
					
				} else if(c == '.' || c=='-') {//Si escribes un punto ('.').
					
				}else {							
					lblNewLabel_avisoIngreseCantidad.setVisible(false);			
					calcularCantidadText1ATex2_ConversorDistancias();								
				}
						
			}			
			
		});
		
		//**** Código para que solo ingrese numeros. No letras, no 2 puntos. ('..') en 'caja de texto' lado izquierdo.
		b.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c1 = e.getKeyChar();
			
					if(!Character.isDigit(c1) && c1 != '.' && c1!='-') {
						e.consume();
					}
					
					if(c1 == '.' && textField_DistanciaLadoDerech.getText().contains(".")) {
						e.consume();
						
					}if(c1 == '-' && textField_DistanciaLadoDerech.getText().contains("-")) {
						e.consume();
					}	
			}			
			
			//*** Evento (Si ingresas texto) para la caja de texto lado derecho.
			@Override
			public void keyReleased(KeyEvent e) {	
				char c1 = e.getKeyChar();
				
								
				if(textField_DistanciaLadoDerech.getText().trim().isEmpty()){
					lblNewLabel_avisoIngreseCantidad.setVisible(true);
					lblNewLabel_FahrenheitIzquier.setVisible(false);
					lblNewLabel_FahrenheitDerech.setVisible(false);
					
					lblNewLabel_CelsiusIzquier.setVisible(false);
					lblNewLabel_CelsiusDerech.setVisible(false);
					
					lblNewLabel_kelvinIzquier.setVisible(false);
					lblNewLabel_kelvinDerech.setVisible(false);	
					
					textField_DistanciaLadoIzquier.setText("");
					
				}else if (c1 == '.' || c1=='-') {
					
				}
				
				else {
					lblNewLabel_avisoIngreseCantidad.setVisible(false);
					calcularCantidadText2ATex1_ConversorDistancias();				
				}			
			}			
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
			calcularCantidadText1ATex2_ConversorMonedas();
			calcularCantidadText1ATex2_ConversorTemperaturas();
			calcularCantidadText1ATex2_ConversorDistancias();
			
			
		}
	}
