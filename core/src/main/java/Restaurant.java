import drinks.IHotDrink;

public class Restaurant {

    private IHotDrink hotDrink;

    Restaurant(IHotDrink hotDrink) {

        this.hotDrink = hotDrink;
    }

    String prepareHotDrink() {
        return hotDrink.prepareDrink();
    }
}
