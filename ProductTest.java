package mattresssalesreport;

import org.junit.Test;
import static org.Junit.Assert.*;
public class ProductTest {

    // Unit Test 1
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {

        String[] names = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(names, sales);

        assertEquals(153, product.GetTotalProductsSold());
    }

    // Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

        String[] names = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(names, sales);

        assertEquals(
            17.0,
            product.GetAverageProductsSold(),
            0.01
        );
    }
}
