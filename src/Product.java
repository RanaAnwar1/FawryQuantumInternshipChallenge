import java.time.LocalDate;
import java.util.Date;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean isExpirable;
    private LocalDate expiryDate;
    private boolean isShippable;
    private double shippingWeight;

    public Product(String name, double price, int quantity, boolean isExpirable, LocalDate expiryDate, boolean isShippable, double shippingWeight) {
        if(isExpirable == true && expiryDate == null)
            throw new IllegalArgumentException("You MUST provide expiry date.");
        if(isShippable == true && shippingWeight <= 0){
            throw new IllegalArgumentException("You MUST provide a positive weight number.");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.expiryDate = expiryDate;
        this.isShippable = isShippable;
        this.shippingWeight = shippingWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpirable() {
        return isExpirable;
    }

    public void setExpirable(boolean expirable) {
        isExpirable = expirable;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public void setShippable(boolean shippable) {
        isShippable = shippable;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }
    boolean productExpired (){
        if(isExpirable == true && expiryDate != null && LocalDate.now().isBefore(expiryDate) == true)
            return false;
        else if(isExpirable == true && expiryDate != null && LocalDate.now().isBefore(expiryDate) == false)
            return true;
        else return false;
    }

}
