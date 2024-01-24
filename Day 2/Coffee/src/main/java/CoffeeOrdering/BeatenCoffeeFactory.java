package CoffeeOrdering;

public class BeatenCoffeeFactory implements CoffeeDrink{
    private Coffee coffee;
    @Override
    public Coffee createCoffee() {
        coffee =new Cream(new Chocolate(new CrushedCoffeeBeans(new BeatenCoffee())));
        return coffee;
    }
}
