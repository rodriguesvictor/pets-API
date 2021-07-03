package one.digital.innovation.petapi.controller;

import one.digital.innovation.petapi.dto.MessageResponseDTO;
import one.digital.innovation.petapi.entity.Pet;
import one.digital.innovation.petapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }
}
