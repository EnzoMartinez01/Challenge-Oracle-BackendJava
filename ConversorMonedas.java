import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorMonedas extends JFrame {
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;

    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_JPY = 110.30;
    private static final double USD_TO_GBP = 0.73;
    private static final double USD_TO_PEN = 4.09;
    private static final double USD_TO_MXN = 19.90;
    private static final double USD_TO_COP = 3794.80;

    public ConversorMonedas() {
        setTitle("Convertidor de monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setLayout(new GridLayout(3, 2));

        // Etiqueta y campo de texto para la cantidad a convertir
        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();
        topPanel.add(amountLabel);
        topPanel.add(amountTextField);

        // ComboBox para la moneda de origen
        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(getCurrencyList());
        topPanel.add(fromCurrencyLabel);
        topPanel.add(fromCurrencyComboBox);

        // ComboBox para la moneda de destino
        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(getCurrencyList());
        topPanel.add(toCurrencyLabel);
        topPanel.add(toCurrencyComboBox);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel();
        centerPanel.add(resultLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        bottomPanel.add(convertButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private String[] getCurrencyList() {
        return new String[]{"USD", "EUR", "JPY", "GBP", "PEN", "MXN", "COP"};
    }

    private void convertCurrency() {
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        double amount = Double.parseDouble(amountTextField.getText());

        double convertedAmount = 0.0;

        switch (fromCurrency) {
            case "USD":
                switch (toCurrency) {
                    case "EUR":
                        convertedAmount = amount * USD_TO_EUR;
                        break;
                    case "JPY":
                        convertedAmount = amount * USD_TO_JPY;
                        break;
                    case "GBP":
                        convertedAmount = amount * USD_TO_GBP;
                        break;
                    case "PEN":
                        convertedAmount = amount * USD_TO_PEN;
                        break;
                    case "MXN":
                        convertedAmount = amount * USD_TO_MXN;
                        break;
                    case "COP":
                        convertedAmount = amount * USD_TO_COP;
                        break;
                }
                break;
            case "EUR":
                // Agregar conversiones de EUR a otras monedas si es necesario
                break;
            case "JPY":
                // Agregar conversiones de JPY a otras monedas si es necesario
                break;
            case "GBP":
                // Agregar conversiones de GBP a otras monedas si es necesario
                break;
            case "PEN":
                // Agregar conversiones de PEN a otras monedas si es necesario
                break;
            case "MXN":
                // Agregar conversiones de MXN a otras monedas si es necesario
                break;
            case "COP":
                // Agregar conversiones de COP a otras monedas si es necesario
                break;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        resultLabel.setText(decimalFormat.format(amount) + " " + fromCurrency + " = "
                + decimalFormat.format(convertedAmount) + " " + toCurrency);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConversorMonedas currencyConverter = new ConversorMonedas();
                currencyConverter.setVisible(true);
            }
        });
    }
}