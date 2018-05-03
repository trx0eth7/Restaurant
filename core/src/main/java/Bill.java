import drinks.IHotDrink;

import java.util.ArrayList;
import java.util.List;

class Bill {
    private List<IHotDrink> products = new ArrayList<>();
    private int discount;

    void setProduct(IHotDrink product) {
        products.add(product);
    }

    String getTotalCost() {
        double result = 0;
        for (IHotDrink drink : products) {
            result += Integer.parseInt(drink.getCost());
        }
        result -=(result/100) * discount;
        return String.valueOf(result);
    }

    void setDiscount(int discount) {
        if(discount<0) throw new IllegalArgumentException("Discount should be positive");
        this.discount = discount;
    }

}
