package Controller;


import Model.ApiResponse;
import Model.Category;
import Model.Product;
import Service.ServiceCategory;
import Service.ServiceProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/api/v1/Category")

public class ControlCategory {
    private final ServiceCategory serviceCategory;

    public ControlCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }


    @GetMapping("/Categor")
    public ResponseEntity getcategor() {
        ArrayList<Category> Cat = ServiceCategory.getCategor();
        return ResponseEntity.status(200).body(Cat);
    }


    @PostMapping("/Categor")

    public ResponseEntity addCategor(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }

        ServiceCategory.addCat(category);

        return ResponseEntity.status(201).body(new ApiResponse("Invalid user id",201));
    }


    @PutMapping("/Catagor/{index}")
    public ResponseEntity update(@RequestBody @Valid Category category,@PathVariable int index,Errors errors){

        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        ServiceCategory.updateCatagor(index,category);
        return ResponseEntity.status(201).body(new ApiResponse("Catagor update",201));

    }


    @DeleteMapping("/Catagor")

    public ResponseEntity deletCatagor(@PathVariable @Valid int index){
        ServiceCategory.deletCatag(index);
        return ResponseEntity.status(201).body(new ApiResponse("Prodect update",201));
    }


}









