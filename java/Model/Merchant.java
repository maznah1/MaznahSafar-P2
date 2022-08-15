package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Merchant {

//    id ( must not be empty , have to be 3 character long ).
//    name ( must not be empty , have to be 3 length long ).
    @NotNull(message = "id null")
    @Size(max = 3)
    private String Idmerchant;


    @NotEmpty(message = "name empty")
    @Size(max = 3)
    private  String namemerchant;

}
