package conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class ConversorMonedas extends JFrame implements ActionListener {

    private JLabel valorMonedalbl, monedaOrigen, monedaExtranjera, lblResultadoMoneda;
    private JTextField valorInputField, valorInputResultadoField;
    private JComboBox<String> monedaLocal, monedaExt;
    private JButton convertButton, btnVolver;
    private JLabel lblNewLabel;

    public ConversorMonedas() {
        setTitle("Currency Converter");
        setSize(312, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        valorMonedalbl = new JLabel("Valor:");
        valorMonedalbl.setBounds(10, 27, 187, 44);
        monedaOrigen = new JLabel("Moneda Origen:");
        monedaOrigen.setBounds(10, 63, 187, 44);
        monedaExtranjera = new JLabel("Moneda Extranjera:");
        monedaExtranjera.setBounds(10, 108, 187, 44);
        lblResultadoMoneda = new JLabel("Resultado:");
        lblResultadoMoneda.setBounds(10, 154, 121, 44);
        valorInputField = new JTextField();
        valorInputField.setBounds(57, 37, 203, 25);
        valorInputResultadoField = new JTextField();
        valorInputResultadoField.setBounds(73, 164, 187, 25);
        valorInputResultadoField.setEditable(false);
        monedaLocal = new JComboBox<String>(new String[] {"COP", "USD", "EUR", "JPY", "GBP", "KRW"});
        monedaLocal.setBounds(117, 73, 169, 25);
        monedaExt = new JComboBox<String>(new String[] {"KRW", "GBP", "JPY", "EUR", "USD", "COP"});
        monedaExt.setBounds(138, 118, 148, 25);
        convertButton = new JButton("Convertir");
        convertButton.setBounds(134, 200, 126, 44);
        convertButton.addActionListener(this);
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(10, 200, 116, 45);
        btnVolver.addActionListener(this);
        getContentPane().setLayout(null);
        getContentPane().add(valorMonedalbl);
        getContentPane().add(valorInputField);
        getContentPane().add(monedaOrigen);
        getContentPane().add(monedaLocal);
        getContentPane().add(monedaExtranjera);
        getContentPane().add(monedaExt);
        getContentPane().add(lblResultadoMoneda);
        getContentPane().add(valorInputResultadoField);
        getContentPane().add(convertButton);
        getContentPane().add(btnVolver);
        
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanc\\Downloads\\exchange.png"));
        lblNewLabel.setBounds(0, 0, 270, 261);
        getContentPane().add(lblNewLabel);
    }

    public static double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        double exchangeRate = 0.0;
        switch (fromCurrency) {
        	case "COP": 
        		if (toCurrency.equals("COP")) {
        			exchangeRate = 1.0;
        		} else if (toCurrency.equals("USD")) {
                    exchangeRate = 1.0;
                } else if (toCurrency.equals("EUR")) {
                    exchangeRate = 0.94;
                } else if (toCurrency.equals("GBP")) {
                    exchangeRate = 0.84;
                } else if (toCurrency.equals("JPY")) {
                    exchangeRate = 137.17;
                } else if (toCurrency.equals("KRW")) {
                	exchangeRate = 1317.02;
                }
                break;
            case "USD":
                if (toCurrency.equals("USD")) {
                    exchangeRate = 1.0;
                } else if (toCurrency.equals("EUR")) {
                    exchangeRate = 0.94;
                } else if (toCurrency.equals("GBP")) {
                    exchangeRate = 0.84;
                } else if (toCurrency.equals("JPY")) {
                    exchangeRate = 137.17;
                } else if (toCurrency.equals("COP")) {
                	exchangeRate = 4741.8;
                } else if (toCurrency.equals("KRW")) {
                	exchangeRate = 1317.02;
                }
                break;
            case "EUR":
            	if (toCurrency.equals("USD")) {
                    exchangeRate = 1.0;
                } else if (toCurrency.equals("GBP")) {
                    exchangeRate = 0.84;
                } else if (toCurrency.equals("JPY")) {
                    exchangeRate = 137.17;
                } else if (toCurrency.equals("COP")) {
                	exchangeRate = 4741.8;
                } else if (toCurrency.equals("KRW")) {
                	exchangeRate = 1317.02;
                }
                break;
            case "GBP":
            	if (toCurrency.equals("USD")) {
                    exchangeRate = 1.0;
                } else if (toCurrency.equals("EUR")) {
                    exchangeRate = 0.94;
                } else if (toCurrency.equals("JPY")) {
                    exchangeRate = 137.17;
                } else if (toCurrency.equals("COP")) {
                	exchangeRate = 4741.8;
                } else if (toCurrency.equals("KRW")) {
                	exchangeRate = 1317.02;
                }
                break;
            case "JPY":
            	if (toCurrency.equals("USD")) {
                    exchangeRate = 1.0;
                } else if (toCurrency.equals("EUR")) {
                    exchangeRate = 0.94;
                } else if (toCurrency.equals("GBP")) {
                    exchangeRate = 0.84;
                } else if (toCurrency.equals("COP")) {
                	exchangeRate = 4741.8;
                } else if (toCurrency.equals("KRW")) {
                	exchangeRate = 1317.02;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid valor");
        }
        return exchangeRate;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    if (e.getSource() == convertButton) {
        try {
            String fromCurrency = (String) monedaLocal.getSelectedItem();
            String toCurrency = (String) monedaExt.getSelectedItem();
            double amount = Double.parseDouble(valorInputField.getText());
            double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
            double result = amount * exchangeRate;
            DecimalFormat df = new DecimalFormat("#.##");
            valorInputResultadoField.setText(df.format(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Moneda Invalida", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error obteniendo la tasa de cambio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (e.getSource() == btnVolver) {
        ViewConvectorMoney conversor = new ViewConvectorMoney();
        conversor.setVisible(true);
        this.dispose();
    }
}

    public static void main(String[] args) {
    	new ConversorMonedas();
    }
}