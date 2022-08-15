package Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data

//
//id ( must not be empty , have to be 3 character long ).
//        name ( must not be empty , have to be 3 length long ).
//        price ( must not be empty , must be positive number ).
//        categoryID ( must not be empty , have to be 3 character long ).


//Product Class: ID, name, price , categoryID.
public class Product {
    @NotNull(message = "Id null")
    @Range(max = 3)
private int IdProduct;


    @NotEmpty(message = "name is empty")
    @Size(max = 3)
public String nameProduct;

    @NotNull(message = "Id null")
    @Positive
public int Price;


    @NotNull
    @Range(max = 3)
private int categoryID;

}
