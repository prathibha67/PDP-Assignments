package CoffeeOrdering;

public class BeatenCoffee implements Coffee{

    private Coffee coffee;
    public BeatenCoffee() {

    }
    @Override
    public String Description() {
        return "BeatenCoffee+";
    }
    @Override
    public int cost() {
        return 35;
    }
    @Override
    public String temperature() {
        return "WarmCoffee";
    }
}
