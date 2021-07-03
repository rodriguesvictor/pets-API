package one.digital.innovation.petapi.controller;

import one.digital.innovation.petapi.dto.request.PetDTO;
import one.digital.innovation.petapi.dto.response.MessageResponseDTO;
import one.digital.innovation.petapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPet(@RequestBody @Valid PetDTO petDTO){
        return petService.createPet(petDTO);
    }

    @GetMapping
    public List<PetDTO> listAll(){
        return petService.listAll();
    }
}
