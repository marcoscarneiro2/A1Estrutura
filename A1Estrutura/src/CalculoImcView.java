import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CalculoImcView extends JFrame {
	ArrayList<Atleta> ListaAlt;
	private JPanel contentPane;
	private JTextField c_nome= new JTextField();
	private JTable tblAtleta;
	private JTextField c_peso = new JTextField();
	private JTextField c_altura = new JTextField();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoImcView frame = new CalculoImcView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void LoadTable() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Nome", "Peso","Altura","IMC","Categoria" }, 0);
		tblAtleta.setModel(modelo);

		for (int i = 0; i < ListaAlt.size(); i++) {
			Object linha[] = new Object[] { ListaAlt.get(i).getNome(),
											ListaAlt.get(i).getPeso(),
											ListaAlt.get(i).getAltura(),
											ListaAlt.get(i).getImc(),
											ListaAlt.get(i).getCategoria()};
			modelo.addRow(linha);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public CalculoImcView() {
		ListaAlt = new ArrayList();
		setForeground(Color.WHITE);
		setTitle("Calculo IMC");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowText);
		panel.setBounds(0, 0, 566, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		c_nome = new JTextField();
		c_nome.setBounds(148, 240, 330, 20);
		panel.add(c_nome);
		c_nome.setColumns(10);
		
		tblAtleta = new JTable();
		tblAtleta.setShowVerticalLines(false);
		tblAtleta.setForeground(new Color(255, 255, 255));
		tblAtleta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Nome", "Peso", "Altura", "IMC", "Categoria"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblAtleta.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblAtleta.getColumnModel().getColumn(1).setPreferredWidth(40);
		tblAtleta.getColumnModel().getColumn(2).setPreferredWidth(40);
		tblAtleta.getColumnModel().getColumn(3).setPreferredWidth(40);
		tblAtleta.getColumnModel().getColumn(4).setPreferredWidth(190);
		tblAtleta.getColumnModel().getColumn(4).setMinWidth(0);
		tblAtleta.setBackground(new Color(0, 0, 0));
		tblAtleta.setBounds(10, 38, 546, 160);
		panel.add(tblAtleta);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(29, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Peso");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(118, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Altura");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(218, 11, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("IMC");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(337, 11, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(449, 11, 58, 14);
		panel.add(lblNewLabel_4);
		
		c_peso = new JTextField();
		c_peso.setBounds(148, 278, 86, 20);
		panel.add(c_peso);
		c_peso.setColumns(10);
		
		c_altura = new JTextField();
		c_altura.setBounds(148, 309, 86, 20);
		panel.add(c_altura);
		c_altura.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atleta A= new Atleta(); 
				A.setNome(c_nome.getText());
				A.setPeso(Double.parseDouble(c_peso.getText()));
				
				A.setAltura(Double.parseDouble(c_altura.getText()));
				DecimalFormat formato = new DecimalFormat("#,##");      
				
				ListaAlt.add(A);				
				
				A.imc = A.peso / (A.altura * A.altura); 		
				
				A.imc = Double.valueOf(formato.format(A.imc));
				
				c_nome.setText("");
				c_peso.setText("");
				c_altura.setText("");
				
	
				if (A.imc <= 18.4) {
						A.setCategoria("Abaixo do peso");
				    }else if ((A.imc >= 18.5) && (A.imc <= 24.9)) {
				    	
				    	A.setCategoria("Peso normal");
				        
				    }else if ((A.imc >= 25) && (A.imc <= 29.9)){
				    	
				    	A.setCategoria("Sobrepeso");
				         
				    }else if ((A.imc >= 30) && (A.imc <= 34.9)){
				    	
				    	A.setCategoria("Obesidade grau I");
				         
				    }else if ((A.imc >= 35) && (A.imc <= 39.9)){
				    	
				    	A.setCategoria("Obesidade grau II");
				         
				    }else { 
				    	
				    	A.setCategoria("Obesidade grau III");
				        
				    }
				
				
				LoadTable();
			}
		});
		btnCalcular.setForeground(new Color(255, 255, 255));
		btnCalcular.setBackground(new Color(46, 139, 87));
		btnCalcular.setBounds(148, 348, 170, 23);
		panel.add(btnCalcular);
		
		JLabel lblNewLabel_5 = new JLabel("Nome");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(89, 240, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Peso");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(92, 281, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Altura");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(90, 309, 46, 14);
		panel.add(lblNewLabel_7);
	}
}
