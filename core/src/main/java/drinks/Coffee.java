package drinks;

public class Coffee implements IHotDrink{

    public String prepareDrink() {
        return "Coffee is ready!";
    }

    public String getCost() {
        return "2";
    }
}
