package CoffeeOrdering;

public class Cream implements Coffee{
    private Coffee coffee;

    public Cream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String Description() {
        return coffee.Description()+"Cream";
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
