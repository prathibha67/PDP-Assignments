package CoffeeOrdering;

public class ColdCoffeeFactory implements CoffeeDrink{
    private Coffee coffee;
    @Override
    public Coffee createCoffee() {
        coffee=new Cream(new Chocolate(new CrushedCoffeeBeans(new ColdCoffee())));
        return coffee;
    }
}
