import drinks.Coffee;
import drinks.Tea;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RestaurantTest {
    @Test
    void prepareTea() {
        Restaurant restaurant = new Restaurant(new Tea());
        Assert.assertEquals("Tea is ready!", restaurant.prepareHotDrink());
    }

    @Test
    void prepareCoffee() {
        Restaurant restaurant = new Restaurant(new Coffee());
        Assert.assertEquals("Coffee is ready!", restaurant.prepareHotDrink());
    }

    @Test
    void calculateBillForDrinks() {
        Bill bill = new Bill();
        bill.setProduct(new Coffee());
        bill.setProduct(new Tea());
        Assert.assertEquals("3.0", bill.getTotalCost());
    }

    @Test
    void billDiscount10percent() {
        Bill bill = new Bill();
        bill.setProduct(new Coffee());
        bill.setProduct(new Tea());
        bill.setDiscount(10);
        Assert.assertEquals("2.7", bill.getTotalCost());
    }

    @Test
    void billDiscount50percent() {
        Bill bill = new Bill();
        bill.setProduct(new Coffee());
        bill.setProduct(new Tea());
        bill.setProduct(new Tea());
        bill.setDiscount(50);
        Assert.assertEquals("2.0", bill.getTotalCost());
    }

    @Test
    void billNegativeDiscount() {
        final Bill bill = new Bill();
        bill.setProduct(new Coffee());
        Executable negativeDiscountTest = () -> bill.setDiscount(-1);
        assertThrows(IllegalArgumentException.class, negativeDiscountTest);
    }

    @Test
    void billZeroDiscount() {
        Bill bill = new Bill();
        bill.setProduct(new Coffee());
        bill.setDiscount(0);
        Assert.assertEquals("2.0", bill.getTotalCost());
    }
}
