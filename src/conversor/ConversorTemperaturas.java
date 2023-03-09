package conversor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ConversorTemperaturas extends JFrame implements ActionListener {
	    
	private JLabel lblTitulo, lblGrados, lblResultado;
	    private JTextField txtGrados, txtResultado;
	    private JComboBox<String> cmbDesde, cmbHasta;
	    private JButton btnConvertir, btnVolver;
	    private JLabel lblNewLabel;

	    public ConversorTemperaturas() {
	        setTitle("Conversor de Temperatura");
	        setSize(300, 255);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        lblTitulo = new JLabel("Conversor de Temperatura");
	        lblTitulo.setBounds(70, 20, 160, 20);
	        getContentPane().add(lblTitulo);

	        lblGrados = new JLabel("Grados:");
	        lblGrados.setBounds(20, 60, 100, 20);
	        getContentPane().add(lblGrados);

	        txtGrados = new JTextField();
	        txtGrados.setBounds(130, 60, 100, 20);
	        getContentPane().add(txtGrados);

	        lblResultado = new JLabel("Resultado:");
	        lblResultado.setBounds(20, 90, 100, 20);
	        getContentPane().add(lblResultado);

	        txtResultado = new JTextField();
	        txtResultado.setBounds(130, 90, 100, 20);
	        txtResultado.setEditable(false);
	        getContentPane().add(txtResultado);

	        cmbDesde = new JComboBox<String>(new String[] {"Celsius", "Fahrenheit"});
	        cmbDesde.setBounds(20, 130, 110, 20);
	        getContentPane().add(cmbDesde);

	        cmbHasta = new JComboBox<String>(new String[] {"Fahrenheit", "Celsius"});
	        cmbHasta.setBounds(140, 130, 120, 20);
	        getContentPane().add(cmbHasta);

	        btnConvertir = new JButton("Convertir");
	        btnConvertir.setBounds(20, 175, 112, 30);
	        btnConvertir.addActionListener(this);
	        getContentPane().add(btnConvertir);

	        btnVolver = new JButton("Volver");
	        btnVolver.setBounds(142, 175, 118, 30);
	        btnVolver.addActionListener(this);
	        getContentPane().add(btnVolver);
	        
	        lblNewLabel = new JLabel("");
	        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanc\\Downloads\\conversor-temperatura.png"));
	        lblNewLabel.setBounds(0, 0, 284, 216);
	        getContentPane().add(lblNewLabel);
	    }

	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == btnConvertir) {
	            try {
	                double grados = Double.parseDouble(txtGrados.getText());
	                String desde = cmbDesde.getSelectedItem().toString();
	                String hasta = cmbHasta.getSelectedItem().toString();
	                double resultado = 0;

	                if (desde.equals("Celsius") && hasta.equals("Fahrenheit")) {
	                    resultado = (grados * 1.8) + 32;
	                } else if (desde.equals("Fahrenheit") && hasta.equals("Celsius")) {
	                    resultado = (grados - 32) / 1.8;
	                }

	                txtResultado.setText(String.format("%.2f", resultado));
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para los grados.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } else if (e.getSource() == btnVolver) {
	            ViewConvectorMoney conversor = new ViewConvectorMoney();
	            conversor.setVisible(true);
	            this.dispose();
	        }
	    }
}