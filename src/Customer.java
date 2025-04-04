public class Customer {

    private String name;
    private Double balance;
    Cart cart;

    public Customer(String name, Double balance) {
        this.name = name;
        this.balance = balance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    void checkBalance(double price){
        if(price>balance){
            throw new IllegalArgumentException("There's insufficient balance in your account.");
        }
        else {
            balance-=price;
        }
    }

}
