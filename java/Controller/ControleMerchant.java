package Controller;


import Model.ApiResponse;
import Model.Merchant;
import Service.ServicMerchant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("api/v1/Merchant")
public class ControleMerchant {

    private final ServicMerchant servicMerchant;


    public ControleMerchant(ServicMerchant servicMerchant) {
        this.servicMerchant = servicMerchant;
    }


    @GetMapping("/Merchant")
    public ResponseEntity getMerchant() {
        ArrayList<Merchant> Mer = ServicMerchant.getMer();
        return ResponseEntity.status(200).body(Mer);

    }

    @PutMapping("/Merchant")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        ServicMerchant.addMer(merchant);

        return ResponseEntity.status(201).body(new ApiResponse("Invalid user id", 201));

    }

    @PutMapping("/Merchant/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant, @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        ServicMerchant.updateMer(index, merchant);
        return ResponseEntity.status(201).body(new ApiResponse("Merchant upate", 201));

    }

    @DeleteMapping("/Merchant")
    public ResponseEntity daletMerchant(@PathVariable @Valid int index) {

        ServicMerchant.deletMer(index);
        return ResponseEntity.status(201).body(new ApiResponse("Merchant delet", 201));
    }



}
