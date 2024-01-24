package CoffeeOrdering;

public class CrushedCoffeeBeans implements Coffee{
    private Coffee coffee;

    public CrushedCoffeeBeans(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String Description() {
        return coffee.Description()+"CrushedCoffeeBeans+";
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
