package mattresssalesreport;

public class Product implements IProduct {

    // Single-dimensional array for product names
    private String[] productNames;

    // Two-dimensional array for monthly sales
    private int[][] monthlySales;

    // Constructor
    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    // Calculate total products sold
    public int GetTotalProductsSold() {

        int total = 0;

        for (int i = 0; i < monthlySales.length; i++) {

            for (int j = 0; j < monthlySales[i].length; j++) {

                total += monthlySales[i][j];
            }
        }

        return total;
    }

    // Calculate average products sold
    public double GetAverageProductsSold() {

        int total = GetTotalProductsSold();

        int numberOfSales =
                productNames.length * monthlySales[0].length;

        return (double) total / numberOfSales;
    }

    // Find the most popular product
    public String GetMostPopularProduct() {

        int highestSales = 0;
        String popularProduct = "";

        for (int i = 0; i < productNames.length; i++) {

            int productTotal = 0;

            for (int j = 0; j < monthlySales[i].length; j++) {

                productTotal += monthlySales[i][j];
            }

            if (productTotal > highestSales) {

                highestSales = productTotal;
                popularProduct = productNames[i];
            }
        }

        return popularProduct;
    }
}
