package Controller;

import Model.ApiResponse;
import Model.Product;
import Model.User;
import Service.ServiceProduct;
import Service.ServiceUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/User")
public class ControlUser {


    private final ServiceUser serviceUser;

    public ControlUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("/User")
    public ResponseEntity getuser(){
        ArrayList<User>useer=ServiceUser.getuseer();
        return  ResponseEntity.status(200).body(useer);

    }

    @PostMapping("/User")
    public ResponseEntity  adduser (@RequestBody @Valid User user,Errors errors){

        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
       ServiceUser.addUse(user);

        return ResponseEntity.status(201).body(new ApiResponse("Invalid user id",201));

    }



    @PutMapping("/User/{index}")
    public ResponseEntity updateuser(@RequestBody @Valid User user,@PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        ServiceUser.updatuser(index,user);
        return ResponseEntity.status(201).body(new ApiResponse("Prodect update",201));

    }

//
    @DeleteMapping("User")
    public ResponseEntity deletuser(@PathVariable int index){
        ServiceUser.deletUserr(index);
        return ResponseEntity.status(201).body(new ApiResponse("Prodect update",201));


    }



}
