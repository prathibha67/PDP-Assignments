package CoffeeOrdering;

public class ColdCoffee implements Coffee{
    private Coffee coffee;
    public ColdCoffee() {

    }
    @Override
    public String Description() {
        return "ColdCoffee+";
    }
    @Override
    public int cost() {
        return 60;
    }
    @Override
    public String temperature() {
        return "ColdDrink";
    }
}
