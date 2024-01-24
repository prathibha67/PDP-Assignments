package CoffeeOrdering;

public class Factory {
    private PlainHotCoffeeFactory plainHotCoffeeFactory=new PlainHotCoffeeFactory();
    private  ColdCoffeeFactory coldCoffeeFactory=new ColdCoffeeFactory();
    private BeatenCoffeeFactory beatenCoffeeFactory=new BeatenCoffeeFactory();
    Coffee coffeeSelector(String order)
    {
        if(order.equals("PLAIN COFFEE"))
        {
            return plainHotCoffeeFactory.createCoffee();
        }
        else if(order.equals("COLD COFFEE")) {
            return coldCoffeeFactory.createCoffee();
        }
            return beatenCoffeeFactory.createCoffee();
    }
}
