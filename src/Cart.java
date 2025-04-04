import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private String name;
    private int quantity;
    private Map<Product, Integer> listOfProducts = new HashMap<>();
    void add(Product product, int quantity){
        if(product.productExpired()){
            System.out.println(product.getName() + " is expired");
            return;
        }
        int productQuantity = listOfProducts.getOrDefault(product,0);
        int availableProductQuantity = product.getQuantity();
        int quantityOfCart = productQuantity + quantity;
        if(quantityOfCart>availableProductQuantity){
            System.out.println("There's insufficient stock from "+ product.getName());
        }
        else{
            listOfProducts.put(product, quantityOfCart);
            System.out.println(product.getName() + " added "+quantityOfCart+" items in cart");
        }

    }
    Map<Product,Integer> getListOfProducts(){
        return listOfProducts;
    }
    void setListOfProducts(Map<Product,Integer> listOfProducts){
        this.listOfProducts = listOfProducts;
    }
}
