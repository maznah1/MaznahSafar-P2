package Controller;


import Model.ApiResponse;
import Model.Product;
import Service.ServiceProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

import static Service.ServiceProduct.*;

@Controller
@RequestMapping("/aip/v1/product")
public class ControllerProduct {


    private final ServiceProduct serviceProduct;

    public ControllerProduct(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }


    @GetMapping("/Prodect")
    public ResponseEntity getprodect() {
        ArrayList<Product>Pro=ServiceProduct.getPro();
        return ResponseEntity.status(200).body(Pro);



    }
    @PostMapping("/Prodect")

    public ResponseEntity addProdectt(@RequestBody  @Valid Product product,Errors errors ){


        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        ServiceProduct.addpro (product);

            return ResponseEntity.status(201).body(new ApiResponse("Invalid user id",201));
        }


        @PutMapping("/Prodect/{index}")
    public ResponseEntity updateprodet(@RequestBody @Valid Product product,@PathVariable int index,Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        ServiceProduct.updatPro(index,product);
        return ResponseEntity.status(201).body(new ApiResponse("Prodect update",201));
        }


        @DeleteMapping("/Prodect")
        public ResponseEntity deletprodct(@PathVariable @Valid int index){
        ServiceProduct.deletPro(index);
            return ResponseEntity.status(201).body(new ApiResponse("Prodect update",201));
        }
        }












