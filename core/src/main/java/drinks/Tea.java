package drinks;

public class Tea implements IHotDrink {
    public String prepareDrink() {
        return "Tea is ready!";
    }

    public String getCost() {
        return "1";
    }
}
