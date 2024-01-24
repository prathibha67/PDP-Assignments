package CoffeeOrdering;

public class Chocolate implements Coffee{
    private Coffee coffee;

    public Chocolate(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String Description() {
        return coffee.Description()+"Chocolate+";
    }

    @Override
    public int cost() {
        return coffee.cost()+15;
    }

    @Override
    public String temperature() {
        return coffee.temperature();
    }
}
