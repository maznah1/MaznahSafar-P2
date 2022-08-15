package Service;


import Controller.ControllerProduct;
import Model.Merchant;
import Model.Product;
import Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceProduct {
    private static ArrayList<Product>productts=new ArrayList<>();
    public static ArrayList<Product> getPro() {
        return productts;
    }


    public static void  addpro(Product product){
//
                productts.add(product);
//
}
    public static void updatPro(int index, Product product) {
        productts.set(index,product);
    }
    public static void deletPro(int index) {
        productts.remove(index);

    }


    public static void addNwePRo(User user) {
        ArrayList<User>productts=new ArrayList<>();
        productts.add(user);
    }


}


