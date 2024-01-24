package CoffeeOrdering;

public class PlainHotCoffeeFactory implements CoffeeDrink{
    private Coffee coffee;
    @Override
    public Coffee createCoffee() {
        coffee= new Cream(new Chocolate(new CrushedCoffeeBeans(new PlainHotCoffee())));
        return coffee;
    }
}
