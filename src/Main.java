import java.time.LocalDate;
import java.util.Map;


public class Main {
    public static void main(String[] args) {


        Product cheese = new Product("Cheese", 100, 10, false, null, true, 0.4);
        Product tv = new Product("TV", 500, 2, false, null, true, 10);
        Product milk = new Product("Milk", 2.5, 10, true, LocalDate.now().plusDays(5), false, 0);
        Product bread = new Product("Bread", 1.5, 5, true, LocalDate.now().minusDays(1), false, 0);
        Product scratchCard = new Product("Scratch Card", 50, 5, false, null, false, 0);
        Product biscuits = new Product("Biscuits", 150, 3, false, null, true, 0.7);

        Customer customer = new Customer("Alice", 800.0);
        Cart cart = new Cart();
        cart.add(cheese, 1);
        cart.add(bread, 1);
        cart.add(cheese, 3);
        cart.add(milk, 2);
        cart.add(milk, 4);
        cart.add(tv, 3);
        cart.add(scratchCard, 1);
        cart.add(biscuits, 1);
        checkout(customer, cart);
    }
    public static void checkout(Customer customer, Cart cart){
        double totalPackageWeight = 0.0;
        double subtotal = 0.0;
        double shippingRate = 30.0;
        double totalReceiptPrice = 0.0;
        double totalShippingPrice = 0.0;
        System.out.println("** Shipment Notice **");
        for(var entry : cart.getListOfProducts().entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if(product.isShippable())
            {
                totalPackageWeight+=product.getShippingWeight()*quantity;
                System.out.println(quantity + "x " + product.getName() + "\t" +
                        (product.getShippingWeight()*quantity * 1000) + "g");
            }
            subtotal+=product.getPrice()*quantity;
        }
        totalReceiptPrice = subtotal + totalShippingPrice;
        if (totalPackageWeight > 0) {
            System.out.println("Total package weight " + totalPackageWeight + "kg");
        }
        if (customer.getBalance() >= totalReceiptPrice) {
            customer.checkBalance(totalReceiptPrice);
            System.out.println("** Checkout Receipt **");
            System.out.println("----------------------");
            for(var entry : cart.getListOfProducts().entrySet()){
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(quantity + "x " + product.getName() + " " +
                        "\t" + product.getPrice()*quantity);
            }
            System.out.println("----------------------");
            System.out.println("Subtotal\t" + subtotal);
            totalShippingPrice = shippingRate*totalPackageWeight;
            System.out.println("Shipping\t" + totalShippingPrice);
            System.out.println("Amount\t" + totalReceiptPrice);
            System.out.println("----------------------");
        } else {
            System.out.println("There's insufficient balance in your account.");
        }
    }
}
