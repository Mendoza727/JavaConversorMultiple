package conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class ViewConvectorMoney extends JFrame implements ActionListener {
    
	private JComboBox<String> cmbConversor;
    private JButton btnAceptar;

    public ViewConvectorMoney() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juanc\\Downloads\\descarga.png"));
        setTitle("Challeger Java Conversor");
        setSize(300, 184);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Seleccione el tipo de conversor:");
        lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 10));
        lblTitulo.setForeground(new Color(0, 0, 255));
        lblTitulo.setBounds(44, 25, 230, 20);
        getContentPane().add(lblTitulo);

        String[] JComboBoxOptions = {"Conversor de Moneda", "Conversor de Temperatura"};
        cmbConversor = new JComboBox<>(JComboBoxOptions);
        cmbConversor.setBounds(21, 50, 253, 30);
        getContentPane().add(cmbConversor);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(100, 100, 100, 30);
        btnAceptar.addActionListener(this);
        getContentPane().add(btnAceptar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            int seleccion = cmbConversor.getSelectedIndex();

            if (seleccion == 0) {
      
            	//Logica Aparte ConversorTemperatura
                ConversorMonedas conversorMoneda = new ConversorMonedas();
                conversorMoneda.setVisible(true);
                this.dispose();
                
            } else if (seleccion == 1) {

            	//Logica Aparte ConversorTemperatura
                ConversorTemperaturas conversorTemperatura = new ConversorTemperaturas();
                conversorTemperatura.setVisible(true);
                this.dispose();
                
            }
        }
    }

    public static void main(String[] args) {
        ViewConvectorMoney conversorJFrameView = new ViewConvectorMoney();
        conversorJFrameView.setVisible(true);
    }
}

                 