package Service;


import Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceCategory {
    private  static  ArrayList<Category>categ=new ArrayList<>();


    public static ArrayList<Category> getCategor() {
        return categ;
    }



    public static void addCat(Category category) {

                categ.add(category);


    }

    public static void updateCatagor(int index, Category category) {

        categ.set(index,category);


    }

    public static void deletCatag(int index) {

        categ.remove(index);
    }
}
