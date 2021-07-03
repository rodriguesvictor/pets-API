package one.digital.innovation.petapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    @GetMapping
    public String getBook(){
        return"API Rest!";
    }
}
