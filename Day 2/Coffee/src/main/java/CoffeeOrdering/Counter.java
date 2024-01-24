package CoffeeOrdering;

public class Counter {
    public static void main(String[] args) {
        Factory factory=new Factory();
        Coffee coffee= factory.coffeeSelector("COLD COFFEE");
        System.out.println("The Cost of your Coffee is:");
        System.out.println("Rs."+coffee.cost());
        System.out.println("The Description of your Coffee is:");
        System.out.println(coffee.Description());
        System.out.println("The Temperature of your Coffee is:");
        System.out.println(coffee.temperature());
    }
}
