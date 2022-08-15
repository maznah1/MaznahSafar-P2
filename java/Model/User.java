package Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {


//    id ( must not be empty , have to be 3 character long ).
//    username ( must not be empty , have to be 5 length long ).
//    password ( must not be empty , have to be 6 length long , must have characters and digits ).
//    email ( must not be empty , must be valid email ).
//    role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
////    balance ( must not be empty , have to be positive ).
@NotNull(message = "id null")
    @Range(max = 3)
private int Iduser;
@NotEmpty
@Size(max = 3)
private  String  username;

@NotEmpty
@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.*[A-Z]).{6,}$")

   private  String password;

@Email(message = "email empty")
@NotEmpty
private String Email;

@NotEmpty
    @Pattern(regexp = "(admin|Customer)",message = "Role must be in admin or Customer only")
private String role;
@NotEmpty
@Positive
private int balance;


}
