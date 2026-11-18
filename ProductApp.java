
package mattresssalesgui;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;

    public ProductApp() {

        // Window settings
        setTitle("Product App");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Create form panel
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 20));

        panel.setBorder(
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        );

        // Customer name
        panel.add(new JLabel("Customer Name:"));

        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        // Product selection
        panel.add(new JLabel("Select Product:"));

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        // Product price
        panel.add(new JLabel("Enter Price:"));

        txtPrice = new JTextField();
        panel.add(txtPrice);

        // Process button
        JButton btnProcess = new JButton("PROCESS");
        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);

        // Button actions
        btnProcess.addActionListener(e -> processSale());

        processItem.addActionListener(e -> processSale());

        clearItem.addActionListener(e -> clearForm());

        exitItem.addActionListener(e -> System.exit(0));
    }

    // Process the sale
    private void processSale() {

        String customerName = txtCustomerName.getText().trim();

        String selectedProduct =
                (String) cmbProduct.getSelectedItem();

        String priceText = txtPrice.getText().trim();

        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter the customer name."
            );

            return;
        }

        if (priceText.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter the product price."
            );

            return;
        }

        try {

            double price = Double.parseDouble(priceText);

            if (price <= 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a price greater than zero."
                );
                return;
            }

            // Create calculation object
            ProductCalculations calculation =
                    new ProductCalculations(price);

            double vat = calculation.GetVat();

            double commission = calculation.GetCommission();

            double total = calculation.GetTotal();

            // Display results
            String message =
                    "Customer Name: " + customerName
                    + "\nProduct: " + selectedProduct
                    + "\nVAT: R " + String.format("%.2f", vat)
                    + "\nCOMMISSION: R "
                    + String.format("%.2f", commission)
                    + "\nTOTAL: R "
                    + String.format("%.2f", total);

            JOptionPane.showMessageDialog(
                this,
                message,
                "Sale Information",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Save information to data.txt
            saveToFile(
                customerName,
                selectedProduct,
                vat,
                commission,
                total
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid numeric price."
            );
        }
    }

    // Save sale information to file
    private void saveToFile(
            String customerName,
            String product,
            double vat,
            double commission,
            double total) {

        try (FileWriter writer =
                new FileWriter("data.txt", true)) {

            writer.write("DATA LOG\n");
            writer.write("********************************\n");

            writer.write("Customer Name: "
                    + customerName + "\n");

            writer.write("Product: " + product + "\n");

            writer.write("VAT: R "
                    + String.format("%.2f", vat) + "\n");

            writer.write("COMMISSION: R "
                    + String.format("%.2f", commission) + "\n");

            writer.write("TOTAL: R "
                    + String.format("%.2f", total) + "\n");

            writer.write("********************************\n\n");

            JOptionPane.showMessageDialog(
                this,
                "Sale information saved to data.txt"
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Error saving the file: " + ex.getMessage()
            );
        }
    }

    // Clear form fields
    private void clearForm() {

        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);

    }
}
