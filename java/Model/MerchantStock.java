package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data

public class MerchantStock {

//    id ( must not be empty , have to be 3 character long ).
//    productid ( must not be empty , have to be 3 character long ).
//    merchantid ( must not be empty , have to be 3 length long ).
//    stock ( must not be empty , have to be more than 10 at start ).
//    User Class :
@NotNull(message = "id null")
@Range(max = 3)
    private String IdmerchantStock;

@NotEmpty(message = "  productid empty")
@Size(max = 3)
    private String  productid;
@NotEmpty(message = "merchantid empty")
@Size(max = 3)
    private String merchantid;
@NotEmpty(message = "Stock empty" )
@Size(min = 10)
    private String stock;

}
