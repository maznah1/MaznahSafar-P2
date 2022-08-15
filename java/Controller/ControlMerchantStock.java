package Controller;

import Model.ApiResponse;
import Model.MerchantStock;
import Model.Product;
import Model.User;
import Service.ServicMerchant;
import Service.ServicMerchantStock;
import Service.ServiceProduct;
import Service.ServiceUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/aip/v1/MerchantStock")
public class ControlMerchantStock {

    public final ServicMerchantStock servicMerchantStock;

    public ControlMerchantStock(ServicMerchantStock servicMerchantStock) {
        this.servicMerchantStock = servicMerchantStock;
    }

    @GetMapping("/MerchantStock")
    public ResponseEntity getMerchantStock() {

        ArrayList<MerchantStock> MerStock = ServicMerchantStock.getMerStock();
        return ResponseEntity.status(200).body(MerStock);
    }


    @PostMapping("/MerchantStock")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        ServicMerchantStock.addMetStock(merchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("Invalid user id", 201));
    }

    @PutMapping("/MerchantStock/{index}")
    public ResponseEntity updataMerchantStock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable int index, Errors errors) {


        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        ServicMerchantStock.updatMerStock(index, merchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("MerchantStock update", 201));
    }


    @DeleteMapping("/MerchantStock")
    public ResponseEntity daletMerchantStock(@PathVariable int index) {
        ServicMerchantStock.daleMerStock(index);
        return ResponseEntity.status(201).body(new ApiResponse("MerchantStock update", 201));


    }

    @PostMapping("/MerchantStock")
    public ResponseEntity addprodect(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        ServiceProduct.addNwePRo(user);
        return ResponseEntity.status(201).body(new ApiResponse("Invalid user id", 201));

    }


    @PostMapping("/MerchantStock/")
    public ResponseEntity Edit(@RequestParam String IdProduct, @RequestParam String Idmerchant, @RequestParam int IdmerchantStock) {


        int isValid = ServicMerchantStock.Edit(IdProduct, Idmerchant, IdmerchantStock);
        if (isValid == 1) {
            return ResponseEntity.status(200).body(new ApiResponse("Done", 200));

        } else if (isValid == 2) {
            return ResponseEntity.status(400).body(new ApiResponse("Error", 400));

        }

//


        return null;
    }
}

