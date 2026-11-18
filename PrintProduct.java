package mattresssalesreport;

public class PrintProduct {

    public void PrintTotalSales(Product product) {

        System.out.println(
                "TOTAL PRODUCT SALES: "
                + product.GetTotalProductsSold()
        );
    }

    public void PrintAverageSales(Product product) {

        System.out.println(
                "AVERAGE PRODUCT SALES: "
                + product.GetAverageProductsSold()
        );
    }

    public void PrintMostPopularProduct(Product product) {

        System.out.println(
                "MOST POPULAR PRODUCT: "
                + product.GetMostPopularProduct()
        );
    }

    public void PrintReport(Product product) {

        System.out.println("\nPRODUCT SALES REPORT - 2026");

        System.out.println(
                "****************************************"
        );

        PrintTotalSales(product);

        PrintAverageSales(product);

        PrintMostPopularProduct(product);
    }
}
