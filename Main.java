package mattresssalesreport;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Single-dimensional array
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array
        int[][] monthlySales = new int[3][3];

        // Enter sales information
        for (int i = 0; i < productNames.length; i++) {

            for (int j = 0; j < 3; j++) {

                int sales;

                do {
                    System.out.print(
                        "Enter number of sales for month "
                        + (j + 1) + " for "
                        + productNames[i] + ": "
                    );

                    while (!input.hasNextInt()) {
                        System.out.println(
                            "Please enter a valid whole number."
                        );
                        input.next();
                    }

                    sales = input.nextInt();

                    if (sales < 0) {
                        System.out.println(
                            "Sales cannot be negative."
                        );
                    }

                } while (sales < 0);

                monthlySales[i][j] = sales;
            }
        }

        // Create Product object
        Product product = new Product(
                productNames, monthlySales
        );

        // Create PrintProduct object
        PrintProduct report = new PrintProduct();

        // Display report
        report.PrintReport(product);

        input.close();
    }
}
