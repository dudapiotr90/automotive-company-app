package pl.dudi.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/product")
@RequiredArgsConstructor
public class ProductController {

    // TODO to implement
    @GetMapping("/opinion")
    public void getProductOpinions() {

    }

    @GetMapping("/opinion/{score}")
    public void getProductOpinion(
        @PathVariable(name = "score") Integer score
    ) {
    }


    @PostMapping("/{productNumber}/opinion")
    public void submitOpinion() {

    }

}
