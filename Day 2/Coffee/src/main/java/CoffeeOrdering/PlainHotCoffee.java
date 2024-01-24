package CoffeeOrdering;

public class PlainHotCoffee implements Coffee{
    private Coffee coffee;
    public PlainHotCoffee() {

    }
    @Override
    public String Description() {
        return "PlainHotCoffee+";
    }
    @Override
    public int cost() {
        return 50;
    }
    @Override
    public String temperature() {
        return "HotDrink";
    }
}
